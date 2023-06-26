package test.study.java.mianshiti2023;

import java.util.Arrays;
import java.util.List;

/**
 * @author sunYang
 * @date 2023/2/1 10:40
 */
public class Test0201 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        List<Integer> subs = list.subList(0, 4);

        System.out.println(subs.size()+"........."+list.size());


    }

}
