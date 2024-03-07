package test.study.java.watermark;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author sun yang
 * @date 2023/12/8
 */
public class Test_ID {

    public static void main(String[] args) throws Exception{
        File source = new File("F:\\watermark\\test-empty\\source.docx");
        File target = new File("F:\\watermark\\test-empty\\target.docx");

        marker(source,target);
//        System.out.println(HiddenWaterMarkUtil.parseMarkerPpt(new FileInputStream(target)));

    }

    private static void marker(File source,File target) throws Exception{

        ByteArrayOutputStream byteArrayOutputStream = HiddenWaterMarkUtil.markerDocx(new FileInputStream(source),"123456");

        FileOutputStream fileOutputStream = new FileOutputStream(target);
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        fileOutputStream.flush();
        fileOutputStream.close();
    }

}
