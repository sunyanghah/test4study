package test.study.java.mianshiti2022;

import java.util.Calendar;

/**
 * @author sunYang
 * @date 2022/1/14 19:02
 */
public class Test0114 {

    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        int hour = instance.get(Calendar.HOUR_OF_DAY);
        int minute = instance.get(Calendar.MINUTE);
        int second = instance.get(Calendar.SECOND);

        System.out.println(hour+"--"+minute+"--"+second);

        int seconds = hour * 3600 + minute * 60 + second;

        System.out.println(seconds);

        System.out.println(seconds/30*30);

    }

}
