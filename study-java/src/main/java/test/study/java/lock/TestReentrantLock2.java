package test.study.java.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dell on 2020/1/14.
 * @author dell
 *
 * 公平锁在多个线程想要同时获取锁的时候，会发现再排队，按照先来后到的顺序进行。
 */
public class TestReentrantLock2 implements Runnable{

    ReentrantLock reentrantLock = new ReentrantLock(true);

    public void get() {
        reentrantLock.lock();
        System.out.println("2 enter thread name-->" + Thread.currentThread().getName());
        System.out.println("3 get thread name-->" + Thread.currentThread().getName());
        set();
        System.out.println("5 leave run thread name-->" + Thread.currentThread().getName());
        reentrantLock.unlock();
    }

    public void set() {
        reentrantLock.lock();
        System.out.println("4 set thread name-->" + Thread.currentThread().getName());
        reentrantLock.unlock();
    }

    @Override
    public void run() {
        System.out.println("1 run thread name-->" + Thread.currentThread().getName());
        get();
    }

    public static void main(String[] args) {
        TestReentrantLock2 test = new TestReentrantLock2();
        for (int i = 0; i < 10; i++) {
            new Thread(test, "thread-" + i).start();
        }

        /**
         * 1 run thread name-->thread-1
         1 run thread name-->thread-0
         2 enter thread name-->thread-1
         3 get thread name-->thread-1
         4 set thread name-->thread-1
         5 leave run thread name-->thread-1
         1 run thread name-->thread-3
         1 run thread name-->thread-2
         2 enter thread name-->thread-0
         1 run thread name-->thread-4
         3 get thread name-->thread-0
         4 set thread name-->thread-0
         5 leave run thread name-->thread-0
         1 run thread name-->thread-7
         2 enter thread name-->thread-3
         3 get thread name-->thread-3
         4 set thread name-->thread-3
         5 leave run thread name-->thread-3
         1 run thread name-->thread-5
         2 enter thread name-->thread-2
         1 run thread name-->thread-9
         1 run thread name-->thread-8
         1 run thread name-->thread-6
         3 get thread name-->thread-2
         4 set thread name-->thread-2
         5 leave run thread name-->thread-2
         2 enter thread name-->thread-4
         3 get thread name-->thread-4
         4 set thread name-->thread-4
         5 leave run thread name-->thread-4
         2 enter thread name-->thread-7
         3 get thread name-->thread-7
         4 set thread name-->thread-7
         5 leave run thread name-->thread-7
         2 enter thread name-->thread-5
         3 get thread name-->thread-5
         4 set thread name-->thread-5
         5 leave run thread name-->thread-5
         2 enter thread name-->thread-9
         3 get thread name-->thread-9
         4 set thread name-->thread-9
         5 leave run thread name-->thread-9
         2 enter thread name-->thread-8
         3 get thread name-->thread-8
         4 set thread name-->thread-8
         5 leave run thread name-->thread-8
         2 enter thread name-->thread-6
         3 get thread name-->thread-6
         4 set thread name-->thread-6
         5 leave run thread name-->thread-6

         */
    }

}
