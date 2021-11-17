package test.study.java.mianshiti2021;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author sunYang
 * @Description:
 * @Title: Test0517
 * @Package test.study.java.mianshiti2021
 * @date 2021-05-1716:59
 */
public class Test0517 {

    public static void main(String[] args) {
        test1();
        System.out.println("-----------");
        test2();
        System.out.println("---------------");
        test3();
        System.out.println("====================");
        test4();
        System.out.println("***********");
        test5();
    }

    private static void test1(){
        Instant instant = Instant.now();
        System.out.println(instant);

        System.out.println(ZoneId.systemDefault().getId());

        OffsetDateTime dateTime = instant.atOffset(ZoneOffset.of("+8"));
        int year = dateTime.getYear();
        int month = dateTime.getMonthValue();
        int day = dateTime.getDayOfMonth();
        int hour = dateTime.getHour();

        System.out.println(year+"-"+month+"-"+day +" "+hour);

        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());

        System.out.println(zonedDateTime.getYear()+"-"+zonedDateTime.getMonthValue()+
                "-"+zonedDateTime.getDayOfMonth() +" "+zonedDateTime.getHour());
    }

    private static void test2(){
        Instant instant = Instant.ofEpochMilli(new Date().getTime());

        System.out.println(instant);

        System.out.println(ZoneId.systemDefault().getId());

        OffsetDateTime dateTime = instant.atOffset(ZoneOffset.of("+8"));
        int year = dateTime.getYear();
        int month = dateTime.getMonthValue();
        int day = dateTime.getDayOfMonth();
        int hour = dateTime.getHour();

        System.out.println(year+"-"+month+"-"+day +" "+hour);

        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());

        System.out.println(zonedDateTime.getYear()+"-"+zonedDateTime.getMonthValue()+
                "-"+zonedDateTime.getDayOfMonth() +" "+zonedDateTime.getHour());
    }

    private static void test3(){
        // wrong
        Instant instant = Instant.parse("2021-05-17T17:32:00.000Z");

        System.out.println(instant);

        System.out.println(ZoneId.systemDefault().getId());

        OffsetDateTime dateTime = instant.atOffset(ZoneOffset.of("+8"));
        int year = dateTime.getYear();
        int month = dateTime.getMonthValue();
        int day = dateTime.getDayOfMonth();
        int hour = dateTime.getHour();

        System.out.println(year+"-"+month+"-"+day +" "+hour);

        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());

        System.out.println(zonedDateTime.getYear()+"-"+zonedDateTime.getMonthValue()+
                "-"+zonedDateTime.getDayOfMonth() +" "+zonedDateTime.getHour());
    }

    private static void test4(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime l2 = LocalDateTime.of(2021, 5, 16, 9, 20);
        System.out.println(l2);

        System.out.println(localDateTime.toInstant(ZoneOffset.of("+8")));
        System.out.println(l2.toInstant(ZoneOffset.of("+8")));

    }

    private static void test5(){
        Instant instant = Instant.now();
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        String format = zonedDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHH"));
        System.out.println(format);

    }

}