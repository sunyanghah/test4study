package test.study.java.mianshiti2023;

import java.util.*;

/**
 * @author sunYang
 * @date 2023/2/8 17:57
 */
public class Test0208 {

    public static void main(String[] args) {

        test3();

    }

    public static void test1(){
        Map<String, List<String>> map = new HashMap<>();

        map.put("names", Arrays.asList("zhangsan","lisi"));

        // key 存在时返回key的值，不存在时执行lambda表达式
        List<String> names = map.computeIfAbsent("names", k -> Arrays.asList("1"));

//        names.remove(0);
//        names.add("wangwu"); // Arrays.asList 不可增删数据

        System.out.println(names);
    }

    public static void test2(){
        Map<String, List<String>> map = new HashMap<>();

        map.put("names", Arrays.asList("zhangsan","lisi"));

        // key 不存在时返回null ，存在时执行lambda表达式
        List<String> names = map.computeIfPresent("names2", (k,v) ->  v.subList(0,1));

//        names.remove(0);
//        names.add("wangwu"); // Arrays.asList 不可增删数据

        System.out.println(names);
    }

    public static void test3(){
        Map<String, List<String>> map = new HashMap<>();

        map.put("names", Arrays.asList("zhangsan","lisi"));

        // key 存在时返回key的值，不存在时执行lambda表达式,不存在时会影响Map
        map.computeIfAbsent("names2", k -> new ArrayList<>()).add("111");

        System.out.println(map.size());

    }

}
