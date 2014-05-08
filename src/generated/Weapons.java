
package generated;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="weapon" type="{http://www.example.com/Weapon}Weapon" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "weapon"
})
@XmlRootElement(name = "Weapons", namespace = "http://www.example.com/Weapon")
public class Weapons {

    @XmlElement(required = true)
    protected List<Weapon> weapon;

    /**
     * Gets the value of the weapon property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the weapon property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWeapon().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Weapon }
     * 
     * 
     */
    public List<Weapon> getWeapon() {
        if (weapon == null) {
            weapon = new ArrayList<Weapon>();
        }
        return this.weapon;
    }

    public void setWeapon(List<Weapon> weapon) {
        this.weapon = weapon;
    }
}
