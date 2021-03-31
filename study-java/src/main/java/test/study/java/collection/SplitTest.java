package test.study.java.collection;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dell on 2019/11/20.
 */
public class SplitTest {

    public static void main(String[] args) {
        String str = "sdfasdf";
        System.out.println(str.split(",").length);
        List<String> list = Arrays.asList(str.split(","));
        System.out.println(list.size());
        list.forEach(System.out::println);
    }
}
