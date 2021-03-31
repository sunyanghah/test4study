package test.study.java.mianshiti2021;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunYang
 * @Date 2021-01-23
 */
public class Test0123 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        List<String> nowList = list.stream().filter(l -> !"c".equals(l)).map(l -> l.toUpperCase()).collect(Collectors.toList());

        System.out.println(nowList);

    }

}
