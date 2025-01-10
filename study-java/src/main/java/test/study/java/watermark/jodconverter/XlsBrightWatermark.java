package test.study.java.watermark.jodconverter;

import org.apache.poi.hssf.model.InternalSheet;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordBase;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.util.LittleEndianOutput;
import test.study.java.watermark.WatermarkUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.*;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class XlsBrightWatermark {

    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream outputStream = addToXls(new FileInputStream("F:\\watermark\\success\\xls.xls"),
                new String[]{"这是xls水", "第二行", "第三行"},
                16,
                "#FF0000",
                100,
                45);

        outputStream.writeTo(new FileOutputStream("F:\\watermark\\success\\result\\xls.xls"));

    }

    /**
     * Add watermark to xls
     * @param originFilePath 原文件路径
     * @param targetPath 目标文件路径
     * @param textArr 水印文字数组，每个一行
     * @param fontSize 字体大小
     * @param fontColor 字体颜色 #FFFFFF 格式
     * @param opacity 透明度 0-100
     * @param rotate 旋转角度 0-360
     * @throws Exception
     */
    public static void addToXls(String originFilePath,String targetPath,String[] textArr,
                                int fontSize,String fontColor,int opacity,int rotate) throws Exception {

        File originFile = new File(originFilePath);
        ByteArrayOutputStream outputStream = addToXls(new FileInputStream(originFile),
                textArr,
                fontSize,
                fontColor,
                opacity,
                rotate);

        outputStream.writeTo(new FileOutputStream(targetPath + File.separator + originFile.getName()));
    }


    /**
     * Add watermark to xls
     * @param inputStream 原文件流
     * @param textArr 水印文字数组，每个一行
     * @param fontSize 字体大小
     * @param fontColor 字体颜色 #FFFFFF 格式
     * @param opacity 透明度 0-100
     * @param rotate 旋转角度 0-360
     * @return
     * @throws Exception
     */
    public static ByteArrayOutputStream addToXls(InputStream inputStream, String[] textArr,
                                                 int fontSize, String fontColor, int opacity, int rotate) throws Exception {
        ZipSecureFile.setMinInflateRatio(0.0001);
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);

        int numberOfSheets = workbook.getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {
            HSSFSheet sheet = workbook.getSheetAt(i);
            InternalSheet internalSheet = sheet.getSheet();
            insertWatermark(internalSheet,textArr,fontSize,fontColor,opacity,rotate);
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // write out workbook
        workbook.write(byteArrayOutputStream);
        workbook.close();
        return byteArrayOutputStream;
    }

    public static void insertWatermark(InternalSheet internalsheet, String[] textArr,
                                       int fontSize, String fontColor, int opacity, int rotate) throws Exception{
        // get List of RecordBase
        Field _records = InternalSheet.class.getDeclaredField("_records");
        _records.setAccessible(true);
        @SuppressWarnings("unchecked")
        List<RecordBase> records = (List<RecordBase>)_records.get(internalsheet);

        // 加载字体库文件
        InputStream fontStream = new FileInputStream("D:\\IDEA\\gitWork\\test4study\\study-java\\src\\main\\java\\test\\study\\java\\mianshiti2024\\simfang.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
        font = font.deriveFont(Font.PLAIN, fontSize+10);

        int[] imageSize = WatermarkUtil.calculateSize(textArr, font, rotate);
        //生成水印
        BufferedImage bufferedImage = WatermarkUtil.createSingleWaterMark(
                WatermarkUtil.transText(textArr),
                imageSize[0]+50, imageSize[1]+50,
                WatermarkUtil.hexStringToColor(fontColor,opacity),
                font,
                rotate);

        // get bytes of the image file
        byte[] data = getBackgroundBitmapData(bufferedImage); //PNG must not have transparency

        // do creating BitmapRecord and ContinueRecords from the data in parts of 8220 bytes
        BitmapRecord bitmapRecord;
        List<ContinueRecord> continueRecords = new ArrayList<>();
        int bytes;

        if (data.length > 8220) {
            bitmapRecord = new BitmapRecord(Arrays.copyOfRange(data, 0, 8220));
            bytes = 8220;
            while (bytes < data.length) {
                if ((bytes + 8220) < data.length) {
                    continueRecords.add(new ContinueRecord(Arrays.copyOfRange(data, bytes, bytes + 8220)));
                    bytes += 8220;
                } else {
                    continueRecords.add(new ContinueRecord(Arrays.copyOfRange(data, bytes, data.length)));
                    break;
                }
            }
        } else {
            bitmapRecord = new BitmapRecord(data);
        }

        // add the records after PageSettingsBlock
        int i = 0;
        for (RecordBase r : records) {
            if (r instanceof org.apache.poi.hssf.record.aggregates.PageSettingsBlock) {
                break;
            }
            i++;
        }
        records.add(++i, bitmapRecord);
        for (ContinueRecord continueRecord : continueRecords) {
            records.add(++i, continueRecord);
        }
    }

    static byte[] getBackgroundBitmapData(BufferedImage in) throws Exception {

        //see https://www.openoffice.org/sc/excelfileformat.pdf - BITMAP

        // get file byte data in type BufferedImage.TYPE_3BYTE_BGR
        BufferedImage image = new BufferedImage(in.getWidth(), in.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D graphics = image.createGraphics();
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.0f));
        graphics.drawImage(in, null, 0, 0);
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
        graphics.dispose();

        // calculate row size (c)
        int rowSize = ((24 * image.getWidth() + 31) / 32) * 4;

        ByteArrayOutputStream output = new ByteArrayOutputStream(image.getHeight() * rowSize * 3 + 1024);

        // put the record headers into the data
        ByteBuffer header = ByteBuffer.allocate(8 + 12);
        header.order(ByteOrder.LITTLE_ENDIAN);

        // Undocumented XLS stuff
        header.putShort((short) 0x09);
        header.putShort((short) 0x01);
        header.putInt(image.getHeight() * rowSize + 12); // Size of image stream

        // BITMAPCOREHEADER (a)
        header.putInt(12);

        header.putShort((short) image.getWidth());
        header.putShort((short) image.getHeight()); // Use -height if writing top-down

        header.putShort((short) 1); // planes, always 1
        header.putShort((short) 24); // bitcount

        output.write(header.array());

        // Output rows bottom-up (b)
        Raster raster = image.getRaster()
                .createChild(0, 0, image.getWidth(), image.getHeight(), 0, 0, new int[]{2, 1, 0}); // Reverse BGR -> RGB (d)
        byte[] row = new byte[rowSize]; // padded (c)

        for (int i = image.getHeight() - 1; i >= 0; i--) {
            row = (byte[]) raster.getDataElements(0, i, image.getWidth(), 1, row);
            output.write(row);
        }

        return output.toByteArray();
    }


    static class BitmapRecord extends StandardRecord {

        //see https://www.openoffice.org/sc/excelfileformat.pdf - BITMAP

        byte[] data;

        BitmapRecord(byte[] data) {
            this.data = data;
        }

        @Override
        public int getDataSize() {
            return data.length;
        }

        @Override
        public short getSid() {
            return (short)0x00E9;
        }

        @Override
        public void serialize(LittleEndianOutput out) {
            out.write(data);
        }

        @Override
        public StandardRecord copy() {
            return null;
        }

        @Override
        public HSSFRecordTypes getGenericRecordType() {
            return null;
        }

        @Override
        public Map<String, Supplier<?>> getGenericProperties() {
            return null;
        }
    }

    static class ContinueRecord extends StandardRecord {

        //see https://www.openoffice.org/sc/excelfileformat.pdf - CONTINUE

        byte[] data;

        ContinueRecord(byte[] data) {
            this.data = data;
        }

        @Override
        public int getDataSize() {
            return data.length;
        }

        @Override
        public short getSid() {
            return (short)0x003C;
        }

        @Override
        public void serialize(LittleEndianOutput out) {
            out.write(data);
        }

        @Override
        public StandardRecord copy() {
            return null;
        }

        @Override
        public HSSFRecordTypes getGenericRecordType() {
            return null;
        }

        @Override
        public Map<String, Supplier<?>> getGenericProperties() {
            return null;
        }
    }
}