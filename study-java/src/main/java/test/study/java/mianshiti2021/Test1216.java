package test.study.java.mianshiti2021;

import java.util.*;

/**
 * @author sunYang
 * @date 2021/12/16 10:26
 */
public class Test1216 {

    public static void main(String[] args) {

        int[] arr = {1,3,4,5,8,3,1};

        BitSet bitSet = new BitSet();

        System.out.println(bitSet.size());

        for (int num : arr) {
            bitSet.set(num,true);
        }

        System.out.println(bitSet.size());
        System.out.println("---------------");
        bitSet.stream().forEach(System.out::println);
        System.out.println("----");
        System.out.println(bitSet.get(1));
        System.out.println(bitSet.get(2));


        List<HashMap> hashMapList = Arrays.asList(new HashMap());

        HashMap<Object, Object> map = new HashMap<>();

        test(map);
//        test2(hashMapList);

    }

    private static void test(Map map){

    }

    private static void test2(List<Map> map){

    }



}
