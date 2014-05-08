import generated.Holder;
import generated.Kind;
import generated.Weapon;
import generated.Weapons;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Launcher {


    public static void main(String[] args) {

        try {
            Connection connection = DBConnectionPool.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM WEAPONS");
            ResultSet resultSet = statement.executeQuery();

            ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
            while (resultSet.next()) {
                Weapon weapon = new Weapon();

                String serialId = resultSet.getString("serialId");
                String weapon_name = resultSet.getString("name");
                String kind = resultSet.getString("kind");
                int capacity = resultSet.getInt("holder_capacity");
                int damage = resultSet.getInt("damage");
                float caliber = resultSet.getFloat("caliber");

                weapon.setDamage(new BigDecimal(damage));
                weapon.setName(weapon_name);
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

            DBConnectionPool.getInstance().freeConnection(connection);
        } catch (Exception ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnectionPool.getInstance().released();
        }

    }

}