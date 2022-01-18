
package test.study.java.mianshiti2022;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;


/**
 * &lt;p&gt;CrossInfoRsp complex type的 Java 类。
 *
 * &lt;p&gt;以下模式片段指定包含在此类中的预期内容。
 *
 * &lt;pre&gt;
 * &amp;lt;complexType name="CrossInfoRsp"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="resultType" type="{http://tempuri.org/ns.xsd}ResultType"/&amp;gt;
 *         &amp;lt;element name="errMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="crossInfoList" type="{http://tempuri.org/ns.xsd}CrossInfo" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CrossInfoRsp", propOrder = {
    "resultType",
    "errMsg",
    "crossInfoList"
})
public class CrossInfoRsp {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ResultType resultType;
    protected String errMsg;
    protected List<CrossInfo> crossInfoList;

    /**
     * 获取resultType属性的值。
     *
     * @return
     *     possible object is
     *     {@link ResultType }
     *
     */
    public ResultType getResultType() {
        return resultType;
    }

    /**
     * 设置resultType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link ResultType }
     *
     */
    public void setResultType(ResultType value) {
        this.resultType = value;
    }

    /**
     * 获取errMsg属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getErrMsg() {
        return errMsg;
    }

    /**
     * 设置errMsg属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setErrMsg(String value) {
        this.errMsg = value;
    }

    /**
     * Gets the value of the crossInfoList property.
     *
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the crossInfoList property.
     *
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getCrossInfoList().add(newItem);
     * &lt;/pre&gt;
     *
     *
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link CrossInfo }
     *
     *
     */
    public List<CrossInfo> getCrossInfoList() {
        if (crossInfoList == null) {
            crossInfoList = new ArrayList<CrossInfo>();
        }
        return this.crossInfoList;
    }

}
