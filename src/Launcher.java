import generated.Holder;
import generated.Kind;
import generated.Weapon;
import generated.Weapons;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Launcher {

    private static Properties property;

    public static void main(String[] args) {

        readProperties();

        Connection connection = null;

        String url = property.getProperty("jdbc.databaseurl");
        String name = property.getProperty("jdbc.username");
        String password = property.getProperty("jdbc.password");

        try {

            Class.forName(property.getProperty("jdbc.driverClassName"));
            connection = DriverManager.getConnection(url, name, password);

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM WEAPONS");
            ResultSet resultSet = statement.executeQuery();

            ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
            while (resultSet.next()) {
                Weapon weapon = new Weapon();

                String serialId = resultSet.getString("serialId");
                String weap_name = resultSet.getString("name");
                String kind = resultSet.getString("kind");
                int capacity = resultSet.getInt("holder_capacity");
                int damage = resultSet.getInt("damage");
                float caliber = resultSet.getFloat("caliber");

                weapon.setDamage(new BigDecimal(damage));
                weapon.setName(weap_name);
                weapon.setSerialId(serialId);
                Holder holder = new Holder();
                holder.setCaliber(caliber);
                holder.setCapacity(BigInteger.valueOf(capacity));

                weapon.setHolder(holder);
                weapon.setKind(Kind.fromValue(kind));

                weaponList.add(weapon);
            }

            JAXBContext context = JAXBContext.newInstance(Weapons.class);
            Marshaller m = context.createMarshaller();

            Weapons weapons = new Weapons();
            weapons.setWeapon(weaponList);

            m.marshal(weapons, new FileOutputStream("generated.xml"));

        } catch (Exception ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

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
}