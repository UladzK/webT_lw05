
package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;


/**
 * <p>Java class for Holder complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Holder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="capacity" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="caliber" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Holder", namespace = "http://www.example.com/Weapon", propOrder = {
    "capacity",
    "caliber"
})
public class Holder {

    @XmlElement(required = true)
    protected BigInteger capacity;
    protected float caliber;

    /**
     * Gets the value of the capacity property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCapacity() {
        return capacity;
    }

    /**
     * Sets the value of the capacity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCapacity(BigInteger value) {
        this.capacity = value;
    }

    /**
     * Gets the value of the caliber property.
     * 
     */
    public float getCaliber() {
        return caliber;
    }

    /**
     * Sets the value of the caliber property.
     * 
     */
    public void setCaliber(float value) {
        this.caliber = value;
    }

}
