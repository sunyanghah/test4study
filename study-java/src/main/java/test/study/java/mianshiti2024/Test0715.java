package test.study.java.mianshiti2024;

/**
 * @author sun yang
 * @date 2024/7/15
 */
public class Test0715 {

    public static void main(String[] args) {

    }

    public static abstract class AbstractTest{
        public abstract void test();
    }

    public static class Test1 extends AbstractTest{

        @Override
        public void test() {
            System.out.println("test1");
        }
    }

    public static class Test2 extends AbstractTest{

        @Override
        public void test() {
            System.out.println("test2");
        }
    }

    public static class Test3 extends AbstractTest{

        @Override
        public void test() {
            System.out.println("test3");
        }
    }

}
