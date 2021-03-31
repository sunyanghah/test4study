package test.study.java.mianshi2020;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunYang
 * @Date 2020/8/15
 */
public class Test0815 {

    public static void main(String[] args) {
        List<String> target = Arrays.asList("a", "b","z","v","v","n","m");
        List<String> valueList = Arrays.asList("c","d","f","g","a");

        List<String> c = valueList.stream().filter(str -> {
            String s = target.stream().filter(value -> {
                return str.equals(value);
            }).findAny().orElse(null);
            if (s == null){
                return false;
            }else{
                return true;
            }
        }).collect(Collectors.toList());


        System.out.println(c);
    }

}
