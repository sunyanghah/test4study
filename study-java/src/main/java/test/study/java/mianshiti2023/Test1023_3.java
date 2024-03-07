package test.study.java.mianshiti2023;

/**
 * @author sunyang
 * @date 2023-10-23
 * @desc
 */
public class Test1023_3 {

    public static void main(String[] args) {
        MyObj obj = new MyObj();
        obj = null;
        System.out.println("回收，启动！");
        System.gc();
    }

    static class MyObj {

        @Override
        protected void finalize() throws Throwable {
            System.out.println("释放了释放了");
        }
    }

}
