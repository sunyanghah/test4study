package test.study.java.mianshiti2022;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author sunYang
 * @date 2022/9/9 18:19
 */
public class Test0909 {

    public static void main(String[] args) throws Exception{

        File file = new File("H:\\xxv\\ttt-1.0.2.zip");

        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));


        //
//        List<ZipEntry> list = new ArrayList<>();
//
//        ZipEntry zipEntry;
//        while ((zipEntry = zipInputStream.getNextEntry()) != null){
//            list.add(zipEntry);
//            zipInputStream.closeEntry();
//        }
//
//        zipInputStream.close();

        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file,true));

//        for (ZipEntry entry : list) {
//            zipOutputStream.putNextEntry(entry);
//            zipOutputStream.closeEntry();
//        }
        zipOutputStream.putNextEntry(new ZipEntry("test.html"));

        FileInputStream fis2 = new FileInputStream(new File("H:\\xxv\\TEST.html"));

        //写入压缩文件
        int len2;
        byte[] buffer2 = new byte[1024]; //字节数组大小可调节
        //读取fis字节流，转移到buffer字节数组中去，读取后fis为空
        while ((len2 = fis2.read(buffer2)) > 0) {
            zipOutputStream.write(buffer2, 0, len2);
        }
        zipOutputStream.closeEntry();
        fis2.close();

        zipOutputStream.putNextEntry(new ZipEntry("resources/"));

        zipOutputStream.putNextEntry(new ZipEntry("resources/preview.png"));

        FileInputStream fis = new FileInputStream(new File("H:\\图片\\3333.png"));

        //写入压缩文件
        int len;
        byte[] buffer = new byte[1024]; //字节数组大小可调节
        //读取fis字节流，转移到buffer字节数组中去，读取后fis为空
        while ((len = fis.read(buffer)) > 0) {
            zipOutputStream.write(buffer, 0, len);
        }
        zipOutputStream.closeEntry();
        fis.close();
        zipOutputStream.flush();
        zipOutputStream.close();



    }

}
