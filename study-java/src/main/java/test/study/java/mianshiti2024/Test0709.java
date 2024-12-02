package test.study.java.mianshiti2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sun yang
 * @date 2024/7/9
 */
public class Test0709 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(2, 3, 4);

        List<Map> expUserList = list.stream().filter(exp -> exp > 5).map(user -> {
            Map map = new HashMap();
            map.put(user, user);
            return map;
        }).collect(Collectors.toList());

        System.out.println(expUserList);
    }

}
