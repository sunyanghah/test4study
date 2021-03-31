package test.study.java.mianshi2020;

import org.openjdk.jol.info.ClassLayout;

import java.util.Vector;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by dell on 2020/6/1.
 * @author dell
 * Test biased
 */
public class Test0601 {

    public static void main(String[] args) throws Exception {
        test10();
    }

    /**
     * 默认开启偏向锁，但是默认是延迟的，所以这里markword最后三位是001，加如下参数可关闭延迟
     * @throws Exception
     */
    public static void test1() throws Exception{
        Dog dog = new Dog();
        /**
         * 默认开启偏向锁，但是默认是延迟的，所以这里markword最后三位是001，加如下参数可关闭延迟
         * -XX:BiasedLockingStartupDelay=0
         */
        System.out.println(ClassLayout.parseInstance(dog).toPrintable()); // 05 00 00 00 (00000001 00000000 00000000 00000000) (5)

        Thread.sleep(4000);

        Dog dog2 = new Dog();
        System.out.println(ClassLayout.parseInstance(dog2).toPrintable()); // 05 00 00 00 (00000101 00000000 00000000 00000000) (5)
    }

    /**
     * 加锁后再次打印，依然是101，说明偏向
     * @throws Exception
     */
    public static void test2() throws Exception{
        Dog dog = new Dog();
        System.out.println(ClassLayout.parseInstance(dog).toPrintable()); // 05 00 00 00 (00000101 00000000 00000000 00000000) (5)

        synchronized (dog){
            System.out.println(ClassLayout.parseInstance(dog).toPrintable()); // 05 d8 a7 02 (00000101 11011000 10100111 00000010) (44554245)
        }

        /**
         * 偏向了
         */
        System.out.println(ClassLayout.parseInstance(dog).toPrintable()); // 05 d8 a7 02 (00000101 11011000 10100111 00000010) (44554245)

    }

    /**
     * 如果要禁用偏向锁则使用 -XX:-UseBiasedLocking
     * 禁用后默认是001，加锁成为了轻量级锁
     * @throws Exception
     */
    public static void test3() throws Exception{
        Dog dog = new Dog();
        System.out.println(ClassLayout.parseInstance(dog).toPrintable()); // 01 00 00 00 (00000001 00000000 00000000 00000000) (1)

        synchronized (dog){
            System.out.println(ClassLayout.parseInstance(dog).toPrintable()); // f8 ec bb 02 (11111000 11101100 10111011 00000010) (45870328)
        }

        System.out.println(ClassLayout.parseInstance(dog).toPrintable()); // 01 00 00 00 (00000001 00000000 00000000 00000000) (1)

    }

    /**
     * 当一个可偏向的对象调用了hashCode()方法之后，因为偏向模式下存不下hash码。
     * 就会撤销掉此对象的偏向锁模式。
     * @throws Exception
     */
    public static void test4() throws Exception{
        Thread.sleep(4000);
        Dog dog = new Dog();
        dog.hashCode();
        System.out.println(ClassLayout.parseInstance(dog).toPrintable()); // 01 44 3f 45 (00000001 01000100 00111111 01000101) (1161774081)

        synchronized (dog){
            System.out.println(ClassLayout.parseInstance(dog).toPrintable()); // b8 e7 e7 02 (10111000 11100111 11100111 00000010) (48752568)
        }

        System.out.println(ClassLayout.parseInstance(dog).toPrintable()); // 01 44 3f 45 (00000001 01000100 00111111 01000101) (1161774081)
    }

    /**
     * 锁膨胀，偏向锁在其他线程给同一个对象加锁且没有竞争时升级为轻量级锁
     * @throws Exception
     */
    public static void test5() throws Exception{
        // 开启了非延时
        Dog dog = new Dog();
        // 偏向锁
        new Thread("t1"){
            @Override
            public void run() {
                System.out.println(ClassLayout.parseInstance(dog).toPrintable()); // 05 00 00 00 (00000101 00000000 00000000 00000000) (5)
                synchronized (dog){
                    System.out.println(ClassLayout.parseInstance(dog).toPrintable()); // 05 50 54 19 (00000101 01010000 01010100 00011001) (424955909)
                }
                System.out.println(ClassLayout.parseInstance(dog).toPrintable()); // 05 50 54 19 (00000101 01010000 01010100 00011001) (424955909)
                synchronized (Test0601.class){
                    Test0601.class.notify();
                }
            }
        }.start();
        new Thread("t2"){
            @Override
            public void run() {
                // 确保不会竞争，不然升级为重量级锁
                synchronized (Test0601.class){
                    try {
                        Test0601.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(ClassLayout.parseInstance(dog).toPrintable()); // 05 50 54 19 (00000101 01010000 01010100 00011001) (424955909)
                // 升级为轻量级锁
                synchronized (dog){
                    System.out.println(ClassLayout.parseInstance(dog).toPrintable()); // 90 f0 41 1a (10010000 11110000 01000001 00011010) (440529040)
                }
                System.out.println(ClassLayout.parseInstance(dog).toPrintable()); // 01 00 00 00 (00000001 00000000 00000000 00000000) (1)
            }
        }.start();
    }

    /**
     * 锁膨胀，多个线程给同一个对象加锁并且竞争时膨胀为重量级锁
     * @throws Exception
     */
    public static void test6() throws Exception{
        // 开启了非延时
        Dog dog = new Dog();
        new Thread("t1"){
            @Override
            public void run() {
                // 竞争前对象是可偏向的
                System.out.println("1111"+ClassLayout.parseInstance(dog).toPrintable()); // 05 00 00 00 (00000101 00000000 00000000 00000000) (5)
                synchronized (dog){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 和线程2竞争后升级为重量级锁
                    System.out.println("2222"+ClassLayout.parseInstance(dog).toPrintable()); // 6a 03 e4 17 (01101010 00000011 11100100 00010111) (400819050)
                }
                // 保持重量级锁
                System.out.println("3333"+ClassLayout.parseInstance(dog).toPrintable()); // 6a 03 e4 17 (01101010 00000011 11100100 00010111) (400819050)
            }
        }.start();
        new Thread("t2"){
            @Override
            public void run() {
                // 未竞争前对象是可偏向的
                System.out.println("4444"+ClassLayout.parseInstance(dog).toPrintable()); // 05 00 00 00 (00000101 00000000 00000000 00000000) (5)
                synchronized (dog){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 和线程1竞争，升级为重量级锁
                    System.out.println("5555"+ClassLayout.parseInstance(dog).toPrintable()); // 6a 03 e4 17 (01101010 00000011 11100100 00010111) (400819050)
                }
                // 保持重量级锁
                System.out.println("6666"+ClassLayout.parseInstance(dog).toPrintable()); // 6a 03 e4 17 (01101010 00000011 11100100 00010111) (400819050)
            }
        }.start();
    }

    /**
     * 调用过wait 或 notify方法后 不可偏向
     */
    public static void test7(){
        Dog dog = new Dog();
        // normal 可偏向
        System.out.println(ClassLayout.parseInstance(dog).toPrintable()); // 05 00 00 00 (00000101 00000000 00000000 00000000) (5)
        synchronized (dog){
            dog.notify();
        }
        // normal 调用过notify后 不可偏向
        System.out.println(ClassLayout.parseInstance(dog).toPrintable()); // 01 00 00 00 (00000001 00000000 00000000 00000000) (1)

        synchronized (dog){
            // 轻量级锁
            System.out.println(ClassLayout.parseInstance(dog).toPrintable()); // c0 e8 45 02 (11000000 11101000 01000101 00000010) (38136000)
        }
        // 不可偏向 normal
        System.out.println(ClassLayout.parseInstance(dog).toPrintable()); // 01 00 00 00 (00000001 00000000 00000000 00000000) (1)

    }

    /**
     * 批量重偏向，当某个类的对象在一个线程撤销偏向的次数过多，默认20次。
     * jvm就会(认为当前线程是不是不大活跃了或者有其他的线程更活跃,我也不知道)转而将该类之后的所有对象重偏向为当前线程
     */
    static Thread t1,t2,t3,t4;
    public static void test8(){
        Vector<Object> dogs = new Vector<>();
        int num = 30;
        t1 = new Thread("t1"){
            @Override
            public void run() {
                for (int i =0;i<num;i++){
                    // 前25个对象为Dog类的对象
                    if (i < num-5) {
                        Dog dog = new Dog();
                        dogs.add(dog);
                        synchronized (dog){
                            // 25个dog对象都偏向t1
                            System.out.println(i+"----"+ClassLayout.parseInstance(dog).toPrintable());
                        }
                    // 后5个对象为Object对象
                    }else{
                        Object obj = new Object();
                        dogs.add(obj);
                        synchronized (obj){
                            // 5个object对象都偏向t1
                            System.out.println(i+"----"+ClassLayout.parseInstance(obj).toPrintable());
                        }
                    }
                }
                LockSupport.unpark(t2);
            }
        };
        t1.start();
        t2 = new Thread("t2"){
            @Override
            public void run() {
                LockSupport.park();
                Dog dog = new Dog();
                dogs.add(dog);
                // 偏向t2
                synchronized (dog){
                    System.out.println("t3-----------"+ClassLayout.parseInstance(dog).toPrintable());
                }
                LockSupport.unpark(t3);
            }
        };
        t2.start();
        t3 = new Thread("t3"){
            @Override
            public void run() {
                LockSupport.park();
                System.out.println("==================================");
                for (int i = 0;i < num; i++){
                    Object dog = dogs.get(i);
                    // 29个对象此时都还是偏向t1
                    System.out.println(i+"----"+ClassLayout.parseInstance(dog).toPrintable());
                    synchronized (dog){
                        // 前19次obj对象这里因为本t3线程的加锁使用，膨胀为轻量级锁
                        // 第20次时触发批量重偏向，重偏向为t3.第20个到第24个Dog对象都是偏向t3
                        // 第25个以后的Object对象，则还是膨胀为轻量级锁
                        System.out.println(i+"----"+ClassLayout.parseInstance(dog).toPrintable());
                    }
                    // 前19次Dog对象回复为不可偏向状态的normal
                    // 第20个到第24个Dog对象回复为偏向t2的状态
                    // 第25个以后的Object，还是回复为不可偏向状态
                    System.out.println(i+"----"+ClassLayout.parseInstance(dog).toPrintable());
                }
                // 之前的仍膨胀为轻量级锁
                synchronized (dogs.get(3)) {
                    System.out.println("看看之前的20个的随便一个----" + ClassLayout.parseInstance(dogs.get(3)).toPrintable());
                }
                LockSupport.unpark(t4);
            }
        };
        t3.start();

        t4 = new Thread("t4"){
            @Override
            public void run() {
                LockSupport.park();
                Object dogsT3 = dogs.get(num);
                synchronized (dogsT3){
                    System.out.println("t3--look----"+ClassLayout.parseInstance(dogsT3).toPrintable());
                }
            }
        };
        t4.start();

    }

    /**
     * 批量撤销，当撤销偏向锁阈值达到40次后，jvm会将该类的所有对象变为不可偏向的，新建的对象也是不可偏向的。
     * @throws InterruptedException
     */
    public static void test9() throws InterruptedException {
        Vector<Object> dogs = new Vector<>();
        int num = 39;
        t1 = new Thread("t1"){
            @Override
            public void run() {
                for (int i =0;i<num;i++){
                    if (i < num) {
                        Dog dog = new Dog();
                        dogs.add(dog);
                        synchronized (dog){
                            // dog对象都偏向t1
                            System.out.println("t1--"+i+"----"+ClassLayout.parseInstance(dog).toPrintable());
                        }
                    }
                }
                LockSupport.unpark(t2);
            }
        };
        t1.start();
        t2 = new Thread("t2"){
            @Override
            public void run() {
                LockSupport.park();
                System.out.println("==================================");
                for (int i = 0;i < num; i++){
                    Object dog = dogs.get(i);
                    // 39个对象在这一步都是可偏向的,偏向于t1
                    System.out.println("t2--"+i+"-----"+ClassLayout.parseInstance(dog).toPrintable());
                    // 前20个对象撤销偏向锁，前19个膨胀为轻量级锁，第20个既撤销后重偏向了
                    // 第20到第39个对象批量重偏向于t2
                    synchronized (dog){
                        System.out.println("t2--"+i+"-----"+ClassLayout.parseInstance(dog).toPrintable());
                    }
                    System.out.println("t2--"+i+"-----"+ClassLayout.parseInstance(dog).toPrintable());
                }
                LockSupport.unpark(t3);
            }
        };
        t2.start();
        t3 = new Thread("t3"){
            @Override
            public void run() {
                LockSupport.park();
                System.out.println("==================================");
                for (int i =0;i<num;i++){
                    Object dog = dogs.get(i);
                    // 因为t2线程的原因，前19个对象已经是不可偏向了
                    // 因为t2触发重偏向后，后20个对象重偏向于t2
                    System.out.println("t3--"+i+"------"+ClassLayout.parseInstance(dog).toPrintable());
                    // 前19个对象已是不可偏向，加轻量级锁，没有撤销行为。
                    // 第20个到第39个，原本可偏向于t2,现在共20个对象撤销偏向锁，升级为轻量级锁
                    // 第39个时撤销了，此时发现已经达到40次，则触发批量撤销。第39个对象也是轻量级锁。
                    synchronized (dog){
                        System.out.println("t3--"+i+"------"+ClassLayout.parseInstance(dog).toPrintable());
                    }
                    System.out.println("t3--"+i+"------"+ClassLayout.parseInstance(dog).toPrintable());
                }
                LockSupport.unpark(t4);
            }
        };
        t3.start();
       t4 = new Thread("t4"){
            @Override
            public void run() {
                LockSupport.park();
                // t3已经触发批量撤销，Dog类的新创建对象也是不可偏向状态
                System.out.println("last new------"+ClassLayout.parseInstance(new Dog()).toPrintable());
            }
        };
        t4.start();
    }

    public static void test10() {
        Dog dog = new Dog();
        // 可偏向
        System.out.println(ClassLayout.parseInstance(dog).toPrintable());
        synchronized (dog){
            // 偏向锁
            System.out.println(ClassLayout.parseInstance(dog).toPrintable());
            try {
                dog.wait(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            dog.notify();
            // 调用wait后膨胀为重量级锁
            // 调用notify后膨胀为轻量级锁
            System.out.println(ClassLayout.parseInstance(dog).toPrintable());
        }
        System.out.println(ClassLayout.parseInstance(dog).toPrintable());
    }


    static class Dog{

    }

}
