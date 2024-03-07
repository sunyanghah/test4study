package test.study.java.mianshiti2023;

/**
 * @author sunyang
 * @date 2023-10-26
 * @desc
 */
public class Test1026 {

    public static void main(String[] args) throws Exception{

        test3();


    }

    public static void test1() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("this is t1");
        });
        Thread t2 = new Thread(() -> {
            System.out.println("this is t2");
        });
        Thread t3 = new Thread(() -> {
            System.out.println("this is t3");
        });
        t2.start();
        t2.join();

        t1.start();
        t1.join();

        t3.start();
    }

    public static void test2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("this is t1");
        });
       t1.run();

    }

    public static void test3() throws InterruptedException {
        Object lockObj = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lockObj){
                try {
                    System.out.println("this is 1111");
                    lockObj.wait();
                    System.out.println("this is 2222");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        t1.start();

    }

}
