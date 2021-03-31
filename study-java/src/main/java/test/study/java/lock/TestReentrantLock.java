package test.study.java.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dell on 2020/1/14.
 * @author dell
 *
 * 1. 的确如其名，可重入锁，当然默认的确是非公平锁。
 * 2. thread-0持有锁期间，thread-2等待拥有锁，当thread-0释放锁时thread-7先获取到锁，并非按照先后顺序获取锁的。
 * 3. 独占
 *
 */
public class TestReentrantLock implements Runnable{

    ReentrantLock reentrantLock = new ReentrantLock();

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
        TestReentrantLock test = new TestReentrantLock();
        for (int i = 0; i < 10; i++) {
            new Thread(test, "thread-" + i).start();
        }
    }

    /**
     * 1 run thread name-->thread-1
     2 enter thread name-->thread-1
     3 get thread name-->thread-1
     4 set thread name-->thread-1
     5 leave run thread name-->thread-1
     1 run thread name-->thread-0
     2 enter thread name-->thread-0
     3 get thread name-->thread-0
     4 set thread name-->thread-0
     5 leave run thread name-->thread-0
     1 run thread name-->thread-2
     1 run thread name-->thread-7
     2 enter thread name-->thread-7
     3 get thread name-->thread-7
     1 run thread name-->thread-5
     1 run thread name-->thread-4
     1 run thread name-->thread-3
     4 set thread name-->thread-7
     5 leave run thread name-->thread-7
     1 run thread name-->thread-6
     2 enter thread name-->thread-6
     1 run thread name-->thread-8
     3 get thread name-->thread-6
     4 set thread name-->thread-6
     5 leave run thread name-->thread-6
     1 run thread name-->thread-9
     2 enter thread name-->thread-4
     3 get thread name-->thread-4
     4 set thread name-->thread-4
     5 leave run thread name-->thread-4
     2 enter thread name-->thread-5
     3 get thread name-->thread-5
     4 set thread name-->thread-5
     5 leave run thread name-->thread-5
     2 enter thread name-->thread-2
     3 get thread name-->thread-2
     4 set thread name-->thread-2
     5 leave run thread name-->thread-2
     2 enter thread name-->thread-3
     3 get thread name-->thread-3
     4 set thread name-->thread-3
     5 leave run thread name-->thread-3
     2 enter thread name-->thread-8
     3 get thread name-->thread-8
     4 set thread name-->thread-8
     5 leave run thread name-->thread-8
     2 enter thread name-->thread-9
     3 get thread name-->thread-9
     4 set thread name-->thread-9
     5 leave run thread name-->thread-9
     */
}
