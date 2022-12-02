package test.stomp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author sunYang
 * @date 2022/3/9 10:15
 */
@RestController
@RequestMapping("/forecast")
public class TestForecastController {


    @GetMapping("/car/{timeStamp}")
    public List queryCar(@PathVariable("timeStamp")Long timeStamp) throws Exception{
        System.out.println("------------车车车-----------"+timeStamp);
        String filePath = "C:/xxv/file/staticResource/forecastData/response.json";
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        while(str != null){
            sb.append(str);
            str = br.readLine();
        }
        List<ThirdOutForecastRailcarDto> list = JSON.parseObject(sb.toString(), new TypeReference<List<ThirdOutForecastRailcarDto>>(){});
        Date date = new Date(timeStamp * 1000);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);

        long zeroClockTimeStamp = calendar.getTimeInMillis()/1000;
        long seconds = timeStamp - zeroClockTimeStamp;

        for (ThirdOutForecastRailcarDto dto : list) {
            if(dto.getTimeStamp().longValue() == seconds){
                return dto.getTrainInfoList();
            }
        }

        String data = "[{\"lineCode\":150,\"sectionCode\":\"15007-15008\",\"trainNo\":\"012153\",\"ciCode\":\"55012153\",\"sectionPercent\":100,\"arriveSeconds\":0,\"lateSeconds\":10},{\"lineCode\":150,\"sectionCode\":\"15008-15009\",\"trainNo\":\"012154\",\"ciCode\":\"55012154\",\"sectionPercent\":50,\"arriveSeconds\":90,\"lateSeconds\":0}]";
        return JSON.parseObject(data,new TypeReference<List>(){});

    }

    @GetMapping("/sectionInfo/{timeStamp}")
    public List querySection(@PathVariable("timeStamp")Long timeStamp){
        System.out.println("------------区间区间-----------"+timeStamp);
        String data = "[{\"sectionCode\":\"15007-15008\",\"crowded\":920,\"status\":\"0\"},{\"sectionCode\":\"15007-15008\",\"crowded\":1100,\"status\":\"2\"}]";
        return JSON.parseObject(data,new TypeReference<List>(){});
    }

    @GetMapping("/stationInfo/{timeStamp}")
    public List queryStation(@PathVariable("timeStamp")Long timeStamp){
        System.out.println("------------站点站点-----------"+timeStamp);

        String data;

        if (timeStamp == 0){
            data = "[{\"stationCode\":\"5017\",\"status\":\"0\",\"flow\":15000,\"flowPercent\":90,\"control\":[\"4\",\"5\"]},{\"stationCode\":\"15008\",\"status\":\"0\",\"flow\":15000,\"flowPercent\":92,\"control\":[\"4\",\"5\",\"6\"]}]";
        }else {
            data = "[{\"stationCode\":\"1017\",\"status\":\"0\",\"flow\":15000,\"flowPercent\":90,\"control\":[\"4\",\"5\"]},{\"stationCode\":\"5017\",\"status\":\"0\",\"flow\":15000,\"flowPercent\":92,\"control\":[\"4\",\"5\"]}]";
        }
        return JSON.parseObject(data,new TypeReference<List>(){});
    }

    @GetMapping("/alarm/{timeStamp}")
    public List queryAlarm(@PathVariable("timeStamp")Long timeStamp){
        System.out.println("-------------告警告警-----------"+timeStamp);

        String data;

        if (timeStamp == 0){
            data = "[{\"className\":\"区间\",\"ciCode\":\"15002-15003\",\"alarmId\":\"告警3334\",\"severity\":\"2\",\"status\":\"1\",\"message\":\"供电故障\",\"sourceAlertKey\":\"牵引\",\"sourceSeverity\":\"Critical\",\"alarmTime\":\"2018-08-19 17:18:23\",\"sourceId\":\"33\",\"alarmType\":\"供电故障\",\"comment\":\"\"},{\"className\":\"站点\",\"ciCode\":\"1001\",\"alarmId\":\"告警3345\",\"severity\":\"2\",\"status\":\"1\",\"message\":\"男厕电源故障了\",\"sourceAlertKey\":\"电源\",\"sourceSeverity\":\"Critical\",\"alarmTime\":\"2018-08-19 17:18:23\",\"sourceId\":\"2\",\"alarmType\":\"通信故障\",\"comment\":\"已检查处理\"}]";
        }else{
            data = "[{\"className\":\"区间\",\"ciCode\":\"15002-15003\",\"alarmId\":\"告警3334\",\"severity\":\"3\",\"status\":\"1\",\"message\":\"供电故障\",\"sourceAlertKey\":\"牵引\",\"sourceSeverity\":\"Critical\",\"alarmTime\":\"2018-08-19 17:18:23\",\"sourceId\":\"33\",\"alarmType\":\"供电故障\",\"comment\":\"\"},{\"className\":\"站点\",\"ciCode\":\"1010\",\"alarmId\":\"告警3345\",\"severity\":\"2\",\"status\":\"1\",\"message\":\"男厕电源故障了\",\"sourceAlertKey\":\"电源\",\"sourceSeverity\":\"Critical\",\"alarmTime\":\"2018-08-19 17:18:23\",\"sourceId\":\"2\",\"alarmType\":\"通信故障\",\"comment\":\"已检查处理\"}]";
        }
        return JSON.parseObject(data,new TypeReference<List>(){});
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
