package test.sy.zjzy.web;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by dell on 2019/9/6.
 */
public class Test3 {

    public static void main(String[] args) throws Exception{
         test3();

    }

    private static void test1() throws Exception{
        long startPow = System.currentTimeMillis();
        double pow = Math.pow(68546252, 2);
        System.out.println(pow);
        long endPow = System.currentTimeMillis();
        System.out.println("--------pow--"+(endPow-startPow));


        long startSqrt = System.currentTimeMillis();
        System.out.println(Math.sqrt(pow));
        long endSqrt = System.currentTimeMillis();
        System.out.println("--------sqrt--"+(endSqrt-startSqrt));
    }

    private static void test2() throws Exception{
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();

        long start1 = System.currentTimeMillis();
        for (int i = 0;i<300000;i++){
            arrayList.add(i);
        }
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        for (int i = 0;i<300000;i++){
            arrayList.add(0,i);
        }
        long end2 = System.currentTimeMillis();

        long start3 = System.currentTimeMillis();
        for (int i = 0;i<300000;i++){
            linkedList.add(i);
        }
        long end3 = System.currentTimeMillis();


        System.out.println("1------"+(end1-start1));
        System.out.println("2------"+(end2-start2));
        System.out.println("3------"+(end3-start3));

    }

    private static void test3(){
        int [][][] arrays=new int[4][3][2];//在栈空间创建一个空间

        for(int i=0;i<arrays.length;i++) {
            for(int i1=0;i1<arrays[i].length;i1++) {
                for(int i2=0;i2<arrays[i][i1].length;i2++) {
                    System.out.print(arrays[i][i1][i2]);
                }
                System.out.println();//二维换行
            }
            System.out.println();//三维换行
        }
    }

}
