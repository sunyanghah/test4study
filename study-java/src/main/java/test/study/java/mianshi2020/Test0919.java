package test.study.java.mianshi2020;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author sunYang
 * @Date 2020/9/19
 */
public class Test0919 {

    public static void main(String[] args) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+0800");
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.YEAR,2020);
//        calendar.set(Calendar.MONTH,Calendar.JANUARY);
//        calendar.set(Calendar.DAY_OF_YEAR,1);
//        System.out.println(sdf.format(calendar.getTime()));
//
//        calendar.set(Calendar.DAY_OF_YEAR,-1);
//        System.out.println(sdf.format(calendar.getTime()));

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,-1);
        calendar.set(Calendar.MINUTE,-10);
//        System.out.println(sdf.format(calendar.getTime()));

    }

}
