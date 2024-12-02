package test.study.java.mianshiti2024;

import java.util.*;

/**
 * @author sun yang
 * @date 2024/6/19
 */
public class Test0619 {

    public static void main(String[] args) {

        Map map1 = new HashMap();
        map1.put("key","1");
        Map map2 = new HashMap();
        map2.put("key","2");
        Map map3 = new HashMap();
        map3.put("key","3");
        Map map4 = new HashMap();
        map4.put("key","4");

        List<Map> list = new ArrayList<>();
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);

        list.forEach(System.out::println);

        Iterator<Map> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().get("key").toString().equals("3")) {
                iterator.remove();
            }
        }

        System.out.println("--------------------");

        list.forEach(System.out::println);

    }

}
