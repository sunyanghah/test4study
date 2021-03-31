package test.study.java.mianshi2020;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author sunYang
 * @Date 2020/9/7
 */
public class Test0907 {

    public static void main(String[] args) throws Exception{

//        Calendar calendar = Calendar.getInstance();
//
//        calendar.set(Calendar.MONTH,7);
//
//        System.out.println(new SimpleDateFormat("yyyy-MM").format(calendar.getTime()));
//
//        System.out.println(calendar.getMinimum(Calendar.WEEK_OF_MONTH));
//
//        System.out.println(calendar.getActualMaximum(Calendar.WEEK_OF_MONTH));
//
//        System.out.println(calendar.getMaximum(Calendar.WEEK_OF_MONTH));
//
//        System.out.println(calendar.getMaximum(Calendar.MONDAY));
//        System.out.println(calendar.getActualMaximum(Calendar.));
//        System.out.println(calendar.getMaximum(Calendar.MONDAY));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("yyyy-MM").parse("2020-08"));

        System.out.println("---------");
        System.out.println(calendar.get(Calendar.YEAR) );
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(new SimpleDateFormat("yyyy-MM").format(calendar.getTime()));
        test2(2020,8);

    }

    private static void test1(Integer year,Integer month){

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month-1);
        calendar.set(Calendar.DAY_OF_MONTH,3);

        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));

        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println();
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY);


    }

    private static void test2(Integer year,Integer month){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month-1);


        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int weekNum = 0;
        int i = 1;
        while (i<=maxDay){
            calendar.set(Calendar.DAY_OF_MONTH,i);
            if (calendar.get(Calendar.DAY_OF_WEEK ) == Calendar.MONDAY){
                weekNum ++;
            }
            i++;
        }

        System.out.println(weekNum);

    }



}
