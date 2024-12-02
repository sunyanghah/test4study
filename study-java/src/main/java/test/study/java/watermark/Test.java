package test.study.java.watermark;

import test.study.java.mianshiti2021.Test1140;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Base64;

/**
 * @author sun yang
 * @date 2023/12/7
 */
public class Test {

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

                return Test1140.ZzSecurityHelper.encode(encrypted).trim(); // BASE64做转码。

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
                byte[] encrypted1 = Test1140.ZzSecurityHelper.decode(data);//先用base64解密

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

    public static void main(String[] args) throws Exception{

//        testDocx();
//        testDoc();
//        testXlsx();
//        testXls();
//        testPptx();
//        testPpt();
        testPdf();

    }

    public static void testDocx() throws Exception{
        File file = new File("F:\\一个重要的word.docx");



        String watermark = HiddenWaterMarkUtil.parseMarker(file.getName(),new FileInputStream(file));
        System.out.println("--------------==------");
        System.out.println(watermark == null? "null----":ZzSecurityHelper.decryptAES(watermark));

        FileInputStream fileInputStream = new FileInputStream(file);
        ByteArrayOutputStream outputStream = HiddenWaterMarkUtil.markerDocx(fileInputStream, ZzSecurityHelper.encryptAES("this is my docx watermark"));
        // 写回到文件
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(outputStream.toByteArray());
        fileInputStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    public static void testDoc() throws Exception{
        File file = new File("F:\\docWaterMark.doc");
        FileInputStream fileInputStream = new FileInputStream(file);
        ByteArrayOutputStream outputStream = HiddenWaterMarkUtil.markerDoc(fileInputStream, ZzSecurityHelper.encryptAES("this is my doc watermark"));
        // 写回到文件
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(outputStream.toByteArray());
        fileInputStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();


        String watermark = HiddenWaterMarkUtil.parseMarkerDoc(new FileInputStream(file));
        System.out.println("--------------==------");
        System.out.println(ZzSecurityHelper.decryptAES(watermark));
    }

    public static void testXlsx() throws Exception{
        File file = new File("F:\\xlsxWaterMark.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        ByteArrayOutputStream outputStream = HiddenWaterMarkUtil.markerXlsx(true, fileInputStream, ZzSecurityHelper.encryptAES("this is my xlsx watermark"),null);
        // 写回到文件
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(outputStream.toByteArray());
        fileInputStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();


        String watermark = HiddenWaterMarkUtil.parseMarkerXlsx(new FileInputStream(file));
        System.out.println("--------------==------");
        System.out.println(ZzSecurityHelper.decryptAES(watermark));
    }

    public static void testXls() throws Exception{
        File file = new File("F:\\xlsWaterMark.xls");
        FileInputStream fileInputStream = new FileInputStream(file);
        ByteArrayOutputStream outputStream = HiddenWaterMarkUtil.markerXls(true,fileInputStream, ZzSecurityHelper.encryptAES("this is my xls watermark"),null);
        // 写回到文件
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(outputStream.toByteArray());
        fileInputStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();


        String watermark = HiddenWaterMarkUtil.parseMarkerXls(new FileInputStream(file));
        System.out.println("--------------==------");
        System.out.println(ZzSecurityHelper.decryptAES(watermark));
    }

    public static void testPptx() throws Exception{
        File file = new File("F:\\pptxWaterMark.pptx");
        FileInputStream fileInputStream = new FileInputStream(file);
        ByteArrayOutputStream outputStream = HiddenWaterMarkUtil.markerPptx(fileInputStream, ZzSecurityHelper.encryptAES("this is my pptx watermark"));
        // 写回到文件
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(outputStream.toByteArray());
        fileInputStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();


        String watermark = HiddenWaterMarkUtil.parseMarkerPptx(new FileInputStream(file));
        System.out.println("--------------==------");
        System.out.println(ZzSecurityHelper.decryptAES(watermark));
    }

    public static void testPpt() throws Exception{
        File file = new File("F:\\pptWaterMark.ppt");
        FileInputStream fileInputStream = new FileInputStream(file);
        ByteArrayOutputStream outputStream = HiddenWaterMarkUtil.markerPpt(fileInputStream, ZzSecurityHelper.encryptAES("this is my ppt watermark"));
        // 写回到文件
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(outputStream.toByteArray());
        fileInputStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();


        String watermark = HiddenWaterMarkUtil.parseMarkerPpt(new FileInputStream(file));
        System.out.println("--------------==------");
        System.out.println(ZzSecurityHelper.decryptAES(watermark));
    }

    public static void testPdf() throws Exception{
        File file = new File("F:\\watermark\\元界-管理平台-总体设计.pdf");
        FileInputStream fileInputStream = new FileInputStream(file);
        ByteArrayOutputStream outputStream = HiddenWaterMarkUtil.markerPdf(fileInputStream, "this is my pdf watermark22");
        // 写回到文件
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(outputStream.toByteArray());
        fileInputStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();


        String watermark = HiddenWaterMarkUtil.parseMarkerPdf(new FileInputStream(file));
        System.out.println("--------------==------");
        System.out.println(watermark);
    }

}
