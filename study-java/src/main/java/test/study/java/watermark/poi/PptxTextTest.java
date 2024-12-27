package test.study.java.watermark.poi;

import org.apache.poi.xddf.usermodel.text.XDDFTextBody;
import org.apache.poi.xslf.usermodel.*;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextWrappingType;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author sun yang
 * @date 2024/12/27
 */
public class PptxTextTest {

    public static void main(String[] args) throws Exception{
        XMLSlideShow xmlSlideShow = new XMLSlideShow(new FileInputStream("F:\\watermark\\poi\\pptx.pptx"));
        injectLightWaterMark(xmlSlideShow,"水印内容第一行\nfffffffff\n这是第三行",100,100,Color.BLUE,new Font("宋体",Font.BOLD,20),100,100,45);
        xmlSlideShow.write(new FileOutputStream("F:\\watermark\\poi\\result\\pptx.pptx"));
    }

    public static void injectLightWaterMark(XMLSlideShow ppt, String content, int width, int height,
                                            Color color, Font font, int horizontalGap, int verticalGap, double rotate) {
        Dimension pageSize = ppt.getPageSize();

        for (XSLFSlide slide : ppt.getSlides()) {

            int row = (int) Math.ceil(pageSize.getHeight() / (height + verticalGap));
            int col = (int) Math.ceil(pageSize.getWidth() / (width + horizontalGap));

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {

                    // 在每一页上添加水印的代码
                    // 创建文本框对象
                    XSLFTextBox waterMark = slide.createTextBox();
                    waterMark.setRotation(-rotate);
                    // 创建段落对象
                    XSLFTextParagraph paragraph = waterMark.addNewTextParagraph();
                    XSLFTextRun run = paragraph.addNewTextRun();
                    //设置文本内容
                    run.setText(content);
                    run.setFontColor(color);
                    //设置字体大小
                    run.setFontSize((double) font.getSize());
                    //设置字体名称
                    run.setFontFamily(font.getFamily());

                    XDDFTextBody textBody = waterMark.getTextBody();
                    CTTextCharacterProperties rPr = textBody.getXmlObject().getPArray(1).getRArray(0).getRPr();
                    CTSRgbColor ctsRgbColor = rPr.getSolidFill().getSrgbClr();
                    //设置文本透明度
                    ctsRgbColor.addNewAlpha().setVal(100000);
                    //根据文字调整形状大小
                    textBody.getXmlObject().getBodyPr().addNewSpAutoFit();
                    //设置文本不自动换行
                    textBody.getXmlObject().getBodyPr().setWrap(STTextWrappingType.Enum.forInt(1));
                    paragraph.addLineBreak();

                    // 设置水印位置
                    double x = j * (width + horizontalGap);
                    double y = i * (height + verticalGap);
                    // 设置水印位置和大小
                    waterMark.setAnchor(new Rectangle2D.Double(x, y, width + 10, height + 10));
                }
            }
        }
    }

}
