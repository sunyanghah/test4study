package test.study.java.watermark.dark;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author sun yang
 * @date 2023/12/8
 */
public class Test_Asia {

    public static void main(String[] args) throws Exception{
        File source = new File("E:\\飞书下载\\亚信安全数据水印系统方案.ppt");
        File target = new File("E:\\飞书下载\\亚信安全数据水印系统方案2.ppt");

//        File source = new File("E:\\飞书下载\\11.doc");
//        File target = new File("E:\\飞书下载\\22.doc");

        marker(source,target);
//        System.out.println(HiddenWaterMarkUtil.parseMarker(target.getName(),new FileInputStream(target)));


    }

    private static void marker(File source,File target) throws Exception{

        ByteArrayOutputStream byteArrayOutputStream = HiddenWaterMarkUtil.marker(source.getName(),new FileInputStream(source),"123456");

        FileOutputStream fileOutputStream = new FileOutputStream(target);
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        fileOutputStream.flush();
        fileOutputStream.close();
    }

}
