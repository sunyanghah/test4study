package test.study.java.mianshiti2023;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunyang
 * @date 2023-10-27
 * @desc
 */
public class test1027_2 {

    public static void main(String[] args) {
        test2();
    }

    public static void test1(){
        ReentrantLock reentrantLock = new ReentrantLock();
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("111111------"+threadName);
                reentrantLock.lock();
                System.out.println("222222------"+threadName);
                System.out.println(1/0);
                reentrantLock.unlock();
                System.out.println("333333------"+threadName);
            },"Thread--"+i);
            t.start();
        }
    }

    public static void test2(){
        ReentrantLock reentrantLock = new ReentrantLock();
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("111111------"+threadName);
                try {
                    reentrantLock.lock();
                    System.out.println("222222------" + threadName);
                    System.out.println(1 / 0);
                }catch (Exception e){}finally {
                    reentrantLock.unlock();
                    System.out.println("333333------"+threadName);
                }

            },"Thread--"+i);
            t.start();
        }
    }


}
