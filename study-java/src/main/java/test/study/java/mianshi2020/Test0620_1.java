package test.study.java.mianshi2020;

/**
 * Created by dell on 2020/6/20.
 * @author dell
 */
public class Test0620_1 {

    private int num1;

    public int num2;

    private static int num3;

    public static int num4;

    private void test1(){
        System.out.println("test1");
    }

    private void test_out_1(){
        System.out.println("test_out_1");
    }

    public void test2(){
        System.out.println("test2");
    }

    public void test_out_2(){
        System.out.println("test_out_2");
    }

    private static void test3(){
        System.out.println("test3");
    }

    private static void test_out_3(){
        System.out.println("test_out_3");
    }


    public static void test4(){
        System.out.println("test4");
    }

    public static void test_out_4(){
        System.out.println("test_out_4");
    }


    public static void main(String[] args) {
        Test0620_1 test0620_1 = new Test0620_1();
        TestClass2 testClass2 = test0620_1.new TestClass2();
        testClass2.test1();
        System.out.println(test0620_1.num1+"---"+test0620_1.num2+"---"+Test0620_1.num3+"---"+Test0620_1.num4);
    }



    static class TestClass1{

        /**
         * 静态内部类不需要先实例化外部类，所以只能访问外部类中静态成员
         */
        public void test1(){
            test3();
            test_out_3();
            test4();
            test_out_4();
            num3 = 13;
            num4 = 14;
        }

        public void test3(){
            test3();
            test_out_3();
            test4();
            test_out_4();
        }

    }


    class TestClass2{

        public void test1(){
            num1 = 21;
            num2 = 22;
            num3 = 23;
            num4 = 24;
            test1();
            test_out_1();
        }

    }




}
