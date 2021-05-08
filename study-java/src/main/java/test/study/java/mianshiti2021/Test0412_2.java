package test.study.java.mianshiti2021;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author sunYang
 * @Date 2021-04-12
 */
public class Test0412_2 {

    public static void main(String[] args) {
        List<Map<String, String>> maps = whatMonthWeekGe2021("2021-03");
        maps.forEach(map -> {
            System.out.println(map.get("weekValue"));
        });

        System.out.println("----------");

        List<Map<String, String>> maps1 = test2("2021-03");
        maps1.forEach(map ->{
            System.out.println(map.get("weekValue"));
        });
    }

    private static List<Map<String,String>> whatMonthWeekGe2021(String datetime){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Date date = null;
        try {
            date = format.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Integer weekNumber = calendar.get(Calendar.WEEK_OF_YEAR);

        calendar.add(Calendar.MONTH,1);
        Integer weekNum = calendar.get(Calendar.WEEK_OF_YEAR) - weekNumber;


        List list = new ArrayList();
        for(int i = 0 ; i < weekNum ; i++){
            Map<String,String> map = new HashMap<>(16);
            map.put("weekKey",String.valueOf(weekNumber+i));
            map.put("weekValue","第"+(weekNumber+i)+"周");
            list.add(map);
        }
        return list;
    }

    private static List<Map<String,String>> test2(String datetime){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Date date = null;
        try {
            date = format.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
        Integer weekNumbe = calendar.get(Calendar.WEEK_OF_YEAR);

        // 获取某个月内的周数。依据业务需求，找这个月内的星期一的个数
        int weekNum = getWeekNumByMonth(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH));

        int initWeek = 1;
        calendar.set(Calendar.MONTH,Calendar.JANUARY);
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY){
            initWeek = 0;
            weekNum -= 1;
        }

        List list = new ArrayList();
        for(int i = initWeek ; i <= weekNum ; i++){
            Map<String,String> map = new HashMap<>(16);
            map.put("weekKey",String.valueOf(weekNumbe+i));
            map.put("weekValue","第"+(weekNumbe+i)+"周");
            list.add(map);
        }
        return list;
    }
    private static int getWeekNumByMonth(Integer year,Integer month){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);

        int actualMaximum = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int num = 0;
        for (int i = 1;i<= actualMaximum;i++) {
            calendar.set(Calendar.DAY_OF_MONTH, i);
            if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY){
                num++;
            }
        }
        return num;
    }

}
