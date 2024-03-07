package test.study.java.mianshi2020;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunyang
 * @date 2023-10-30
 * @desc
 */
public class Test0513_zhexuejiajiucan_lockcondition {

    private Lock lock = new ReentrantLock();
    private Condition[] conditions = new Condition[5];
    private boolean[] forks = new boolean[5];

    public Test0513_zhexuejiajiucan_lockcondition() {
        for (int i = 0; i < 5; i++) {
            conditions[i] = lock.newCondition();
        }
    }

    public static void main(String[] args) {
        Test0513_zhexuejiajiucan_lockcondition dp = new Test0513_zhexuejiajiucan_lockcondition();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            final int j = i;
            executorService.submit(() -> {
                try {
                    dp.takeForks(j);
                    Thread.sleep(1000);
                    dp.returnForks(j);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }

    public void takeForks(int id) throws InterruptedException {
        lock.lock();
        try {
            while (forks[id] || forks[(id + 1) % 5]) {
                conditions[id].await();
            }
            forks[id] = true;
            forks[(id + 1) % 5] = true;
        } finally {
            System.out.println("Philosopher " + id + " is eating");
            lock.unlock();
        }
    }

    public void returnForks(int id) {
        lock.lock();
        try {
            forks[id] = false;
            forks[(id + 1) % 5] = false;
            /**
             * 我放下筷子后，通知我左边和右边的人去竞争
             */
            conditions[(id + 4) % 5].signal();
            conditions[(id + 1) % 5].signal();
        } finally {
            System.out.println("Philosopher " + id + " has finished eating");
            lock.unlock();
        }
    }

}
