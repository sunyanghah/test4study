package test.study.java.mianshiti2022;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunYang
 * @date 2022/8/2 10:12
 */
public class Test0802 {

    public static void main(String[] args) throws Exception{
        String filePath = "C:/xxv/file/staticResource/forecastData/response.json";
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        while(str != null){
            sb.append(str);
            str = br.readLine();
        }
        br.close();

        List<ThirdOutForecastRailcarDto> totalList = new ArrayList<>();

        List<ThirdOutForecastRailcarDto> list = JSON.parseObject(sb.toString(), new TypeReference<List<ThirdOutForecastRailcarDto>>(){});

        for (int i=0;i<7;i++){
            List<ThirdOutForecastRailcarDto> temp = JSON.parseObject(JSON.toJSONString(list), new TypeReference<List<ThirdOutForecastRailcarDto>>(){});
            for (ThirdOutForecastRailcarDto dto : temp) {
                dto.setTimeStamp(dto.getTimeStamp()+(5400*i));
            }
            totalList.addAll(temp);
        }


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        bw.write(JSON.toJSONString(totalList));
        bw.flush();
        bw.close();

    }

    @Data
    public static class ThirdOutForecastRailcarDto {

        /**
         * 距离当天凌晨2点的秒数
         */
        private Integer timeStamp;

        /**
         * 当前时间点车辆运行信息
         */
        private List<TrainInfo> trainInfoList;

        @Data
        public static class TrainInfo {

            /**
             * 线路编码
             */
            private Integer lineCode;

            /**
             * 区间编码
             */
            private String sectionCode;

            /**
             * 车次号
             */
            private String trainNo;

            /**
             * 车辆唯一编码
             */
            private String ciCode;

            /**
             * 行驶区间比例
             */
            private Integer sectionPercent;

            /**
             * 剩余到站时间
             */
            private Integer arriveSeconds;
        }

    }

}
