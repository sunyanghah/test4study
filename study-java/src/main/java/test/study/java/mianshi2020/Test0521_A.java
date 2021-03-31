package test.study.java.mianshi2020;

/**
 * Created by dell on 2020/5/21.
 * @author dell
 */
public class Test0521_A {

    public static int num1 = 1;

    public int num2 = 1;

    static{
        System.out.println("A static block");
    }

    {
        System.out.println("A construction block");
    }

    public Test0521_A(){
        System.out.println("A construction method");
    }

    public void show(){
        System.out.println("A show "+num1+num2);
        show2();
    }

    public void show2(){
        System.out.println("A show2 "+num1+num2);
    }

}
