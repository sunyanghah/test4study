package test.study.java.mianshi2020;

import com.alibaba.fastjson.JSON;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author sunYang
 * @Date 2020/9/10
 */
public class Test0910 {
    public static void main(String[] args) {
        Set<String> set = null;
//        set.forEach(System.out::print);
        set.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
    }
}
