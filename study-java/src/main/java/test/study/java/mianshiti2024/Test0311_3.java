package test.study.java.mianshiti2024;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.PublicKey;
import java.security.Security;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sun yang
 * @date 2024/3/11
 */
public class Test0311_3 {

    public static void main(String[] args) {
        showCertInfo();
    }
    public static void showCertInfo() {
        try {
            // 读取证书文件
//            String filePath = "F:\\sm2.www.test.com\\sm2.www.test.com.enc.cer";
//             String filePath = "F:\\sm2.www.test.com\\sm2.www.test.com.enc.pri.pem";
//            String filePath = "F:\\sm2.www.test.com\\sm2.ca.pem";
//            String filePath = "F:\\sm2.www.test.com\\sm2.www.test.com.enc.key.pem";
//            String filePath ="F:\\sm2.www.test.com\\sm2.www.test.com.enc.crt.pem";
            String filePath = "F:\\sm2.www.test.com\\sm2.www.test.com.sig.crt.pem";
            File file = new File(filePath);
            InputStream inStream = new FileInputStream(file);

            // 引入BC库  证书类型是SM2证书时使用
            Security.addProvider(new BouncyCastleProvider());
            // 创建X509工厂类
            CertificateFactory cf = CertificateFactory.getInstance("X.509", "BC");

            // 证书类型是RSA证书时使用
            // 创建X509工厂类
            // CertificateFactory cf = CertificateFactory.getInstance("X.509");

            // 创建证书对象
            X509Certificate oCert = (X509Certificate) cf.generateCertificate(inStream);
            PublicKey pk = oCert.getPublicKey();
            BASE64Encoder bse = new BASE64Encoder();
            System.out.println("Base64公钥信息:\n" + bse.encode(pk.getEncoded()));
            System.out.println("----------------------------");
            inStream.close();
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
            String info = null;
            // 获得证书版本
            info = String.valueOf(oCert.getVersion());
            System.out.println("证书版本:" + info);
            // 获得证书序列号
            info = oCert.getSerialNumber().toString(16);
            System.out.println("证书序列号:" + info);
            // 获得证书有效期
            Date beforedate = oCert.getNotBefore();
            info = dateformat.format(beforedate);
            System.out.println("证书生效日期:" + info);
            Date afterdate = oCert.getNotAfter();
            info = dateformat.format(afterdate);
            System.out.println("证书失效日期:" + info);
            // 获得证书主体信息
            info = oCert.getSubjectDN().getName();
            System.out.println("证书拥有者:" + info);
            // 获得证书颁发者信息
            info = oCert.getIssuerDN().getName();
            System.out.println("证书颁发者:" + info);
            // 获得证书签名算法名称
            info = oCert.getSigAlgName();
            System.out.println("证书签名算法:" + info);
        } catch (Exception e) {
            System.out.println("解析证书出错！");
            e.printStackTrace();
        }
    }
}
