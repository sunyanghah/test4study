package test.study.java.mianshi2020;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by dell on 2020/5/29.
 * @author dell
 */
@Slf4j
public class Test0529 {

    public static void main(String[] args) throws Exception {
        test4();
    }

    public static void test1() throws Exception{
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("this is thread t1");
            }
        };
        thread.setName("t1");
        thread.run();
        System.out.println("--------");
    }

    public static void test2() throws Exception{
        Thread t1 = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        System.out.println(t1.getState()); // NEW
        t1.start();
        Thread.sleep(100); // 主线程sleep，为了让t1线程能执行
        System.out.println(t1.getState());// TIMED_WAITING
    }

    public static void test3() throws Exception{
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                System.out.println("enter sleep");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println(" interrupted sleep");
                }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("stop sleep");
            }
        };

        t1.start();
        Thread.sleep(300);
        System.out.println("i am go to interrupt t1");
        System.out.println(t1.isInterrupted()); // false
        t1.interrupt();
        System.out.println(t1.isInterrupted()); // false 因为sleep wait join当中被打断时，会重置为false；因为有打断异常的抛出

    }

    public static void test4() throws Exception{

        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                for (int i =0;;){
                    System.out.println("=====1-->"+i++);
                }
            }
        };
        Thread t2 = new Thread("t2"){
            @Override
            public void run() {
                for (int i =0;;){
//                    Thread.yield();
                    System.out.println("              =====2-->"+i++);
                }
            }
        };
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }


    volatile static int r = 0;
    public static void test5() throws Exception{
        log.info("开始");
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                log.info("开始");
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                r = 10;
                log.info("结束");
            }
        };
        t1.start();
        t1.join();
        log.info("r结果打印{}",r);
        log.info("结束");
    }

    public static void test6() throws Exception{
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                while(true){
                    boolean interrupted = Thread.interrupted(); // 查看是否被打断
                    if (interrupted){ // 被打断就退出循环
                        System.out.println("我被打断了，我退出了");
                        break;
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); // sleep,join,wait被打断时，打断标记是false，所以需要自己打断以设置为true
                    }
                }
            }
        };
        System.out.println("i am go to interrupt t1");
        System.out.println(t1.isInterrupted()); // false
        t1.start();
        Thread.sleep(100);
        t1.interrupt(); // 打断并不会停止线程t1的执行
        System.out.println(t1.isInterrupted()); // true
    }

    public static void test7() throws Exception{
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                log.info("park...");
                LockSupport.park();
                log.info("unpack...");
                log.info("打断状态:{}",Thread.currentThread().isInterrupted());
                LockSupport.park();
                log.info("pack方法被打断后，再次pack将失败");
                LockSupport.park();
                log.info("pack方法被打断后，每次pack都失败");
                log.info("第二种方法获取打断标记：{}",Thread.interrupted());
                LockSupport.park();
                log.info("Thread.interrupted()方法同样可以返回打断标记的状态，但是之后会将状态改为false");
            }
        };
        t1.start();
        Thread.sleep(100);
        t1.interrupt();
    }

    public static void test8(){
        char ch = 'd';
        Character character = 'd';
        byte a = 0;
        Byte byt = 2;
        short b = 1;
        Short sho = 3;
        int c = 2;
        Integer inte = 3;
        long d = 3;
        String str = "";
        switch (TestEnum.A){}
    }

    enum TestEnum{
         A,B
    }

    public static void test9(){
        Thread thread = new Thread("t1"){
            @Override
            public void run() {
                int i = 0;
                while (true){
                    System.out.println(i++);
                    if (isInterrupted()){
                        break;
                    }
                }
            }
        };
        thread.start();
        thread.interrupt();
    }

}
