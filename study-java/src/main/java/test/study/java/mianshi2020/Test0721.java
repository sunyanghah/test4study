package test.study.java.mianshi2020;

/**
 * Created by dell on 2020/7/21.
 * @author dell
 */
public class Test0721 {

    public static void main(String[] args) {
        Integer num0 = 100;
        Integer num1 = 100;
        Integer num2 = new Integer(100);
        Integer num3 = new Integer(100);

        System.out.println(num0 == num1);
        System.out.println(num1 == num2);
        System.out.println(num1.equals(num2));
        System.out.println(num2 == num3);
        System.out.println(num1.compareTo(num2));

        System.out.println("------------");

        Integer num4 = 3000;
        Integer num5 = 3000;
        Integer num6 = new Integer(3000);
        Integer num7 = new Integer(3000);
        int num8 = 3000;

        System.out.println(num4 == num5);
        System.out.println(num5 == num6);
        System.out.println(num5.equals(num6));
        System.out.println(num6 == num7);
        System.out.println(num5.compareTo(num6));
        System.out.println(num5 == num8);
        System.out.println(num7 == num8);

    }

}
