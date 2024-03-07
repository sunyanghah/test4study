package test.study.java.mianshiti2023;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author sunyang
 * @date 2023-10-27
 * @desc
 */
public class Test1027_3 {

    //读写锁
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //写锁
    private final static Lock writeLock = readWriteLock.writeLock();

    //读锁
    private final static Lock readLock = readWriteLock.readLock();

    private final static List<Long> longs = new ArrayList<>();

    public final static void main(String[] args) throws InterruptedException {

        new Thread(Test1027_3::write).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(Test1027_3::read,"read1").start();
        new Thread(Test1027_3::read,"read2").start();

    }

    static void write() {

        try {
            writeLock.lock();
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName() + " write ");
            longs.add(System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    static void read() {
        try {
            readLock.lock();
            TimeUnit.SECONDS.sleep(1);
            longs.forEach(x -> System.out.println(Thread.currentThread().getName()+"-----"+x));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

}
