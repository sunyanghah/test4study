package test.study.java.mianshi2020;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2020/5/13.
 * @author dell
 */
public class Test0513_1_waitnotify_2 {

    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Object object = new Object();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        executor.execute(()->{
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object){
                for (char c : aC) {
                    System.out.print(c);
                    try {
                        object.notify();
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                object.notify();
            }
        });
        executor.execute(()->{
            synchronized (object){
                countDownLatch.countDown();
                for (char c : aI) {
                    System.out.print(c);
                    try {
                        object.notify();
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                object.notify();
            }
        });
        executor.shutdown();

    }

}
