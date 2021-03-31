package test.study.news.web;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by dell on 2019/8/28.
 */
public class MyTest9 {

    public static void main(String[] args) throws Exception{
        test2();
    }


    private static void test2() throws Exception{
        ArrayList list = new ArrayList();
        for (int i = 0;i<1000000;i++){
            list.add(String.valueOf(i));
        }
        System.out.println(list.size());
        long start = System.currentTimeMillis();
        for (int i = 0;i<10000;i++){
            list.remove(list.size()-1);
        }
        long end = System.currentTimeMillis();
        System.out.println("消耗时间:"+(end-start));
        System.out.println(list.size());

    }


//    private static void test() throws Exception{
//        ArrayList<String> arr = new ArrayList<>();
//        for (int i = 0;i<1000000;i++){
//            arr.add(String.valueOf(i));
//        }
//
////        for (String str : arr){
////            System.out.print(str+",");
////        }
//
//        long start = System.currentTimeMillis();
//        chaos3(arr);
//        long end = System.currentTimeMillis();
//        System.out.println();
//        System.out.println("消耗时间:"+(end-start));
////
////        for (String str : arr){
////            System.out.print(str+",");
////        }
//    }

    private static void chaos1(ArrayList<String> arr){
        int i = arr.size();
        Random random = new Random();
        int limit = i/2;
        while(i > limit){
            Integer randomIndex = random.nextInt(i--);
            String temp = arr.get(i);
            arr.set(i,arr.get(randomIndex));
            arr.set(randomIndex,temp);
        }
    }

//    private static void chaos3(ArrayList<String> arr){
//        int i = arr.size();
//        Random random = new Random();
//        while(i > 0){
//            i--;
//            Integer randomIndex = random.nextInt(arr.size());
//            String temp = arr.get(i);
//            arr.set(i,arr.get(randomIndex));
//            arr.set(randomIndex,temp);
//        }
//    }

}
