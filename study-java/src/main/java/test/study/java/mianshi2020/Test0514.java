package test.study.java.mianshi2020;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 2020/5/14.
 * @author dell
 */
public class Test0514 {

    public static void main(String[] args) {
        test2();
    }

    public static void test1(){
        System.out.println(1050 & 3);
    }

    public static void test2(){
        Map map = new HashMap<>();
        map.put(null,"123");
        System.out.println(map.containsKey(null)); // true
        Map map2 = new HashMap<>();
        System.out.println(map2.containsKey(null)); // false
    }
}
