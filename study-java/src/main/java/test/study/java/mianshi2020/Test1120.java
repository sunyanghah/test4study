package test.study.java.mianshi2020;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author sunYang
 * @Date 2020/11/20
 */
public class Test1120 {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("a", "b","c","d","e");


        System.out.println(new Random().nextInt(strings.size()));

        System.out.println(strings.subList(3,5));

    }

}
