
package test.study.java.mianshiti2022;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;PhaseArrowEle complex type的 Java 类。
 *
 * &lt;p&gt;以下模式片段指定包含在此类中的预期内容。
 *
 * &lt;pre&gt;
 * &amp;lt;complexType name="PhaseArrowEle"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="eleID" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="operaType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="crossID" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="x" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="y" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="angle" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="elesize" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="phaseType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="phaseID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="phaseName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="channelNo" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="lampType" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="carChecIdList" type="{http://tempuri.org/ns.xsd}Lane2Sensors" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="eleType" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="laneDirection" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="roadlevel" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="bSigPhase-RT" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="laneNo" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="laneweight" type="{http://www.w3.org/2001/XMLSchema}double"/&amp;gt;
 *         &amp;lt;element name="iSatFlow" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhaseArrowEle", propOrder = {
    "eleID",
    "operaType",
    "crossID",
    "x",
    "y",
    "angle",
    "elesize",
    "phaseType",
    "phaseID",
    "phaseName",
    "channelNo",
    "lampType",
    "carChecIdList",
    "eleType",
    "laneDirection",
    "roadlevel",
    "bSigPhaseRT",
    "laneNo",
    "laneweight",
    "iSatFlow"
})
public class PhaseArrowEle {

    protected int eleID;
    protected Integer operaType;
    protected int crossID;
    protected int x;
    protected int y;
    protected int angle;
    protected int elesize;
    protected Integer phaseType;
    protected Integer phaseID;
    protected String phaseName;
    protected int channelNo;
    protected int lampType;
    protected List<Lane2Sensors> carChecIdList;
    protected int eleType;
    protected int laneDirection;
    protected int roadlevel;
    @XmlElement(name = "bSigPhase-RT")
    protected int bSigPhaseRT;
    protected int laneNo;
    protected double laneweight;
    protected int iSatFlow;

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
     * 获取phaseType属性的值。
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getPhaseType() {
        return phaseType;
    }

    /**
     * 设置phaseType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setPhaseType(Integer value) {
        this.phaseType = value;
    }

    /**
     * 获取phaseID属性的值。
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getPhaseID() {
        return phaseID;
    }

    /**
     * 设置phaseID属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setPhaseID(Integer value) {
        this.phaseID = value;
    }

    /**
     * 获取phaseName属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPhaseName() {
        return phaseName;
    }

    /**
     * 设置phaseName属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPhaseName(String value) {
        this.phaseName = value;
    }

    /**
     * 获取channelNo属性的值。
     *
     */
    public int getChannelNo() {
        return channelNo;
    }

    /**
     * 设置channelNo属性的值。
     *
     */
    public void setChannelNo(int value) {
        this.channelNo = value;
    }

    /**
     * 获取lampType属性的值。
     *
     */
    public int getLampType() {
        return lampType;
    }

    /**
     * 设置lampType属性的值。
     *
     */
    public void setLampType(int value) {
        this.lampType = value;
    }

    /**
     * Gets the value of the carChecIdList property.
     *
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the carChecIdList property.
     *
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getCarChecIdList().add(newItem);
     * &lt;/pre&gt;
     *
     *
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link Lane2Sensors }
     *
     *
     */
    public List<Lane2Sensors> getCarChecIdList() {
        if (carChecIdList == null) {
            carChecIdList = new ArrayList<Lane2Sensors>();
        }
        return this.carChecIdList;
    }

    /**
     * 获取eleType属性的值。
     *
     */
    public int getEleType() {
        return eleType;
    }

    /**
     * 设置eleType属性的值。
     *
     */
    public void setEleType(int value) {
        this.eleType = value;
    }

    /**
     * 获取laneDirection属性的值。
     *
     */
    public int getLaneDirection() {
        return laneDirection;
    }

    /**
     * 设置laneDirection属性的值。
     *
     */
    public void setLaneDirection(int value) {
        this.laneDirection = value;
    }

    /**
     * 获取roadlevel属性的值。
     *
     */
    public int getRoadlevel() {
        return roadlevel;
    }

    /**
     * 设置roadlevel属性的值。
     *
     */
    public void setRoadlevel(int value) {
        this.roadlevel = value;
    }

    /**
     * 获取bSigPhaseRT属性的值。
     *
     */
    public int getBSigPhaseRT() {
        return bSigPhaseRT;
    }

    /**
     * 设置bSigPhaseRT属性的值。
     *
     */
    public void setBSigPhaseRT(int value) {
        this.bSigPhaseRT = value;
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

    /**
     * 获取iSatFlow属性的值。
     *
     */
    public int getISatFlow() {
        return iSatFlow;
    }

    /**
     * 设置iSatFlow属性的值。
     *
     */
    public void setISatFlow(int value) {
        this.iSatFlow = value;
    }

}
