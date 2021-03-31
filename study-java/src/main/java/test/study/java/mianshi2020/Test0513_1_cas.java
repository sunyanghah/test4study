package test.study.java.mianshi2020;

/**
 * Created by dell on 2020/5/13.
 * @author dell
 */
public class Test0513_1_cas {

    enum ReadyToRun{
        T1,
        T2
    }

    /**
     * 要用volatile修饰，不然可能会造成while循环里取不到改变之后的值
     * 造成while一直死循环的问题
     */
    static volatile ReadyToRun r = ReadyToRun.T1;

    public static void main(String[] args) {

        /**
         * 如果aI,aC数组长度不相等。则这么写就有问题了。
         */
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(()->{
            for (char c : aI) {
                while (!r.equals(ReadyToRun.T1)){}
                System.out.print(c);
                r = ReadyToRun.T2;
            }
        }).start();

        new Thread(()->{
            for (char c : aC) {
                while (!r.equals(ReadyToRun.T2)){}
                System.out.print(c);
                r = ReadyToRun.T1;
            }
        }).start();

    }

}
