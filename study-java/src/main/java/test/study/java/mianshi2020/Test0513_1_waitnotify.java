package test.study.java.mianshi2020;

/**
 * Created by dell on 2020/5/13.
 * @author dell
 */
public class Test0513_1_waitnotify {

    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();
        /**
         * 对象的内存结构:
         * 对象头：比如hash码，对象所属的年代，对象锁，锁状态标识，偏向锁id，偏向时间，数组长度等。
         * 对象实际数据：既创建对象时，对象中成员变量，方法等。
         *
         * 对象是怎样存储的？
         * 对象的实例在堆中，对象的元数据存在方法区(元空间区)，对象的引用在栈空间
         */
        Object object = new Object();


        new Thread(()->{
            synchronized (object) {
                for (char c : aI) {
                    System.out.print(c);
                    try {
                        object.notify();
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                object.notify();
            }
        }).start();



        new Thread(()->{
            synchronized (object) {
                for (char c : aC) {
                    System.out.print(c);
                    try {
                        object.notify();
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                object.notify();
            }
        }).start();

    }

}
