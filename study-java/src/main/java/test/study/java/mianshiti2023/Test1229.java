package test.study.java.mianshiti2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sun yang
 * @date 2023/12/29
 */
public class Test1229 {

    public static void main(String[] args) {
        ArrayList<Long> list = new ArrayList<>(Arrays.asList(1L, 2L, 3L));
        List<Long> listExcept = list.stream().filter(num -> num.compareTo(2L) != 0).collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println("-------------");
        listExcept.forEach(System.out::println);
    }

}
