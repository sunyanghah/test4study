
package test.study.java.mianshiti2022;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;SensorsEle complex type的 Java 类。
 *
 * &lt;p&gt;以下模式片段指定包含在此类中的预期内容。
 *
 * &lt;pre&gt;
 * &amp;lt;complexType name="SensorsEle"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="eleID" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="operaType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="crossID" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="laneNo" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="x" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="y" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="angle" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="elesize" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="bWalk" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="SensorLst" type="{http://tempuri.org/ns.xsd}SingleSensor" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SensorsEle", propOrder = {
    "eleID",
    "operaType",
    "crossID",
    "laneNo",
    "x",
    "y",
    "angle",
    "elesize",
    "bWalk",
    "sensorLst"
})
public class SensorsEle {

    protected int eleID;
    protected Integer operaType;
    protected int crossID;
    protected int laneNo;
    protected int x;
    protected int y;
    protected int angle;
    protected int elesize;
    protected int bWalk;
    @XmlElement(name = "SensorLst")
    protected List<SingleSensor> sensorLst;

    /**
     * 获取eleID属性的值。
     *
     */
    public int getEleID() {
        return eleID;
    }

    /**
     * 设置eleID属性的值。
     *
     */
    public void setEleID(int value) {
        this.eleID = value;
    }

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
     * 获取crossID属性的值。
     *
     */
    public int getCrossID() {
        return crossID;
    }

    /**
     * 设置crossID属性的值。
     *
     */
    public void setCrossID(int value) {
        this.crossID = value;
    }

    /**
     * 获取laneNo属性的值。
     *
     */
    public int getLaneNo() {
        return laneNo;
    }

    /**
     * 设置laneNo属性的值。
     *
     */
    public void setLaneNo(int value) {
        this.laneNo = value;
    }

    /**
     * 获取x属性的值。
     *
     */
    public int getX() {
        return x;
    }

    /**
     * 设置x属性的值。
     *
     */
    public void setX(int value) {
        this.x = value;
    }

    /**
     * 获取y属性的值。
     *
     */
    public int getY() {
        return y;
    }

    /**
     * 设置y属性的值。
     *
     */
    public void setY(int value) {
        this.y = value;
    }

    /**
     * 获取angle属性的值。
     *
     */
    public int getAngle() {
        return angle;
    }

    /**
     * 设置angle属性的值。
     *
     */
    public void setAngle(int value) {
        this.angle = value;
    }

    /**
     * 获取elesize属性的值。
     *
     */
    public int getElesize() {
        return elesize;
    }

    /**
     * 设置elesize属性的值。
     *
     */
    public void setElesize(int value) {
        this.elesize = value;
    }

    /**
     * 获取bWalk属性的值。
     *
     */
    public int getBWalk() {
        return bWalk;
    }

    /**
     * 设置bWalk属性的值。
     *
     */
    public void setBWalk(int value) {
        this.bWalk = value;
    }

    /**
     * Gets the value of the sensorLst property.
     *
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the sensorLst property.
     *
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getSensorLst().add(newItem);
     * &lt;/pre&gt;
     *
     *
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link SingleSensor }
     *
     *
     */
    public List<SingleSensor> getSensorLst() {
        if (sensorLst == null) {
            sensorLst = new ArrayList<SingleSensor>();
        }
        return this.sensorLst;
    }

}
