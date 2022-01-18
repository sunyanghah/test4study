package test.study.java.mianshiti2022;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunYang
 * @date 2022/1/13 14:55
 */
public class Test0113 {

    /**
     * 记录上次时间轴的值
     */
    private static int prevTimeAxisValue = 0;

    private static int step = 30;

    // 浏览器最少渲染响应时间
    private static final int minResponseSecond = 5;

    private static int prevResponseTime = 0;

    private static boolean washFlag = false;

    // TODO 1. 切换倍速  2. 数据清洗
    public static void main(String[] args) throws Exception{

        // 倍速
        int speed = 45;

        int[] timeAxisValueArr = buildTimeAxis();
        prevTimeAxisValue = timeAxisValueArr[0];

        int backDragPoint = 28890;
        int frontDragPoint = 33990;

        initGetData(28800);

        for (int i=28800;i<=34200;) {

            int gridNumOfOneTime = speed;
            moveTimeAxis(gridNumOfOneTime);

            i += gridNumOfOneTime;

            Thread.sleep(1000);

//            if (i == 28980){
//                System.out.println("***********往后拖动了，遮罩，重新渲染车的位置");
//                i = frontDragPoint;
//                prevTimeAxisValue = frontDragPoint;
//                initGetData(frontDragPoint);
//            }
//
//            if (i == 29160){
//                System.out.println("***********往前拖动了，遮罩，重新渲染车的位置");
//                i = backDragPoint;
//                prevTimeAxisValue = backDragPoint;
//                initGetData(backDragPoint);
//            }

            if (washFlag){
                prevResponseTime ++;
            }

            if (prevResponseTime >= 5){
                washFlag = false;
                prevResponseTime = 0;
            }

            System.out.println("=============================================================");

        }

    }

    private static void initGetData(int time) throws Exception{
        getDataByTime(time);
    }

    private static String formatTime(int time){
        int hour = time/3600;
        int minute = (time-hour*3600)/60;
        int second = time-hour*3600-minute*60;

        String formatHour = hour<10?"0"+hour:String.valueOf(hour);
        String formatMinute = minute<10?"0"+minute:String.valueOf(minute);
        String formatSecond = second<10?"0"+second:String.valueOf(second);

        return formatHour+":"+formatMinute+":"+formatSecond;
    }


    /**
     * 构建时间轴
     */
    private static int[] buildTimeAxis(){
        int[] valueArr = new int[5401];
        for(int i=0;i<=5400;i++){
            valueArr[i] = i + 28800;
        }
        return valueArr;
    }

    /**
     * 时间轴移动事件
     */
    private static void handleTimeAxisMoveEvent(int gridNum) throws Exception{
        for (int i = 1;i <= gridNum;i++) {
            int timeAxisValue = prevTimeAxisValue+i;
            if (timeAxisValue > 34200){
                return;
            }
            if (timeAxisValue % step == 0){
                getDataByTime(timeAxisValue);
            }
        }
    }

    private static void getDataByTime(int time) throws Exception{
        String forecastDataPath = "H:\\xxv\\forecastData\\"+time+".json";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(forecastDataPath))));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        while(str != null){
            sb.append(str);
            str = br.readLine();
        }
        System.out.println("获取到了如下文件数据----"+time+".json");

        InProducerDataDto inProducerDataDto = JSON.parseObject(sb.toString(), InProducerDataDto.class);

        List<InProducerDataDto.CiPerformance> ciPerformanceList = inProducerDataDto.getCiPerformanceList();

        if (washFlag){
            System.out.println("##############洗数据#######");
            ciPerformanceList = washData(inProducerDataDto.getCiPerformanceList());
        }else{
            washFlag = true;
        }

        moveCar(ciPerformanceList);
    }

    private static List<InProducerDataDto.CiPerformance> washData(List<InProducerDataDto.CiPerformance> ciPerformanceList) throws Exception{
        List<InProducerDataDto.CiPerformance> arrivedList = new ArrayList<>();
        // 判断是否是到站数据，如果是到站数据则不清洗。
        for (InProducerDataDto.CiPerformance ciPerformance : ciPerformanceList) {
            List<InProducerDataDto.Performance> performanceList = ciPerformance.getPerformanceList();

            if ("100".equals(getValueByMetric(performanceList,"所处区间比例"))){
                arrivedList.add(ciPerformance);
            }
        }
        return arrivedList;
    }

    private static void moveCar(List<InProducerDataDto.CiPerformance> ciPerformanceList){
        System.out.println("更新车辆位置------运行数据量---"+ciPerformanceList.size());
    }

    /**
     * 被动移动时间轴
     */
    private static void moveTimeAxis(int gridNum) throws Exception{
        System.out.println("moving---"+gridNum);
        System.out.println("当前时间轴--------"+(prevTimeAxisValue+gridNum));
        handleTimeAxisMoveEvent(gridNum);
        prevTimeAxisValue += gridNum;
    }

    private static String getValueByMetric(List<InProducerDataDto.Performance> performanceList,String metric){
        InProducerDataDto.Performance performance = performanceList.stream().filter(p -> metric.equals(p.getMetric()))
                .findFirst().orElse(null);
        if (performance == null){
            return null;
        }
        return performance.getValue();
    }

    @Data
    public static class InProducerDataDto {

        private String className;

        private List<CiPerformance> ciPerformanceList;

        @Data
        public static class CiPerformance {

            private String ciCode;

            private List<Performance> performanceList;

        }

        @Data
        public static class Performance {

            private String metric;

            private String value;

            private String unit;

            private String time;

        }

    }

}
