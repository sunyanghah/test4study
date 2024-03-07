package test.study.java.watermark;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * <p> AES加解密</p>
 *
 * @author heliu
 * @date 2022/7/7 5:24 下午
 */
@Slf4j
public class AESUtil {

    public static final String DEFAULT_ENCRYPT_KEY = "secure@@ASIAINFO-LINKAGE";

    public static final String CHARSET_NAME = "UTF-8";

    public static String Encrypt(String sSrc) throws Exception {
        SecretKeySpec sKeySpec = new SecretKeySpec(DEFAULT_ENCRYPT_KEY.getBytes(CHARSET_NAME), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, sKeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes(CHARSET_NAME));
        return new String(Base64.encodeBase64(encrypted));
    }

    public static String Decrypt(String sSrc) throws Exception {
        try {
            SecretKeySpec sKeySpec = new SecretKeySpec(DEFAULT_ENCRYPT_KEY.getBytes(CHARSET_NAME), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, sKeySpec);
            byte[] encrypted1 = Base64.decodeBase64(sSrc.getBytes());
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original, CHARSET_NAME);
                return originalString;
            } catch (Exception e) {
                log.error("加密数据，解密失败", e);
                throw new Exception("密码解密失败");
            }
        } catch (Exception ex) {
            log.error("加密数据，解密失败", ex);
            throw new Exception("密码解密失败");
        }
    }
}
