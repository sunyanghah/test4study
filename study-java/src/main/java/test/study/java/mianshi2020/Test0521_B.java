package test.study.java.mianshi2020;

/**
 * Created by dell on 2020/5/21.
 * @author dell
 */
public class Test0521_B extends Test0521_A {

    public static int num1 = 2;

    public int num2 = 2;

    public int num3 = 2;

    int num4 = 2;

    static{
        System.out.println("B static block");
    }

    {
        System.out.println("B construction block");
    }

    public Test0521_B(){
        System.out.println("B construction method");
    }

    @Override
    public void show2() {
        System.out.println("B show2 "+num1+num2+super.num2);
    }

    /**
     *
     A static block
     B static block
     A construction block
     A construction method
     B construction block
     B construction method
     A construction block
     A construction method
     B construction block
     B construction method
     A show 11
     B show2 221
     * @param args
     */
    public static void main(String[] args) {
        Test0521_A a1 = new Test0521_B();
        Test0521_A a2 = new Test0521_B();
        a2.show();
    }

}
