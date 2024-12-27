package test.study.java.watermark.jodconverter;

import org.apache.poi.poifs.filesystem.FileMagic;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author sun yang
 * @date 2024/12/19
 */
public class TestVersion {

    private static final String OOXML = "OOXML";
    private static final String OLE2 = "OLE2";

    public static void main(String[] args) throws Exception{

        InputStream inputStream = new FileInputStream("F:\\watermark\\libre\\result\\pptx.pptx");

        InputStream is = FileMagic.prepareToCheckMagic(inputStream);
        FileMagic fm = FileMagic.valueOf(is);

        if (OOXML.equals(fm.toString())){
            System.out.println("这是高版本");
        }else{
            System.out.println("这是低版本");
        }
    }

}
