package test.study.java.mianshiti2023;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author sunyang
 * @date 2023-10-27
 * @desc
 */
public class Test1027_4 {


    //读写锁
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

    //写锁
    private final static Lock writeLock = readWriteLock.writeLock();

    //读锁
    private final static Lock readLock = readWriteLock.readLock();

    private final static List<Long> longs = new ArrayList<>();

    public final static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 3; i++) {
            new Thread(Test1027_4::read,"read"+i).start();
            Thread.sleep(1000);
        }
        for (int i = 0; i < 30; i++) {
            new Thread(Test1027_4::write,"write"+i).start();
        }


    }

    static void write() {

        try {
            writeLock.lock();
            System.out.println(Thread.currentThread().getName() + " write ");
            longs.add(System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    static void read() {
        try {
            readLock.lock();
            longs.forEach(x -> System.out.println(Thread.currentThread().getName()+"-----"+x));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }
    
}
