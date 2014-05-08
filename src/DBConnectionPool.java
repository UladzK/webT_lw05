import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * Created by aleh on 09.05.14.
 */
public class DBConnectionPool {

    private static Properties property;
    private static DBConnectionPool instance;

    private static String URL;
    private static String user;
    private static String password;
    private static int POOL_SIZE;

    private static List<Connection> freeConnections;

    private DBConnectionPool() {
        readProperties();
        loadDrivers();

        URL = property.getProperty("jdbc.databaseurl");
        user = property.getProperty("jdbc.username");
        password = property.getProperty("jdbc.password");
        POOL_SIZE = Integer.valueOf(property.getProperty("jdbc.pool.size"));

        freeConnections = new ArrayList<Connection>();
    }

    private void loadDrivers() {
        try {
            Driver driver = (Driver)Class.forName(property.getProperty("jdbc.driverClassName")).newInstance();
            DriverManager.registerDriver(driver);
        } catch (Exception e) {
            System.err.println("ERROR in load DB Driver.");
        }
    }

    public static synchronized DBConnectionPool getInstance() {
        if (instance == null) {
            instance = new DBConnectionPool();
        }
        return instance;
    }

    private static void readProperties() {
        FileInputStream fis;
        property = new Properties();
        try {
            fis = new FileInputStream("src/resources/jdbc.properties");
            property.load(fis);
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }

    public synchronized Connection getConnection() throws SQLException {
        Connection con;
        if (!freeConnections.isEmpty()) {
            con = freeConnections.get(freeConnections.size()-1);
            freeConnections.remove(con);
            if (con.isClosed()) {
                con = getConnection();
            }
        } else {
            con = newConnection();
        }
        return con;
    }

    private Connection newConnection() throws SQLException {
        return DriverManager.getConnection(URL, user, password);
    }

    public synchronized void freeConnection(Connection con) {
        if ( (con != null) && (freeConnections.size() <= POOL_SIZE) ) {
            freeConnections.add(con);
        }
    }

    public synchronized void released() {
        Iterator allConnections = freeConnections.iterator();
        while (allConnections.hasNext()) {
            Connection con = (Connection) allConnections.next();
            try {
                con.close();
            } catch (SQLException e) {}
        }
        freeConnections.clear();
    }
}


