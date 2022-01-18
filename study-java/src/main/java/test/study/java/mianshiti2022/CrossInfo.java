
package test.study.java.mianshiti2022;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;


/**
 * &lt;p&gt;CrossInfo complex type的 Java 类。
 *
 * &lt;p&gt;以下模式片段指定包含在此类中的预期内容。
 *
 * &lt;pre&gt;
 * &amp;lt;complexType name="CrossInfo"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="crossingID" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="crossingIndex" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="crossingName" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="subRegionID" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="tmpID" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="iOMSID" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="dateTimeType" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="delayTime" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="StartlossTime" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="dHeadway" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="iDeviceType" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="timespanList" type="{http://tempuri.org/ns.xsd}TimeSpand" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="longitude" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="latitude" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="viewInMap" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="signalIp" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="signalPort" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="suppler" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="specifications" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="createTime" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="updateTime" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="installTime" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="MaintainerName" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="MaintainerPhone" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="MaxTraffic" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="sigVersion" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="sigPassWd" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="RoadNameEles" type="{http://tempuri.org/ns.xsd}RoadNameEle" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="jumpArrows" type="{http://tempuri.org/ns.xsd}JumpArrowEle" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="phaseArrows" type="{http://tempuri.org/ns.xsd}PhaseArrowEle" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Sensors" type="{http://tempuri.org/ns.xsd}SensorsEle" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Monitorys" type="{http://tempuri.org/ns.xsd}MonitoryEle" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CrossInfo", propOrder = {
    "crossingID",
    "crossingIndex",
    "crossingName",
    "subRegionID",
    "tmpID",
    "iomsid",
    "dateTimeType",
    "delayTime",
    "startlossTime",
    "dHeadway",
    "iDeviceType",
    "timespanList",
    "longitude",
    "latitude",
    "viewInMap",
    "signalIp",
    "signalPort",
    "suppler",
    "specifications",
    "createTime",
    "updateTime",
    "installTime",
    "maintainerName",
    "maintainerPhone",
    "maxTraffic",
    "sigVersion",
    "sigPassWd",
    "roadNameEles",
    "jumpArrows",
    "phaseArrows",
    "sensors",
    "monitorys"
})
public class CrossInfo {

    protected int crossingID;
    @XmlElement(required = true)
    protected String crossingIndex;
    @XmlElement(required = true)
    protected String crossingName;
    protected int subRegionID;
    protected int tmpID;
    @XmlElement(name = "iOMSID")
    protected int iomsid;
    protected int dateTimeType;
    protected int delayTime;
    @XmlElement(name = "StartlossTime")
    protected int startlossTime;
    protected int dHeadway;
    protected int iDeviceType;
    protected List<TimeSpand> timespanList;
    @XmlElement(required = true)
    protected String longitude;
    @XmlElement(required = true)
    protected String latitude;
    protected boolean viewInMap;
    @XmlElement(required = true)
    protected String signalIp;
    protected int signalPort;
    @XmlElement(required = true)
    protected String suppler;
    @XmlElement(required = true)
    protected String specifications;
    @XmlElement(required = true)
    protected String createTime;
    @XmlElement(required = true)
    protected String updateTime;
    @XmlElement(required = true)
    protected String installTime;
    @XmlElement(name = "MaintainerName", required = true)
    protected String maintainerName;
    @XmlElement(name = "MaintainerPhone", required = true)
    protected String maintainerPhone;
    @XmlElement(name = "MaxTraffic")
    protected int maxTraffic;
    @XmlElement(required = true)
    protected String sigVersion;
    @XmlElement(required = true)
    protected String sigPassWd;
    @XmlElement(name = "RoadNameEles")
    protected List<RoadNameEle> roadNameEles;
    protected List<JumpArrowEle> jumpArrows;
    protected List<PhaseArrowEle> phaseArrows;
    @XmlElement(name = "Sensors")
    protected List<SensorsEle> sensors;
    @XmlElement(name = "Monitorys")
    protected List<MonitoryEle> monitorys;

    /**
     * 获取crossingID属性的值。
     *
     */
    public int getCrossingID() {
        return crossingID;
    }

    /**
     * 设置crossingID属性的值。
     *
     */
    public void setCrossingID(int value) {
        this.crossingID = value;
    }

    /**
     * 获取crossingIndex属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCrossingIndex() {
        return crossingIndex;
    }

    /**
     * 设置crossingIndex属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCrossingIndex(String value) {
        this.crossingIndex = value;
    }

    /**
     * 获取crossingName属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCrossingName() {
        return crossingName;
    }

    /**
     * 设置crossingName属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCrossingName(String value) {
        this.crossingName = value;
    }

    /**
     * 获取subRegionID属性的值。
     *
     */
    public int getSubRegionID() {
        return subRegionID;
    }

    /**
     * 设置subRegionID属性的值。
     *
     */
    public void setSubRegionID(int value) {
        this.subRegionID = value;
    }

    /**
     * 获取tmpID属性的值。
     *
     */
    public int getTmpID() {
        return tmpID;
    }

    /**
     * 设置tmpID属性的值。
     *
     */
    public void setTmpID(int value) {
        this.tmpID = value;
    }

    /**
     * 获取iomsid属性的值。
     *
     */
    public int getIOMSID() {
        return iomsid;
    }

    /**
     * 设置iomsid属性的值。
     *
     */
    public void setIOMSID(int value) {
        this.iomsid = value;
    }

    /**
     * 获取dateTimeType属性的值。
     *
     */
    public int getDateTimeType() {
        return dateTimeType;
    }

    /**
     * 设置dateTimeType属性的值。
     *
     */
    public void setDateTimeType(int value) {
        this.dateTimeType = value;
    }

    /**
     * 获取delayTime属性的值。
     *
     */
    public int getDelayTime() {
        return delayTime;
    }

    /**
     * 设置delayTime属性的值。
     *
     */
    public void setDelayTime(int value) {
        this.delayTime = value;
    }

    /**
     * 获取startlossTime属性的值。
     *
     */
    public int getStartlossTime() {
        return startlossTime;
    }

    /**
     * 设置startlossTime属性的值。
     *
     */
    public void setStartlossTime(int value) {
        this.startlossTime = value;
    }

    /**
     * 获取dHeadway属性的值。
     *
     */
    public int getDHeadway() {
        return dHeadway;
    }

    /**
     * 设置dHeadway属性的值。
     *
     */
    public void setDHeadway(int value) {
        this.dHeadway = value;
    }

    /**
     * 获取iDeviceType属性的值。
     *
     */
    public int getIDeviceType() {
        return iDeviceType;
    }

    /**
     * 设置iDeviceType属性的值。
     *
     */
    public void setIDeviceType(int value) {
        this.iDeviceType = value;
    }

    /**
     * Gets the value of the timespanList property.
     *
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the timespanList property.
     *
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getTimespanList().add(newItem);
     * &lt;/pre&gt;
     *
     *
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link TimeSpand }
     *
     *
     */
    public List<TimeSpand> getTimespanList() {
        if (timespanList == null) {
            timespanList = new ArrayList<TimeSpand>();
        }
        return this.timespanList;
    }

    /**
     * 获取longitude属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * 设置longitude属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLongitude(String value) {
        this.longitude = value;
    }

    /**
     * 获取latitude属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 设置latitude属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLatitude(String value) {
        this.latitude = value;
    }

    /**
     * 获取viewInMap属性的值。
     *
     */
    public boolean isViewInMap() {
        return viewInMap;
    }

    /**
     * 设置viewInMap属性的值。
     *
     */
    public void setViewInMap(boolean value) {
        this.viewInMap = value;
    }

    /**
     * 获取signalIp属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSignalIp() {
        return signalIp;
    }

    /**
     * 设置signalIp属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSignalIp(String value) {
        this.signalIp = value;
    }

    /**
     * 获取signalPort属性的值。
     *
     */
    public int getSignalPort() {
        return signalPort;
    }

    /**
     * 设置signalPort属性的值。
     *
     */
    public void setSignalPort(int value) {
        this.signalPort = value;
    }

    /**
     * 获取suppler属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSuppler() {
        return suppler;
    }

    /**
     * 设置suppler属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSuppler(String value) {
        this.suppler = value;
    }

    /**
     * 获取specifications属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSpecifications() {
        return specifications;
    }

    /**
     * 设置specifications属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSpecifications(String value) {
        this.specifications = value;
    }

    /**
     * 获取createTime属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置createTime属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCreateTime(String value) {
        this.createTime = value;
    }

    /**
     * 获取updateTime属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置updateTime属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUpdateTime(String value) {
        this.updateTime = value;
    }

    /**
     * 获取installTime属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getInstallTime() {
        return installTime;
    }

    /**
     * 设置installTime属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setInstallTime(String value) {
        this.installTime = value;
    }

    /**
     * 获取maintainerName属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMaintainerName() {
        return maintainerName;
    }

    /**
     * 设置maintainerName属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMaintainerName(String value) {
        this.maintainerName = value;
    }

    /**
     * 获取maintainerPhone属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMaintainerPhone() {
        return maintainerPhone;
    }

    /**
     * 设置maintainerPhone属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMaintainerPhone(String value) {
        this.maintainerPhone = value;
    }

    /**
     * 获取maxTraffic属性的值。
     *
     */
    public int getMaxTraffic() {
        return maxTraffic;
    }

    /**
     * 设置maxTraffic属性的值。
     *
     */
    public void setMaxTraffic(int value) {
        this.maxTraffic = value;
    }

    /**
     * 获取sigVersion属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSigVersion() {
        return sigVersion;
    }

    /**
     * 设置sigVersion属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSigVersion(String value) {
        this.sigVersion = value;
    }

    /**
     * 获取sigPassWd属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSigPassWd() {
        return sigPassWd;
    }

    /**
     * 设置sigPassWd属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSigPassWd(String value) {
        this.sigPassWd = value;
    }

    /**
     * Gets the value of the roadNameEles property.
     *
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the roadNameEles property.
     *
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getRoadNameEles().add(newItem);
     * &lt;/pre&gt;
     *
     *
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link RoadNameEle }
     *
     *
     */
    public List<RoadNameEle> getRoadNameEles() {
        if (roadNameEles == null) {
            roadNameEles = new ArrayList<RoadNameEle>();
        }
        return this.roadNameEles;
    }

    /**
     * Gets the value of the jumpArrows property.
     *
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the jumpArrows property.
     *
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getJumpArrows().add(newItem);
     * &lt;/pre&gt;
     *
     *
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link JumpArrowEle }
     *
     *
     */
    public List<JumpArrowEle> getJumpArrows() {
        if (jumpArrows == null) {
            jumpArrows = new ArrayList<JumpArrowEle>();
        }
        return this.jumpArrows;
    }

    /**
     * Gets the value of the phaseArrows property.
     *
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the phaseArrows property.
     *
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getPhaseArrows().add(newItem);
     * &lt;/pre&gt;
     *
     *
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link PhaseArrowEle }
     *
     *
     */
    public List<PhaseArrowEle> getPhaseArrows() {
        if (phaseArrows == null) {
            phaseArrows = new ArrayList<PhaseArrowEle>();
        }
        return this.phaseArrows;
    }

    /**
     * Gets the value of the sensors property.
     *
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the sensors property.
     *
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getSensors().add(newItem);
     * &lt;/pre&gt;
     *
     *
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link SensorsEle }
     *
     *
     */
    public List<SensorsEle> getSensors() {
        if (sensors == null) {
            sensors = new ArrayList<SensorsEle>();
        }
        return this.sensors;
    }

    /**
     * Gets the value of the monitorys property.
     *
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the monitorys property.
     *
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getMonitorys().add(newItem);
     * &lt;/pre&gt;
     *
     *
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link MonitoryEle }
     *
     *
     */
    public List<MonitoryEle> getMonitorys() {
        if (monitorys == null) {
            monitorys = new ArrayList<MonitoryEle>();
        }
        return this.monitorys;
    }

}
