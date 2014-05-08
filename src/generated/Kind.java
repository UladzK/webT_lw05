
package generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Kind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Kind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Gun"/>
 *     &lt;enumeration value="Rifle"/>
 *     &lt;enumeration value="Bazooka"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Kind", namespace = "http://www.example.com/Weapon")
@XmlEnum
public enum Kind {

    @XmlEnumValue("Gun")
    GUN("Gun"),
    @XmlEnumValue("Rifle")
    RIFLE("Rifle"),
    @XmlEnumValue("Bazooka")
    BAZOOKA("Bazooka");
    private final String value;

    Kind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Kind fromValue(String v) {
        for (Kind c: Kind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
