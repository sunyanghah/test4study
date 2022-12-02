package test.study.java.mianshiti2022;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author sunYang
 * @date 2022/11/14 14:44
 */
public class Test1114 {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("1", "a", "ddd");

        String[] phoneArr = strings.toArray(new String[strings.size()]);

        System.out.println(phoneArr);

    }

}
