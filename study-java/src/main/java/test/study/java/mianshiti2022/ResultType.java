
package test.study.java.mianshiti2022;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;ResultType的 Java 类。
 *
 * &lt;p&gt;以下模式片段指定包含在此类中的预期内容。
 * &lt;pre&gt;
 * &amp;lt;simpleType name="ResultType"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *     &amp;lt;enumeration value="OPERATE-SUCCESS"/&amp;gt;
 *     &amp;lt;enumeration value="OPERATE-FAILED"/&amp;gt;
 *     &amp;lt;enumeration value="OPERATE-WORNING"/&amp;gt;
 *     &amp;lt;enumeration value="OPERATE-INVALID"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
 *
 */
@XmlType(name = "ResultType")
@XmlEnum
public enum ResultType {

    @XmlEnumValue("OPERATE-SUCCESS")
    OPERATE_SUCCESS("OPERATE-SUCCESS"),
    @XmlEnumValue("OPERATE-FAILED")
    OPERATE_FAILED("OPERATE-FAILED"),
    @XmlEnumValue("OPERATE-WORNING")
    OPERATE_WORNING("OPERATE-WORNING"),
    @XmlEnumValue("OPERATE-INVALID")
    OPERATE_INVALID("OPERATE-INVALID");
    private final String value;

    ResultType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ResultType fromValue(String v) {
        for (ResultType c: ResultType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
