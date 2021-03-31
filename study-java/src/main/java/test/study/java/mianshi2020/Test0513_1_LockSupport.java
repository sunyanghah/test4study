package test.study.java.mianshi2020;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by dell on 2020/5/13.
 * @author dell
 */
public class Test0513_1_LockSupport {

    static Thread t1 = null,t2 = null;

    public static void main(String[] args) {

        /**
         * 如果aI,aC数组长度不相等。则这么写就有问题了。
         */
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        t1 = new Thread(()->{
            for (char c : aI) {
                System.out.print(c);
                LockSupport.unpark(t2); // unpack t2 如果t2已经pack则unpack，如果t2没有pack,则下次pack无效
                LockSupport.park();
            }
        });

        t2 = new Thread(()->{
            for (char c : aC) {
                LockSupport.park();
                System.out.print(c);
                LockSupport.unpark(t1);
            }
        });

        t1.start();
        t2.start();

    }

}
