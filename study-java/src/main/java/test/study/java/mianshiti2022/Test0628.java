package test.study.java.mianshiti2022;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author sunYang
 * @date 2022/6/28 15:33
 */
public class Test0628 {

    public static void main(String[] args) {

        test();

    }

    public static void test(){

        LinkedHashSet set = new LinkedHashSet();

        set.add(1);
        set.add(3);
        set.add(2);
        set.add(4);

        set.forEach(System.out::println);

        System.out.println("-----------");

        set.add(2);

        set.forEach(System.out::println);

    }

    public static void test1(){
        Map map = new HashMap();

        map.put(1,1);
        map.put(3,3);
        map.put(2,2);

        map.entrySet().forEach(System.out::println);

        System.out.println("--------------");

        map.put(2,2);

        map.entrySet().forEach(System.out::println);
    }

    public static void test2(){
        List list = new ArrayList<>();

        list.add(1);
        list.add(3);
        list.add(2);
        list.add(4);

        list.forEach(System.out::println);

        System.out.println("-----------");

        int num = 2;
        int index;
        if ((index = list.indexOf(num)) != -1){
            list.remove(index);
        }
        list.add(0,num);

        list.forEach(System.out::println);
    }

}
