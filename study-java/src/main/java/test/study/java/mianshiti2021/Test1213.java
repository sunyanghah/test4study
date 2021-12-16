package test.study.java.mianshiti2021;

import java.util.*;

/**
 * @author sunYang
 * @date 2021/12/13 10:42
 */
public class Test1213 {

    public static void main(String[] args) {
//        Map<String,String> obj = null;
        Map<String,String> obj = new HashMap<>(); obj.put("name","张三");
        String value = Optional.ofNullable(obj)
                .map(o -> o.get("name"))
                .orElse(null);
        System.out.println(value);

        List<String> strList = new ArrayList<>();
        Optional.ofNullable(obj)
                .ifPresent(o -> {
                    strList.add(o.get("name"));
                });
        System.out.println(strList.size());
    }

}
