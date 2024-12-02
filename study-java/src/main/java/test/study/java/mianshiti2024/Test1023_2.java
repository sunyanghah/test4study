package test.study.java.mianshiti2024;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import org.apache.pdfbox.util.Matrix;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author sun yang
 * @date 2024/10/23
 */
public class Test1023_2 {
    /**
     * 添加多行文字水印到PDF文档。
     *
     * @param sourceFilePath   源PDF文件路径
     * @param outputFilePath   输出PDF文件路径
     * @param watermarkText    水印文本
     * @param font         字体名称，使用PDFBox标准字体
     * @param fontSize         字体大小
     * @param color            水印颜色，以RGB表示
     * @param transparency     水印透明度，0表示完全透明，1表示不透明
     * @param rotation         水印旋转角度
     * @throws IOException     如果文件操作出现错误
     */
    public static void addWatermark(String sourceFilePath, String outputFilePath, String watermarkText, PDFont font,
                                    float fontSize, Color color, float transparency, float rotation) throws IOException {
        try (PDDocument document = PDDocument.load(new File(sourceFilePath))) {

            PDType0Font font2 = PDType0Font.load(document, new FileInputStream("D:\\IDEA\\gitWork\\test4study\\Fonts\\song.ttf"));

            for (PDPage page : document.getPages()) {
                try (PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true)) {
                    contentStream.beginText();
                    contentStream.setFont(font2, fontSize);

                    // 设置水印颜色
                    contentStream.setNonStrokingColor(color);

                    // 设置透明度
                    PDExtendedGraphicsState gs = new PDExtendedGraphicsState();
                    gs.setNonStrokingAlphaConstant(transparency);
                    contentStream.setGraphicsStateParameters(gs);

                    // 计算页面的宽度和高度
                    float pageWidth = page.getMediaBox().getWidth();
                    float pageHeight = page.getMediaBox().getHeight();

                    // 设置水印文本的起始位置
                    float y = pageHeight - pageHeight / 3 /2;
                    for(int column=0;column<3;column++) {
                        float x = pageWidth/3/2;
                        for (int i = 0; i < 3; i++) {
                            // 将文本按行拆分并添加到PDF中
                            String[] lines = watermarkText.split("\n");
                            float lineY = y;
                            for (String line : lines) {
                                // 设置文本矩阵并添加水印文本
                                Matrix textMatrix = Matrix.getRotateInstance(Math.toRadians(rotation), x, lineY);
                                contentStream.setTextMatrix(textMatrix);
                                contentStream.showText(line);
                                lineY -= fontSize * 1.5f; // 根据字体大小调整行间距
                            }
                            x += pageWidth / 3;
                        }
                        y -= pageHeight / 3;
                    }


                    contentStream.endText();
                }
            }
            document.save(outputFilePath);
        }
    }

    public static void main(String[] args) {
        try {
            String sourceFilePath = "F:\\watermark\\信界.pdf";
            String outputFilePath = "F:\\watermark\\信界_watermark.pdf";
            String watermarkText = "这是第一行水印\n这是第二行水印";
            float fontSize = 12;
            Color color = Color.RED;
            float transparency = 0.5f;
            float rotation = 0;

            addWatermark(sourceFilePath, outputFilePath, watermarkText, PDType1Font.TIMES_BOLD_ITALIC, fontSize, color, transparency, rotation);
            System.out.println("水印添加完成！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

