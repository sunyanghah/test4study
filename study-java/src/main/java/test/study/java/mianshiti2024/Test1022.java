package test.study.java.mianshiti2024;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/10/22
 */
public class Test1022 {

    public static void main(String[] args) {
        String a = "fff";
        System.out.println(JSON.toJSONString(a));
        String b = "";
        System.out.println(JSON.toJSONString(b));
        String c = null;
        System.out.println(JSON.toJSONString(c));
        List<Object> d = Arrays.asList();
        System.out.println(JSON.toJSONString(d));
        List<String> e = Arrays.asList("a");
        System.out.println(JSON.toJSONString(e));
    }

}
