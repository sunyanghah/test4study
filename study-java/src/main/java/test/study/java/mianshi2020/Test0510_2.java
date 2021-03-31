package test.study.java.mianshi2020;

/**
 * Created by dell on 2020/5/10.
 * @author dell
 */
public class Test0510_2 {


    /**
     * 死锁
     * @param args
     */
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();
        new Thread(()->{
            while(true) {
                synchronized (object1) {
                    System.out.println("thread1------1");
                    synchronized (object2) {
                        System.out.println("thread1---------2");
                    }
                }
            }
        }).start();
        new Thread(()->{
            while(true) {
                synchronized (object2) {
                    System.out.println("thread2------1");
                    synchronized (object1) {
                        System.out.println("thread2---------2");
                    }
                }
            }
        }).start();

    }

}
