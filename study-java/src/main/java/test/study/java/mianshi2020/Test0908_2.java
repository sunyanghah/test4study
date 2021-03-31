package test.study.java.mianshi2020;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author sunYang
 * @Date 2020/9/8
 */
public class Test0908_2 {

    public static void main(String[] args) {
        List<Map<String, String>> maps = test2("2019-12");
        maps.forEach(map -> {
            System.out.println(map.get("weekKey") +"---"+map.get("weekValue"));
        });
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

        int weekNum = getWeekNumByMonth(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH));

        int initWeek = 1;
        calendar.set(Calendar.MONTH,Calendar.JANUARY);
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY){
            initWeek = 0;
            weekNum -= 1;
        }

        List list = new ArrayList();
        for(int i =initWeek ; i <= weekNum ; i++){
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
