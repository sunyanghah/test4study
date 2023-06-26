package test.study.java.mianshiti2023;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunYang
 * @date 2023/2/13 14:58
 */
public class Test0213 {

    public static void main(String[] args) {
        List<String> ciTypes = new ArrayList<>();
        ciTypes.add("abc");
        String[] strings = ciTypes.toArray(new String[5]);

        System.out.println(strings);
    }

}
