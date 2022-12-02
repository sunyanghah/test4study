package test.study.java.mianshiti2022;

import java.text.SimpleDateFormat;

/**
 * @author sunYang
 * @date 2022/2/21 17:31
 */
public class Test0221 {

    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Long time = new Long("1645435936717");
        String timeString = simpleDateFormat.format(time);
        System.out.println(timeString);


    }
}
