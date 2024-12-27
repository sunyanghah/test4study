package test.study.java.watermark.poi;

import org.apache.poi.hslf.usermodel.HSLFSlideMaster;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.hslf.usermodel.HSLFTextBox;
import org.apache.poi.xddf.usermodel.text.XDDFTextBody;
import org.apache.poi.xslf.usermodel.*;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextWrappingType;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author sun yang
 * @date 2024/12/26
 */
public class PptTextTest {

    public static void main(String[] args) throws Exception{
        // 创建一个 .ppt 文件或打开已有文件
        HSLFSlideShow ppt = new HSLFSlideShow(new FileInputStream("F:\\watermark\\poi\\ppt.ppt"));

        // 获取母版幻灯片
        HSLFSlideMaster master = ppt.getSlideMasters().get(0);

        HSLFTextBox textBox = master.createTextBox();
        textBox.setText("这是母版上的文字");
        textBox.setFillColor(Color.blue);
        textBox.setTextRotation(45D);

        // 保存文件
        try (FileOutputStream out = new FileOutputStream("F:\\watermark\\poi\\result\\ppt.ppt")) {
            ppt.write(out);
        }
    }



}
