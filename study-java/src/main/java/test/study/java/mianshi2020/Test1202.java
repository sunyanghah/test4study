package test.study.java.mianshi2020;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

/**
 * @author sunYang
 * @Date 2020-12-02
 */
public class Test1202 {

    public static void main(String[] args) {
        long mill = 10000000;

        SimpleDateFormat sdf = new SimpleDateFormat("HH小时mm分ss秒");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));

        System.out.println(sdf.format(mill));


        List<Integer> integers = Arrays.asList(1, 2, 3);

        integers.sort((o1,o2) -> -o1.compareTo(o2));

        System.out.println(integers);


    }

}
