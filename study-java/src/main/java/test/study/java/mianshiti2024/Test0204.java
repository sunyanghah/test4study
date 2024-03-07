package test.study.java.mianshiti2024;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/2/4
 */
public class Test0204 {

    public static void main(String[] args) {

        List<Long> deleteUserIdList = new ArrayList<>();
        deleteUserIdList.add(1L);
        deleteUserIdList.add(2L);
        deleteUserIdList.add(3L);


        System.out.println(JSON.toJSONString(deleteUserIdList.toArray(new Long[deleteUserIdList.size()+2])));

        System.out.println("-------------");
        System.out.println(String.join(",", Arrays.asList()));

        System.out.println("--------------");
        System.out.println(JSON.toJSONString(Arrays.asList("".split(","))));

        System.out.println("-------------");
        System.out.println("1.0.1001.15".compareTo("1.0.1001.16"));
        System.out.println("1.0.1001.15".compareTo("1.0.1001.15"));
        System.out.println("1.0.1001.15".compareTo("1.0.1001.14"));
    }
}
