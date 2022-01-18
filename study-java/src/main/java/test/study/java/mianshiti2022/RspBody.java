package test.study.java.mianshiti2022;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author sunYang
 * @date 2022/1/15 17:18
 */
@Getter
@Setter
@XmlRootElement(name = "SOAP-ENV:Body")
@XmlAccessorType(XmlAccessType.FIELD)
public class RspBody {

    @XmlElement(name = "ns:GetCrossInfoEXResponse")
    private GetCrossInfoEXResponse getScenicSpotList;
}
