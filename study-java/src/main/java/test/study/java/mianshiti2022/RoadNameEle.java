
package test.study.java.mianshiti2022;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;RoadNameEle complex type的 Java 类。
 *
 * &lt;p&gt;以下模式片段指定包含在此类中的预期内容。
 *
 * &lt;pre&gt;
 * &amp;lt;complexType name="RoadNameEle"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="eleID" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="operaType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="crossID" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="roadName" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="x" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="y" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="angle" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="elesize" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *         &amp;lt;element name="fontColor" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoadNameEle", propOrder = {
    "eleID",
    "operaType",
    "crossID",
    "roadName",
    "x",
    "y",
    "angle",
    "elesize",
    "fontColor"
})
public class RoadNameEle {

    protected int eleID;
    protected Integer operaType;
    protected int crossID;
    @XmlElement(required = true)
    protected String roadName;
    protected int x;
    protected int y;
    protected int angle;
    protected int elesize;
    protected int fontColor;

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
     * 获取roadName属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRoadName() {
        return roadName;
    }

    /**
     * 设置roadName属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRoadName(String value) {
        this.roadName = value;
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
     * 获取fontColor属性的值。
     *
     */
    public int getFontColor() {
        return fontColor;
    }

    /**
     * 设置fontColor属性的值。
     *
     */
    public void setFontColor(int value) {
        this.fontColor = value;
    }

}
