package test.study.java.mianshiti2022;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 * @author sunYang
 * @date 2022/7/13 15:41
 */
public class Test0713_3 {

    public static void main(String[] args) {
        Instant now = Instant.now();
        Instant endOfDay = getEndOfDay(now);
        long expireSecond = secondsUntil(now, endOfDay);
        System.out.println(expireSecond+"-------");
        long leftHour = expireSecond / 60 / 60;
        long leftMinute = (expireSecond-(leftHour*60*60))/60;
        long leftSecond = (expireSecond-(leftHour*60*60)-(leftMinute*60));
        System.out.println("距离明天还剩"+leftHour+"小时"+leftMinute+"分钟"+leftSecond+"秒");
    }
    /**
     * 时间间隔（秒）
     *
     * @param endExclusive
     * @param until
     * @return
     */
    public static long secondsUntil(Instant endExclusive, Instant until) {
        return endExclusive.atZone(ZoneId.systemDefault()).until(until.atZone(ZoneId.systemDefault()),
                ChronoUnit.SECONDS);
    }
    /**
     * 一天的结束时间
     *
     * @return
     */
    public static Instant getEndOfDay(Instant instant) {
        // 获取jvm时区
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, zoneId);
        LocalDateTime endDateTime =
                LocalDateTime.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth(), 23, 59, 59, 999999999);
        return endDateTime.atZone(zoneId).toInstant();
    }
}
