
package generated;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;


/**
 * <p>Java class for Weapon complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Weapon">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="damage" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="holder" type="{http://www.example.com/Weapon}Holder"/>
 *       &lt;/sequence>
 *       &lt;attribute name="serialId" use="required" type="{http://www.example.com/Weapon}SerialId" />
 *       &lt;attribute name="kind" use="required" type="{http://www.example.com/Weapon}Kind" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Weapon", namespace = "http://www.example.com/Weapon", propOrder = {
    "name",
    "damage",
    "holder"
})
public class Weapon {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected BigDecimal damage;
    @XmlElement(required = true)
    protected Holder holder;
    @XmlAttribute(name = "serialId", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String serialId;
    @XmlAttribute(name = "kind", required = true)
    protected Kind kind;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the damage property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDamage() {
        return damage;
    }

    /**
     * Sets the value of the damage property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDamage(BigDecimal value) {
        this.damage = value;
    }

    /**
     * Gets the value of the holder property.
     * 
     * @return
     *     possible object is
     *     {@link Holder }
     *     
     */
    public Holder getHolder() {
        return holder;
    }

    /**
     * Sets the value of the holder property.
     * 
     * @param value
     *     allowed object is
     *     {@link Holder }
     *     
     */
    public void setHolder(Holder value) {
        this.holder = value;
    }

    /**
     * Gets the value of the serialId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerialId() {
        return serialId;
    }

    /**
     * Sets the value of the serialId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialId(String value) {
        this.serialId = value;
    }

    /**
     * Gets the value of the kind property.
     * 
     * @return
     *     possible object is
     *     {@link Kind }
     *     
     */
    public Kind getKind() {
        return kind;
    }

    /**
     * Sets the value of the kind property.
     * 
     * @param value
     *     allowed object is
     *     {@link Kind }
     *     
     */
    public void setKind(Kind value) {
        this.kind = value;
    }

}
