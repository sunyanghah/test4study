package test.study.java.mianshiti2024;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPOutputStream;

/**
 * @author sun yang
 * @date 2024/6/28
 */
public class Test0628_2 {

    public static void main(String[] args) {
        String json = "{\"key1\":\"value1\",\"key2\":\"value2\"}"; // 示例JSON字符串
        String gzipFileName = "F:\\dsf\\output.json.gz"; // 输出的gzip文件名

        try {
            gzipJson(json, gzipFileName);
            System.out.println("JSON字符串已成功转换为gzip压缩文件。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void gzipJson(String json, String gzipFileName) throws IOException {
        // 将JSON字符串转换为字节数组
        byte[] jsonBytes = json.getBytes(StandardCharsets.UTF_8);

        // 使用ByteArrayInputStream读取JSON字节数据
        try (ByteArrayInputStream bais = new ByteArrayInputStream(jsonBytes);
             ByteArrayOutputStream baos = new ByteArrayOutputStream();
             GZIPOutputStream gzipOS = new GZIPOutputStream(baos)) {

            // 将JSON数据写入GZIP输出流
            byte[] buffer = new byte[1024];
            int length;
            while ((length = bais.read(buffer)) != -1) {
                gzipOS.write(buffer, 0, length);
            }
            gzipOS.finish(); // 完成压缩

            // 将压缩后的数据写入文件
            try (FileOutputStream fos = new FileOutputStream(gzipFileName)) {
                baos.writeTo(fos);
            }
        }
    }

}
