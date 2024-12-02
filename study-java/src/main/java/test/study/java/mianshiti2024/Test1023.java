package test.study.java.mianshiti2024;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author sun yang
 * @date 2024/10/23
 */
public class Test1023 {

    public static BufferedImage createWatermark(String text, Font font, Color color, float alpha, int angle) {
        int width = 500;
        int height = 200;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g.setColor(color);
        g.setFont(font);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.rotate(Math.toRadians(angle), width / 2.0, height / 2.0);

        String[] lines = text.split("\n");
        int y = 10;
        for (String line : lines) {
            g.drawString(line, 10, y);
            y += font.getSize();
        }

        g.dispose();
        return image;
    }

    public static void main(String[] args) throws Exception {
        Font font = new Font("Arial", Font.BOLD, 20);
        Color color = new Color(255, 0, 0, 128); // Semi-transparent red
        float alpha = 0.5f; // 50% opacity
        int angle = 45; // 45 degrees

        BufferedImage watermark = createWatermark("Confidential\nDRAFT", font, color, alpha, angle);
        File outputFile = new File("watermark.png");
        ImageIO.write(watermark, "PNG", outputFile);
    }

//    public static void addWatermark(String inputPath, String outputPath) throws Exception {
//        XWPFDocument doc = new XWPFDocument(new FileInputStream(inputPath));
//        XWPFHeader header = doc.getHeaderList();
//        XWPFParagraph p = header.createParagraph();
//        XWPFRun r = p.createRun();
//        r.addPicture("watermark.png", XWPFDocument.PICTURE_TYPE_PNG);
//
//        doc.save(new FileOutputStream(outputPath));
//    }
//
//    public static void addWatermark(String inputPath, String outputPath) throws Exception {
//        Document document = new Document();
//        PdfReader reader = new PdfReader(inputPath);
//        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(outputPath));
//        PdfContentByte canvas = stamper.getOverContent(1);
//        Image watermark = Image.getInstance("watermark.png");
//        watermark.setAbsolutePosition(0, 0);
//        canvas.addImage(watermark);
//        stamper.close();
//        reader.close();
//    }

}
