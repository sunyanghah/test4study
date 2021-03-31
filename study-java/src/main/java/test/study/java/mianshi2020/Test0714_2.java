package test.study.java.mianshi2020;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by dell on 2020/7/14.
 * @author dell
 */
public class Test0714_2 {

    public static void main(String[] args) {

        Set set = new TreeSet<>();
        set.add(2);
        set.add(4);
        set.add(1);
        set.add(3);

        set.forEach(System.out::println);

    }



}
