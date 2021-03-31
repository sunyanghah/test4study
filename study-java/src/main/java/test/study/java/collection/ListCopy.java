package test.study.java.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2020/1/8.
 */
public class ListCopy {


    public static void main(String[] args) {
        List<Map> list1 = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("name","张三");
        list1.add(map1);
        Map<String,Object> map2 = new HashMap<>();
        map2.put("name","李四");
        list1.add(map2);
        Map<String,Object> map3 = new HashMap<>();
        map3.put("name","王五");
        list1.add(map3);
        list1.forEach(System.out::println);
        List<Map> list2 = new ArrayList<>(list1);
        Map map = list2.get(1);
        map.put("age",1111);

        list1.forEach(System.out::println);
        list2.forEach(System.out::println);



    }

}
