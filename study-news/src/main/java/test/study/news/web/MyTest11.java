package test.study.news.web;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by dell on 2019/11/22.
 */
public class MyTest11 {

    public static void main(String[] args) throws Exception{
        test4();
    }

    private static void test1() throws Exception{
        String[] arr = new String[]{"a","b","c","d"};
        String[] arr2 = arr;
        arr2[2] = "jjj";
        for (String s : arr) {
            System.out.print(s+" ");
        }
    }

    private static void test2() throws Exception{
        String str = "bearer";
        String text = "bearer 12345678";
        System.out.println(text.substring(str.length()+1));
    }

    private static void test3() throws Exception{
        String str = "123,444,567";
        boolean contains = Arrays.asList(str.split(",")).contains(444+"");
        System.out.println(contains);
    }

    private static void test4() throws Exception{
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-01"));
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
    }

}
