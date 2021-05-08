package test.study.java.mianshiti2021;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunYang
 * @Date 2021-04-23
 */
public class Test0423_1 {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        try {
            reentrantLock.lock();

            System.out.println("111");
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("222");
        }finally {
            reentrantLock.unlock();
        }

    }

}
