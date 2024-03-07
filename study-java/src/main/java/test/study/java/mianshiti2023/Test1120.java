package test.study.java.mianshiti2023;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test1120 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,5,2,3,1);
//        sort(list);
//        list.forEach(System.out::println);

//        list.add(2);
        list.sort(Comparator.comparingInt(a -> a));

        list.forEach(System.out::println);
    }
    public static void sort(List<Integer> list){
        list.sort((a,b)->{
            return a-b;
        });
    }
}
