
package test.study.java.mianshiti2022;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;SingleSensor complex type的 Java 类。
 *
 * &lt;p&gt;以下模式片段指定包含在此类中的预期内容。
 *
 * &lt;pre&gt;
 * &amp;lt;complexType name="SingleSensor"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="SenSorNo" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="DeviceIP" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="DeviceType" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="DeviceLaneNo" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="bUsed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SingleSensor", propOrder = {
    "senSorNo",
    "deviceIP",
    "deviceType",
    "deviceLaneNo",
    "bUsed"
})
public class SingleSensor {

    @XmlElement(name = "SenSorNo")
    protected int senSorNo;
    @XmlElement(name = "DeviceIP", required = true)
    protected String deviceIP;
    @XmlElement(name = "DeviceType")
    protected int deviceType;
    @XmlElement(name = "DeviceLaneNo")
    protected int deviceLaneNo;
    protected boolean bUsed;

    /**
     * 获取senSorNo属性的值。
     *
     */
    public int getSenSorNo() {
        return senSorNo;
    }

    /**
     * 设置senSorNo属性的值。
     *
     */
    public void setSenSorNo(int value) {
        this.senSorNo = value;
    }

    /**
     * 获取deviceIP属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDeviceIP() {
        return deviceIP;
    }

    /**
     * 设置deviceIP属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDeviceIP(String value) {
        this.deviceIP = value;
    }

    /**
     * 获取deviceType属性的值。
     *
     */
    public int getDeviceType() {
        return deviceType;
    }

    /**
     * 设置deviceType属性的值。
     *
     */
    public void setDeviceType(int value) {
        this.deviceType = value;
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
     * 获取bUsed属性的值。
     *
     */
    public boolean isBUsed() {
        return bUsed;
    }

    /**
     * 设置bUsed属性的值。
     *
     */
    public void setBUsed(boolean value) {
        this.bUsed = value;
    }

}
