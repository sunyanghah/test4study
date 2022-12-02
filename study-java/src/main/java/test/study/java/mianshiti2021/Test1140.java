package test.study.java.mianshiti2021;

import com.alibaba.fastjson.JSON;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunYang
 * @date 2021/11/30 18:31
 */
public class Test1140 {

    public static void main(String[] args) throws Exception{

        String applyCode = "5fe66723cc0f13b3dc002af1122a1168";

        Integer maxStationNum = 500;

        Long endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-2-26 20:00:00").getTime();

        Map<String,Object> map = new HashMap<>();
        map.put("applyCode",applyCode);
        map.put("maxStationNum",maxStationNum);
        map.put("endTime",endTime);


        String str = ZzSecurityHelper.encryptAES(JSON.toJSONString(map));
        System.out.println(str);

        String str2 = ZzSecurityHelper.decryptAES(str);
        System.out.println(str2);

    }

    public static class ZzSecurityHelper {
        /*
         * 加密用的Key 可以用26个字母和数字组成 使用AES-128-CBC加密模式，key需要为16位。
         */
        private static final String key="hj6mH$yuBI045QCz";
        private static final String iv ="NIfb&95GUY86GCgh";
        /**
         * @author miracle.qu
         * @Description AES算法加密明文
         * @param data 明文
         * @return 密文
         */
        public static String encryptAES(String data) {
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                int blockSize = cipher.getBlockSize();
                byte[] dataBytes = data.getBytes();
                int plaintextLength = dataBytes.length;

                if (plaintextLength % blockSize != 0) {
                    plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
                }

                byte[] plaintext = new byte[plaintextLength];
                System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);

                SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
                IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());  // CBC模式，需要一个向量iv，可增加加密算法的强度

                cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
                byte[] encrypted = cipher.doFinal(plaintext);

                return ZzSecurityHelper.encode(encrypted).trim(); // BASE64做转码。

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /**
         * @author miracle.qu
         * @Description AES算法解密密文
         * @param data 密文
         * @return 明文
         */
        public static String decryptAES(String data) {
            try
            {
                byte[] encrypted1 = ZzSecurityHelper.decode(data);//先用base64解密

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
         * 编码
         * @param byteArray
         * @return
         */
        public static String encode(byte[] byteArray) {
            return new String(Base64.getEncoder().encode(byteArray));
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

}
