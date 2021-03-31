package test.study.java.mianshi2020;

import java.util.Arrays;
import java.util.List;

/**
 * @author sunYang
 * @Date 2020-12-31
 */
public class Test20201231 {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("bc", "abc", "abcd", "ac");

        strings.sort(String::compareTo);

        System.out.println(strings);

    }

}
