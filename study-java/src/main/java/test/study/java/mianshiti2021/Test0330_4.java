package test.study.java.mianshiti2021;

import java.util.*;

/**
 * @author sunYang
 * @Date 2021-03-30
 */
public class Test0330_4 {

    public static void main(String[] args) {
        test4();

    }

    private static void test1(){
        Set<String> set = new TreeSet<>();
        set.add("a");
        set.add("b");
        set.add("b");
        set.add("c");

        set.forEach(System.out::println);
    }

    private static void test2(){

        List<String> list1 = Arrays.asList("a", "b", "c");
        List<String> list2 = Arrays.asList("b", "c");

        Set<String> set = new TreeSet<>();
        set.addAll(list1);
        set.addAll(list2);

        set.forEach(System.out::println);

    }

    private static void test3(){
        Set<String> set = new TreeSet<>((o1,o2) -> {
            if (o1.equals(o2)){
                return 0;
            }else {
                return 1;
            }
        });
        set.add("a");
        set.add("b");
        set.add("d");
        set.add("b");
        set.add("c");
        set.add("a");


        set.forEach(System.out::println);
    }


    private static void test3_1(){
        Map<String,String> map = new TreeMap<>((o1,o2) -> {
            if (o1.equals(o2)){
                return 0;
            }else {
                return 1;
            }
        });
        map.put("a",null);
        map.put("b",null);
        map.put("d",null);
        map.put("b",null);
        map.put("c",null);
        map.put("a",null);


        map.keySet().forEach(System.out::println);
    }

    private static void test4(){
        Set<Integer> set = new TreeSet<>((o1,o2) -> {
            if (o1 > o2){
                return 1;
            }else if (o1 < o2){
                return -1;
            }else {
                return 0;
            }
        });
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(2);
        set.add(3);
        set.add(1);

        set.forEach(System.out::println);
    }

}
