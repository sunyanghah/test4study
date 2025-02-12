package test.study.java.mianshiti2025;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author sun yang
 * @date 2025/1/17
 */
public class Test0117 {

    public static boolean isCurrentTimeInRange(String startTime, String endTime) {
        // 定义时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // 获取当前时间
        LocalTime now = LocalTime.now();

        // 解析输入的开始时间和结束时间
        LocalTime start = LocalTime.parse(startTime, formatter);
        LocalTime end = LocalTime.parse(endTime, formatter);

        // 如果结束时间早于开始时间，说明时间范围跨越了午夜，需要特殊处理
        if (end.isBefore(start)) {
            // 如果当前时间大于等于开始时间或者小于等于结束时间，表示当前时间在这个跨午夜的范围内
            return now.isAfter(start) || now.isBefore(end);
        } else {
            // 如果当前时间在开始和结束时间之间
            return now.isAfter(start) && now.isBefore(end);
        }
    }

    public static void main(String[] args) {
        // 示例：检查当前时间是否在 22:00 到 02:00 之间
        String startTime = "10:00";
        String endTime = "10:00";

        boolean result = isCurrentTimeInRange(startTime, endTime);
        System.out.println("当前时间是否在范围内: " + result);
    }

}
