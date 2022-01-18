
package test.study.java.mianshiti2022;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;TimeSpand complex type的 Java 类。
 *
 * &lt;p&gt;以下模式片段指定包含在此类中的预期内容。
 *
 * &lt;pre&gt;
 * &amp;lt;complexType name="TimeSpand"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="starttime" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="endtime" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="paramA" type="{http://www.w3.org/2001/XMLSchema}double"/&amp;gt;
 *         &amp;lt;element name="paramB" type="{http://www.w3.org/2001/XMLSchema}double"/&amp;gt;
 *         &amp;lt;element name="comprehensive-factor" type="{http://www.w3.org/2001/XMLSchema}double"/&amp;gt;
 *         &amp;lt;element name="invalidFlowRate" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="imaxCycle" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeSpand", propOrder = {
    "starttime",
    "endtime",
    "paramA",
    "paramB",
    "comprehensiveFactor",
    "invalidFlowRate",
    "imaxCycle"
})
public class TimeSpand {

    @XmlElement(required = true)
    protected String starttime;
    @XmlElement(required = true)
    protected String endtime;
    protected double paramA;
    protected double paramB;
    @XmlElement(name = "comprehensive-factor")
    protected double comprehensiveFactor;
    protected int invalidFlowRate;
    protected int imaxCycle;

    /**
     * 获取starttime属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStarttime() {
        return starttime;
    }

    /**
     * 设置starttime属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStarttime(String value) {
        this.starttime = value;
    }

    /**
     * 获取endtime属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEndtime() {
        return endtime;
    }

    /**
     * 设置endtime属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEndtime(String value) {
        this.endtime = value;
    }

    /**
     * 获取paramA属性的值。
     *
     */
    public double getParamA() {
        return paramA;
    }

    /**
     * 设置paramA属性的值。
     *
     */
    public void setParamA(double value) {
        this.paramA = value;
    }

    /**
     * 获取paramB属性的值。
     *
     */
    public double getParamB() {
        return paramB;
    }

    /**
     * 设置paramB属性的值。
     *
     */
    public void setParamB(double value) {
        this.paramB = value;
    }

    /**
     * 获取comprehensiveFactor属性的值。
     *
     */
    public double getComprehensiveFactor() {
        return comprehensiveFactor;
    }

    /**
     * 设置comprehensiveFactor属性的值。
     *
     */
    public void setComprehensiveFactor(double value) {
        this.comprehensiveFactor = value;
    }

    /**
     * 获取invalidFlowRate属性的值。
     *
     */
    public int getInvalidFlowRate() {
        return invalidFlowRate;
    }

    /**
     * 设置invalidFlowRate属性的值。
     *
     */
    public void setInvalidFlowRate(int value) {
        this.invalidFlowRate = value;
    }

    /**
     * 获取imaxCycle属性的值。
     *
     */
    public int getImaxCycle() {
        return imaxCycle;
    }

    /**
     * 设置imaxCycle属性的值。
     *
     */
    public void setImaxCycle(int value) {
        this.imaxCycle = value;
    }

}
