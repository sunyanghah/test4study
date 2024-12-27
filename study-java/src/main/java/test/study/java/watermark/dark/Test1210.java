package test.study.java.watermark.dark;

import com.alibaba.fastjson.JSON;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/12/10
 */
public class Test1210 {

    public static void main(String[] args) throws Exception{
        File file = new File("F:\\watermark\\dark\\docx.docx");

        long id = 42;

        List<Long> traceDtoList = new ArrayList<>();
        FileInputStream parseInputStream = new FileInputStream(file);
        String traceStr = HiddenWaterMarkUtil.parseMarker(file.getName(), parseInputStream);
        if (traceStr != null) {
            traceDtoList = JSON.parseArray(traceStr, Long.class);
        }
        // 如果时间倒序，则插入到第一个。否则插入到最后一个
        traceDtoList.add(id);

        ByteArrayOutputStream byteArrayOutputStream = HiddenWaterMarkUtil.marker(file.getName(), new FileInputStream(file), JSON.toJSONString(traceDtoList));
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        fileOutputStream.flush();
        fileOutputStream.close();

        String finalStr = HiddenWaterMarkUtil.parseMarker(file.getName(), new FileInputStream(file));
        List<Long> traceIdList = JSON.parseArray(finalStr, Long.class);
        System.out.println("-------jiawanzaiqu-------"+traceIdList);
    }

}
