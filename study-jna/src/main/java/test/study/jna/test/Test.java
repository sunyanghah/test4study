package test.study.jna.test;

/**
 * @author sun yang
 * @date 2024/9/4
 */
public class Test {

    public static void main(String[] args) {
        TestLibrary instance = TestLibrary.INSTANCE;
        instance.SayHello2();
        instance.SayHello("sun yang");

        System.out.println("-------");

    }

}
