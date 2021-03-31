package test.study.java.mianshi2020;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunYang
 * @Date 2020-12-09
 */
public class Test1209 {

    public static void main(String[] args) {
        test2();
    }

    private static void test1(){
        Long a = null;
        System.out.println(0 == a);
    }

    private static void test2(){
        Map<String,Object> map = new HashMap<>();
        map.remove("sdfs");
    }

}
