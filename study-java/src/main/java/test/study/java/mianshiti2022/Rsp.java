package test.study.java.mianshiti2022;

import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * @author sunYang
 * @date 2022/1/15 17:17
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
//        "header",
        "body"
})
@XmlRootElement(name = "Envelope",namespace = "http://schemas.xmlsoap.org/soap/envelope/")
@Data
public class Rsp {

    @XmlElement(required = true,name="SOAP-ENV:Body")
    protected RspBody body;

}
