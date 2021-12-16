package study.license.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * @author sunYang
 * @date 2021/12/1 10:44
 */
public class AesUtil {

    private static final String key="hj6mH$yuBI045QCz";

    private static final String iv ="NIfb&95GUY86GCgh";

    /**
     * @author miracle.qu
     * @Description AES算法解密密文
     * @param data 密文
     * @return 明文
     */
    public static String decryptAES(String data) {
        try
        {
            //先用base64解密
            byte[] encrypted1 = AesUtil.decode(data);

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString.trim();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 解码
     * @param base64EncodedString
     * @return
     */
    public static byte[] decode(String base64EncodedString) {
        return Base64.getDecoder().decode(base64EncodedString);
    }

}
