package test.study.java.mianshiti2024;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author sun yang
 * @date 2024/11/1
 */
public class Test1101 {

    public static void main(String[] args) throws IOException {
        // 创建一个新的工作簿
        Workbook workbook = new HSSFWorkbook();
        // 创建一个工作表
        Sheet sheet = workbook.createSheet("Sheet1");

        // 创建一个水印对象
        CreationHelper helper = workbook.getCreationHelper();
        Drawing<?> drawing = sheet.createDrawingPatriarch();
        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 5, 10, 15);
        Comment comment = drawing.createCellComment(anchor);
        RichTextString str = helper.createRichTextString("这是水印");
        comment.setString(str);
        comment.setAuthor("作者");

        // 应用水印到第一个单元格
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellComment(comment);

        // 写入文件
        FileOutputStream fileOut = new FileOutputStream("F:\\watermark\\watermark.xls");
        workbook.write(fileOut);
        fileOut.close();

        // 关闭工作簿
        workbook.close();
    }

}
