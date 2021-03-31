package test.study.java.mianshi2020;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author sunYang
 * @Date 2020/11/7
 */
public class Test1107_2 {

    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("234");
        BigDecimal b2 = new BigDecimal("345");
        BigDecimal b3 = new BigDecimal("234");
        BigDecimal b4 = new BigDecimal("23");
        BigDecimal b5 = new BigDecimal("23");

        /**
         * false
         * false
         * false
         */
        System.out.println(b1 == b2);
        System.out.println(b1 == b3);
        System.out.println(b4 == b5);

        /**
         * 无序
         */
        Map<BigDecimal,String> map = new HashMap<>();
        map.put(b1,"b1");
        map.put(b2,"b2");
        map.put(b3,"b3");
        map.put(b4,"b4");
        map.put(b5,"b5");

        map.entrySet().forEach(entry -> {
            System.out.println(entry.getValue()+"===="+entry.getKey());
        });

        System.out.println("-------2------");
        /**
         * 有序
         */
        Map<BigDecimal,String> map2 = new TreeMap<>();
        map2.put(b1,"b1");
        map2.put(b2,"b2");
        map2.put(b3,"b3");
        map2.put(b4,"b4");
        map2.put(b5,"b5");

        map2.entrySet().forEach(entry -> {
            System.out.println(entry.getValue()+"===="+entry.getKey());
        });

    }

}
