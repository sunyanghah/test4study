package test.study.java.mianshi2020;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunYang
 * @Date 2020/8/14
 */
public class Test0814 {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "c", "d");
        strings.stream().peek(str ->{
            System.out.println(str);
                }
        ).collect(Collectors.toList());
    }

}
