package test.study.news.web;

import java.util.*;

/**
 * Created by dell on 2019/8/27.
 */
public class MyTest8 {

    public static void main(String[] args) throws Exception{
//        LinkedList<String> list = new LinkedList<>();
//        list.add("aaa");
//        list.add("bbb");
//        list.add("ccc");
//        System.out.println(list.remove());
         test2();

    }

    private static void test1(){
        String str1 = "000001";
        String str2 = "000002";
        String str3 = "000003";

        Set<String> set = new LinkedHashSet<>();
        set.add(str2);
        set.add(str3);
        set.add(str1);

        for (String str : set){
            System.out.print(str+",");
        }
    }

    private static void test2() {
        String[] arr = new String[1000000];
        for (int i = 0;i<1000000;i++){
            arr[i] = String.valueOf(i);
        }

//        for (String str : arr){
//            System.out.print(str+",");
//        }

        long start = System.currentTimeMillis();
        chaos1(arr);
        long end = System.currentTimeMillis();
        System.out.println("消耗时间:"+(end-start));
//        for (String str : arr){
//            System.out.print(str+",");
//        }
    }


    private static void chaos1(String[] arr){
        int i = arr.length;
        Random random = new Random();
        int limit = i/2;
        while(i > limit){
            Integer randomIndex = random.nextInt(i--);
            String temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
    }

    private static void chaos2(String[] arr){
        int i = arr.length;
        while(i > 0){
            Integer floor = (int)Math.floor(Math.random() * i--);
            String temp = arr[i];
            arr[i] = arr[floor];
            arr[floor] = temp;
        }
    }

    private static void chaos3(String[] arr){
        int i = arr.length;
        Random random = new Random();
        while(i > 0){
            i--;
            Integer randomIndex = random.nextInt(arr.length);
            String temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
    }

}
