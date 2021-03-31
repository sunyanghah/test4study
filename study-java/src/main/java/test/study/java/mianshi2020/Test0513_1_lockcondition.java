package test.study.java.mianshi2020;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dell on 2020/5/13.
 * @author dell
 */
public class Test0513_1_lockcondition {


    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
//        Condition condition2 = lock.newCondition();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        threadPoolExecutor.execute(()->{
            try {
                lock.lock();
                for (char c : aC) {
                    System.out.print(c);
                    try {
                        condition1.signal();
                        condition1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                condition1.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });

        threadPoolExecutor.execute(()->{
            try {
                lock.lock();
                for (char c : aI) {
                    System.out.print(c);
                    try {
                        condition1.signal();
                        condition1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                condition1.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });

        threadPoolExecutor.shutdown();
    }

}
