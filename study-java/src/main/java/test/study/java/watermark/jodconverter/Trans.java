package test.study.java.watermark.jodconverter;

import org.jodconverter.core.office.OfficeException;
import org.jodconverter.local.LocalConverter;
import org.jodconverter.local.office.LocalOfficeManager;

import java.io.File;

/**
 * @author sun yang
 * @date 2024/12/18
 */
public class Trans {


    public static void main(String[] args) {
//        trans("F:\\watermark\\libre\\doc.doc","F:\\watermark\\libre\\docx.docx");
//        trans("F:\\watermark\\libre\\ppt.ppt","F:\\watermark\\libre\\pptx.pptx");


        /**
         * 以下两个未加水印，以及加了水印的，高版本转低版本时，都会出现样式问题，且问题比较大，不推荐高转低
         */
//        trans("F:\\watermark\\libre\\docx.docx","F:\\watermark\\libre\\doc.doc");
//        trans("F:\\watermark\\libre\\pptx.pptx","F:\\watermark\\libre\\ppt.ppt");

//        trans("F:\\watermark\\libre\\result\\docx.docx","F:\\watermark\\libre\\result\\doc.doc");
//        trans("F:\\watermark\\libre\\result\\pptx.pptx","F:\\watermark\\libre\\result\\ppt.ppt");
    }

    public static void trans(String inputFilePath,String outFilePath){
        // 启动 LibreOffice 服务
        LocalOfficeManager officeManager = LocalOfficeManager.builder()
                .officeHome("F:\\libreOffice").install().build();
        try {
            officeManager.start();

            // 定义输入和输出文件
            File inputFile = new File(inputFilePath);
            File outputFile = new File(outFilePath);

            // 执行转换
            LocalConverter.builder()
                    .officeManager(officeManager)
                    .build()
                    .convert(inputFile)
                    .to(outputFile)
                    .execute();

            System.out.println("转换完成！");
        } catch (OfficeException e) {
            e.printStackTrace();
        } finally {
            try {
                officeManager.stop();
            } catch (OfficeException e) {
                e.printStackTrace();
            }
        }
    }

}
