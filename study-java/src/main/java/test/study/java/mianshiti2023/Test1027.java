package test.study.java.mianshiti2023;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunyang
 * @date 2023-10-27
 * @desc
 */
@Slf4j
public class Test1027 {

    static volatile int num = 50;
    static ReentrantLock reentrantLock = new ReentrantLock(true);

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(() -> {
                String threadName = Thread.currentThread().getName();
                while(true){
                    try {
                        reentrantLock.lock();
                        if (num > 0) {
                            System.out.println(threadName + "-------" + (num--));
                        } else {
                            break;
                        }
                    }catch (Exception e){

                    }finally {
                        reentrantLock.unlock();
                    }
                }
            },"Thread--"+i);
            t.start();
        }
    }

}
