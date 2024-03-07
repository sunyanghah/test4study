package test.study.java.mianshiti2023;

/**
 * @author sunyang
 * @date 2023-10-22
 * @desc
 */
public class Test1022 {

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        o.wait(); //java.lang.IllegalMonitorStateException
    }

}
