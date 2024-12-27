package test.depend;

import com.asiainfo.file.watermark.bright.OfficeBrightWatermarkUtil;

/**
 * @author sun yang
 * @date 2024/12/4
 */
public class Test {

    public static void main(String[] args) throws Exception{

        OfficeBrightWatermarkUtil.addToDoc("F:\\watermark\\success\\doc.doc",
                "F:\\watermark\\success\\result\\",
                "{\"file_water_bright\":{\"color\":\"#00ff00\",\"customText\":\"这是自定义\",\"fontSize\":14,\"opacity\":63,\"plc_id\":233,\"plc_name\":\"wangfei_bright\",\"rotate\":45,\"waterFlags\":[\"\",\"\",\"王飞\",\"2024-11-25 20:06\"]}}");

    }

}
