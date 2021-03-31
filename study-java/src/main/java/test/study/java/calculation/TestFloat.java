package test.study.java.calculation;

/**
 * Created by dell on 2020/1/13.
 */
public class TestFloat {


    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    public static void test1(){
        float total = 200.8f;
        float use = 170.5f;

        System.out.println(total-use);
    }

    public static void test2(){
        double total = 200.8d;
        double use = 170.5d;
        System.out.println(total-use);
    }

    public static void test3(){
        float total = 10.2f;
        float use = 5.1f;
        System.out.println(total-use);
    }

    public static void test4(){
        float total = 2.1f;
        float use = 1.8f;
        System.out.println(total-use);
    }

    public static void test5(){
        int total = 2;
        int use = 1;
        double d = total - use;
        System.out.println(d);
    }

}
