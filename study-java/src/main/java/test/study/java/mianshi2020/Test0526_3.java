package test.study.java.mianshi2020;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by dell on 2020/5/26.
 */
public class Test0526_3 {

    public static void main(String[] args) throws Exception{
        long start = System.currentTimeMillis();

        // 等凉菜
        Runnable ca1 = () -> {
            try {
                System.out.println("开始准备凉菜");
                Thread.sleep(1000);
                System.out.println("凉菜出锅");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
//        System.out.println(ca1.call()); //不会开启新线程
        FutureTask<String> ft1 = new FutureTask<>(ca1,"33333");
        new Thread(ft1).start();

        // 等包子 -- 必须要等待返回的结果，所以要调用join方法
        Runnable ca2 = () -> {
            try {
                System.out.println("开始准备包子");
                Thread.sleep(1000*3);
                System.out.println("包子出锅");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        FutureTask<String> ft2 = new FutureTask<>(ca2,"555");
        new Thread(ft2).start();

        System.out.println(ft2.get());
        System.out.println(ft1.get());

        long end = System.currentTimeMillis();
        System.out.println("准备完毕时间："+(end-start));
    }

}
