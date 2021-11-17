package test.study.java.mianshiti2021;

/**
 * @author sunYang
 * @date 2021/11/5 15:55
 */
public class Test1105_2 {

    public static void main(String[] args) {
        t1();
    }

    private static void t1(){
        String str = "a";
        t2();
        System.out.println(str);
    }

    private static void t2(){
        String str = "b";
        t3();
        System.out.println(str);
    }

    private static void t3(){
        String str = "c";
        t4();
        System.out.println(str);
    }

    private static void t4(){
        String str = "/n";
        if (str.equals("/n")){
            return;
        }
    }

}
