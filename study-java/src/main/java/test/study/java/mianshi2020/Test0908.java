package test.study.java.mianshi2020;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author sunYang
 * @Date 2020/9/7
 */
public class Test0908 {

    public static void main(String[] args) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.YEAR,2020);
//        calendar.set(Calendar.MONTH,0);
//        calendar.set(Calendar.DAY_OF_MONTH,1);
//        calendar.setFirstDayOfWeek(Calendar.MONDAY);
//        Integer weekNumbe = calendar.get(Calendar.WEEK_OF_YEAR);
//        System.out.println(weekNumbe);
        test1();
    }

    private static void test1(){
        String selectTime = "2020-12";
        String selectTimeBefore = null;
        String selectTimeAfter = null;
        if (selectTime != null && selectTime.length() > 0) {
            try {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new SimpleDateFormat("yyyy-MM").parse(selectTime));
                calendar.add(Calendar.MONTH,1);
                selectTimeAfter = calendar.get(Calendar.YEAR)+"-"+ (calendar.get(Calendar.MONTH)+1);

                calendar.add(Calendar.MONTH,-2);
                selectTimeBefore = calendar.get(Calendar.YEAR)+"-"+ (calendar.get(Calendar.MONTH)+1);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println(selectTimeBefore);
        System.out.println(selectTimeAfter);
    }

}
