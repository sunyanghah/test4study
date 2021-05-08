package test.study.java.mianshiti2021;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @author sunYang
 * @Date 2021-04-25
 */
public class Test0425_1 {

    public static void main(String[] args) throws InterruptedException {

        int i = 5;

        HashMap<Object, Object> map = new HashMap<>(1024);

        CountDownLatch countDownLatch = new CountDownLatch(i);

        new Thread(() -> {
            System.out.println("i am in");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i am done");
        },"t1").start();

        Thread.sleep(1000);

        while (i>0){
            System.out.println("====="+i);
            countDownLatch.countDown();
            i--;
        }


    }

}
