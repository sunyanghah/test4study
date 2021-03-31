package test.study.java.mianshiti2021;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author sunYang
 * @Date 2021-01-04
 */
public class Test0104 {

    public static void main(String[] args) {

        String datetime = "2021-03";

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
        System.out.println(weekNumbe);
    }

}
