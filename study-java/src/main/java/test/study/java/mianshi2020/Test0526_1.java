package test.study.java.mianshi2020;

/**
 * Created by dell on 2020/5/26.
 */
public abstract class Test0526_1 {

    public static void main(String[] args) {
        double a = 1.5;
        double b = -1.5;
        System.out.println(Math.ceil(a)); //2.0
        System.out.println(Math.floor(a)); //1.0
        System.out.println(Math.round(a)); // 2
        System.out.println("-----------------");
        System.out.println(Math.ceil(b)); // -1.0
        System.out.println(Math.floor(b)); // -2.0
        System.out.println(Math.round(b)); // -1
//        new Test0526_1();
//        new Test0526_1().new Test();

    }

    abstract class Test{

    }

}

