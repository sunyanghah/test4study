package test.study.java.watermark.textDark;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author sun yang
 * @date 2024/12/30
 */
public class XlsxTest {

    public static void main(String[] args) throws Exception{

        String inputFilePath = "F:\\watermark\\textDark\\xlsx.xlsx";
        String outputFilePath = "F:\\watermark\\textDark\\result\\xlsx.xlsx";

        addContentDark(inputFilePath, outputFilePath);
        read(outputFilePath);
    }

    private static void addContentDark(String inputFilePath, String outputFilePath) throws Exception{

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(inputFilePath));

        XSSFSheet sheet = workbook.getSheetAt(0);

        String invisibleWatermark =  TextDarkUtils.encode(123L);

        //根据比例计算出需要加注的行数
        for (int rowIndex = 0; rowIndex < 5; rowIndex++) {
            XSSFRow row = sheet.getRow(rowIndex);
            if(row == null){
                System.out.println("row is null:"+rowIndex);
                continue;
            }
            //遍历row,获取单元格
            for (int colIndex = 0; colIndex < 20; colIndex++) {
                XSSFCell cell = row.getCell(colIndex);
                if (cell != null) {
                    //判断单元格的类型
                    if (cell.getCellType() == CellType.STRING) {
                        //获取单元格的值
                        String cellValue = cell.getStringCellValue();
                        //判断是否需要加注
                        if (StringUtils.isNotBlank(cellValue)) {

                            int centerPos = cellValue.length()/2;

                            String richTextString = cellValue.substring(0,centerPos) + invisibleWatermark + cellValue.substring(centerPos);

                            //获取样式
                            XSSFCellStyle cellStyle = cell.getCellStyle();
                            //更新值 末尾加不可见字符
                            XSSFRichTextString xssfRichTextString = new XSSFRichTextString(richTextString);
                            cell.setCellValue(xssfRichTextString);
                            //设置样式
                            cell.setCellStyle(cellStyle);
                        }
                    }
                    if (cell.getCellType() == CellType.NUMERIC){
                        //获取单元格的值
                        double numericCellValue = cell.getNumericCellValue();

                        String cellValue = String.valueOf(numericCellValue);

                        int centerPos = cellValue.length()/2;

                        String richTextString = cellValue.substring(0,centerPos) + invisibleWatermark + cellValue.substring(centerPos);

                        //获取样式
                        XSSFCellStyle cellStyle = cell.getCellStyle();
                        //更新值 末尾加不可见字符
                        XSSFRichTextString xssfRichTextString = new XSSFRichTextString(richTextString);
                        cell.setCellValue(xssfRichTextString);
                        //设置样式
                        cell.setCellStyle(cellStyle);
                    }
                }
            }
        }

        try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
            workbook.write(fos);
        }

        System.out.println("Hidden text added to the Excel document.");
    }

    private static void read(String outputFilePath) throws Exception{

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(outputFilePath));

        XSSFSheet sheet = workbook.getSheetAt(0);

        //根据比例计算出需要加注的行数
        for (int rowIndex = 0; rowIndex < 5; rowIndex++) {
            XSSFRow row = sheet.getRow(rowIndex);
            if(row == null){
                continue;
            }
            //遍历row,获取单元格
            for (int colIndex = 0; colIndex < 20; colIndex++) {
                XSSFCell cell = row.getCell(colIndex);
                if (cell != null) {
                    //判断单元格的类型
                    if (cell.getCellType() == CellType.STRING) {
                        //获取单元格的值
                        String cellValue = cell.getStringCellValue();
                        //判断是否需要加注
                        if (StringUtils.isNotBlank(cellValue)) {
                            System.out.println("水印内容："+TextDarkUtils.decode(cellValue));
                        }
                    }
                }
            }
        }

    }

}
