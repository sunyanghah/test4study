package test.study.java.mianshiti2023;

/**
 * @author sunyang
 * @date 2023-10-23
 * @desc
 */
public class Test1023_4 {

    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        System.out.println("111");
        synchronized (obj){
            obj.wait();
        }
        System.out.println("222");
    }

}
