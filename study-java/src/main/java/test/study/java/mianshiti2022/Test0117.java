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
public class Test0117 {

    // 记录上次时间轴的值
    private static int prevTimeAxisValue = 0;

    // 提供的数据间隔，即甲方提供的数据是每多少秒一次
    private static int step = 30;

    // 浏览器最少渲染响应时间，拿最大车辆数据量来说，渲染完最少需要的秒数。
    private static final int minResponseSecond = 5;
    // 用来记录上次渲染全部车辆位置数据的时间。
    // 名词解释:->
    // 全部车辆位置数据：某一个时间点全部车辆的位置数据，不清洗数据。
    // 清洗数据：某一个时间点的数据只保留车辆的到站数据，其他的丢弃。
    // 被清洗数据：清洗数据操作保留下来的到站数据。
    private static int prevResponseTime = 0;

    // 用来标识该次数据是否需要清洗。
    private static boolean washFlag = false;

    //
    public static void main(String[] args) throws Exception{

        System.out.println(System.currentTimeMillis());
        // 倍速1,用来模拟切换倍速
        int speed1 = 10;
        // 倍速2,用来模拟切换倍速
        int speed2 = 20;
        // 倍速3,用来模拟切换倍速
        int speed3 = 40;

        int[] timeAxisValueArr = buildTimeAxis();

        // 一个半小时时间段的开始时间
        int startTime = timeAxisValueArr[0];
        // 一个半小时时间段的结束时间
        int endTime = timeAxisValueArr[timeAxisValueArr.length-1];

        // 初始获取第一次的数据
        initGetData(startTime);
        // 初始获取第一次的数据时，时间轴本来就在最开始，所以获取第一次数据后，设置该变量为时间轴开始时间
        prevTimeAxisValue = startTime;

//        // 某个时间点，用来模拟拖动进度条到这个地方
//        int backDragPoint = 28890;
//        // 某个时间点，用来模拟拖动进度条到这个地方
//        int frontDragPoint = 33990;

        // 模拟定时任务，一秒循环一次
        for (int i=startTime;i<=endTime;) {

            // 此变量是本次循环(即定时)移动的时间轴格数。一共5400格
            int gridNumOfOneTime = 1;

            // 模拟8点到8点半用speed1倍速
            if (i >= 28800 && i<30600){
                gridNumOfOneTime = speed1;
            // 模拟8点半到9点切换到speed2倍速
            }else if (i >= 30600 && i<32400){
                gridNumOfOneTime = speed2;
            // 模拟9点到9点半切换到speed3倍速
            }else if (i >= 32400){
                gridNumOfOneTime = speed3;
            }

            // 移动时间轴，入参是移动的格数，
            // 可以看到入参是倍速。是因为原本一倍速，一秒移动一格，倍速下则是一秒移动倍速格
            moveTimeAxis(gridNumOfOneTime);

            // 倍速增长
            i += gridNumOfOneTime;

            // 沉睡一秒
            Thread.sleep(1000);

//            // 模拟播着播着往后拖动
//            if (i == 28980){
//                System.out.println("***********往后拖动了，遮罩，重新渲染车的位置");
//                // 拖动后，i赋值为拖动到的地方
//                i = frontDragPoint;
//                // 拖动后，时间轴的值设置为拖动到的地方
//                prevTimeAxisValue = frontDragPoint;
//                // 获取拖动到的地方的数据
//                initGetData(frontDragPoint);
//            }
//            // 模拟播着播着往之前拖动
//            if (i == 29160){
//                System.out.println("***********往前拖动了，遮罩，重新渲染车的位置");
//                // 拖动后，i赋值为拖动到的地方
//                i = backDragPoint;
//                // 拖动后，时间轴的值设置为拖动到的地方
//                prevTimeAxisValue = backDragPoint;
//                // 获取拖动到的地方的数据
//                initGetData(backDragPoint);
//            }
            // 如果清洗数据，则prevResponseTime累加，每次加代表一秒
            if (washFlag){
                prevResponseTime ++;
            }
            // 如果prevResponseTime 超过了系统所需渲染时间，代表上一次全量数据渲染已经完成。
            if (prevResponseTime >= minResponseSecond){
                // 则下一次不再清洗数据
                washFlag = false;
                // 重置prevResponseTime
                prevResponseTime = 0;
            }

            System.out.println("=============================================================");

        }

        System.out.println(System.currentTimeMillis());

    }

    /**
     * 根据传入时间获取传入时间点的数据
     * @author sunYang
     * @param time
     * @return void
     * @date 2022/1/17 14:50
     */
    private static void initGetData(int time) throws Exception{
        getDataByTime(time);
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
     * 根据传入移动格数处理时间轴移动事件
     * @author sunYang
     * @param gridNum
     * @return void
     * @date 2022/1/17 14:51
     */
    private static void handleTimeAxisMoveEvent(int gridNum) throws Exception{
        // 遍历传入格数
        for (int i = 1;i <= gridNum;i++) {
            // 上次记录的时间轴位置不断+1(因为prevTimeAxisValue在循环里没变，i累加)
            int timeAxisValue = prevTimeAxisValue+i;
            // 多倍速时，会出现最后移动的格数超过这一个半小时的最大格数的情况，这里添加判断。
            if (timeAxisValue > 34200){
                return;
            }
            // 始终牢记，这里的timeAxisValue与prevTimeAxisValue是28800-34200之间的一个数字(以8点到9点半为例)。
            // 所以格数到某一个点的时候是有对应数据的
            if (timeAxisValue % step == 0){
                getDataByTime(timeAxisValue);
            }
        }
    }

    /**
     * 根据时间点查询该时刻数据
     * @author sunYang
     * @param time
     * @return void
     * @date 2022/1/17 14:59
     */
    private static void getDataByTime(int time) throws Exception{
        // 我这里是文件名为时间的一堆文件，所以查文件
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
        // 如果需要清洗数据则本次清洗
        if (washFlag){
            System.out.println("##############洗数据#######");
            // 清洗数据
            ciPerformanceList = washData(inProducerDataDto.getCiPerformanceList());
        // 如果不需要，则本次不清洗，把washFlag改为true，即minResponseSecond时间内，其他查到的数据都要清洗
        }else{
            washFlag = true;
        }
        // 将未清洗或清洗后的数据渲染给车辆，让车动
        moveCar(ciPerformanceList);
    }

    /**
     * 清洗数据
     * @author sunYang
     * @param ciPerformanceList
     * @return java.util.List<test.study.java.mianshiti2022.Test0117.InProducerDataDto.CiPerformance>
     * @date 2022/1/17 15:03
     */
    private static List<InProducerDataDto.CiPerformance> washData(List<InProducerDataDto.CiPerformance> ciPerformanceList) throws Exception{
        List<InProducerDataDto.CiPerformance> arrivedList = new ArrayList<>();
        // 判断是否是到站数据，如果是到站数据则留下该数据，其他的丢弃。这里是用的所处区间比例判定的，也可以用剩余到站时间
        for (InProducerDataDto.CiPerformance ciPerformance : ciPerformanceList) {
            List<InProducerDataDto.Performance> performanceList = ciPerformance.getPerformanceList();

            if ("100".equals(getValueByMetric(performanceList,"所处区间比例"))){
                arrivedList.add(ciPerformance);
            }
        }
        return arrivedList;
    }

    /**
     * 渲染移动车辆
     * @author sunYang
     * @param ciPerformanceList
     * @return void
     * @date 2022/1/17 15:04
     */
    private static void moveCar(List<InProducerDataDto.CiPerformance> ciPerformanceList){
        System.out.println("更新车辆位置------运行数据量---"+ciPerformanceList.size());
    }

    /**
     * 被动移动时间轴，传入移动的格数
     * @author sunYang
     * @param gridNum
     * @return void
     * @date 2022/1/17 15:04
     */
    private static void moveTimeAxis(int gridNum) throws Exception{
        System.out.println("moving---"+gridNum);
        System.out.println("当前时间轴--------"+(prevTimeAxisValue+gridNum));
        // 触发移动时间轴事件，去获取数据并渲染
        handleTimeAxisMoveEvent(gridNum);
        // 更新上次时间轴的记录
        prevTimeAxisValue += gridNum;
    }

    /**
     * 根据metric获取value
     * @author sunYang
     * @param performanceList
     * @param metric
     * @return java.lang.String
     * @date 2022/1/17 15:06
     */
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
