
package test.study.java.mianshiti2022;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Lane2Sensors complex type的 Java 类。
 *
 * &lt;p&gt;以下模式片段指定包含在此类中的预期内容。
 *
 * &lt;pre&gt;
 * &amp;lt;complexType name="Lane2Sensors"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="operaType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="laneNo" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="sensorsNo" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="deviceId" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="deviceLaneNo" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="laneweight" type="{http://www.w3.org/2001/XMLSchema}double"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Lane2Sensors", propOrder = {
    "operaType",
    "laneNo",
    "sensorsNo",
    "deviceId",
    "deviceLaneNo",
    "laneweight"
})
public class Lane2Sensors {

    protected Integer operaType;
    @XmlElement(required = true)
    protected String laneNo;
    @XmlElement(required = true)
    protected String sensorsNo;
    @XmlElement(required = true)
    protected String deviceId;
    protected int deviceLaneNo;
    protected double laneweight;

    /**
     * 获取operaType属性的值。
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getOperaType() {
        return operaType;
    }

    /**
     * 设置operaType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setOperaType(Integer value) {
        this.operaType = value;
    }

    /**
     * 获取laneNo属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLaneNo() {
        return laneNo;
    }

    /**
     * 设置laneNo属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLaneNo(String value) {
        this.laneNo = value;
    }

    /**
     * 获取sensorsNo属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSensorsNo() {
        return sensorsNo;
    }

    /**
     * 设置sensorsNo属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSensorsNo(String value) {
        this.sensorsNo = value;
    }

    /**
     * 获取deviceId属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * 设置deviceId属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDeviceId(String value) {
        this.deviceId = value;
    }

    /**
     * 获取deviceLaneNo属性的值。
     *
     */
    public int getDeviceLaneNo() {
        return deviceLaneNo;
    }

    /**
     * 设置deviceLaneNo属性的值。
     *
     */
    public void setDeviceLaneNo(int value) {
        this.deviceLaneNo = value;
    }

    /**
     * 获取laneweight属性的值。
     *
     */
    public double getLaneweight() {
        return laneweight;
    }

    /**
     * 设置laneweight属性的值。
     *
     */
    public void setLaneweight(double value) {
        this.laneweight = value;
    }

}
