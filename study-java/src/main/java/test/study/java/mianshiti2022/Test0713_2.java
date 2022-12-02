package test.study.java.mianshiti2022;

import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang3.SystemUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;

/**
 * @author sunYang
 * @date 2022/7/13 15:07
 */
public class Test0713_2 {

    public static void main(String[] args) throws Exception{

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.set(Calendar.HOUR_OF_DAY,24);
        endCalendar.set(Calendar.MINUTE,0);
        endCalendar.set(Calendar.SECOND,0);
        endCalendar.set(Calendar.MILLISECOND,0);

        while (true){
            long end = endCalendar.getTimeInMillis();
            long now = Calendar.getInstance().getTimeInMillis();
            if (now > end){
                break;
            }
            test1(end,now);
            Thread.sleep(1000);
        }

    }

    public static void test1(long end,long now){

        long expireMill = end - now;

        long leftHour = expireMill / 1000 / 60 / 60;

        long leftMinute = (expireMill-(leftHour*1000*60*60))/1000/60;

        long leftSecond = (expireMill-(leftHour*1000*60*60)-(leftMinute*1000*60))/1000;

        System.out.println("距离明天还剩"+leftHour+"小时"+leftMinute+"分钟"+leftSecond+"秒");
    }


}
