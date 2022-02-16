package test.study.java.mianshiti2022;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author sunYang
 * @date 2022/1/25 20:39
 */
public class Test0125 {

    public static void main(String[] args) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-01-25 01:01:01"));
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
    }

}

