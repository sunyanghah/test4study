package test.study.java.mianshiti2021;

/**
 * @author sunYang
 * @Description:
 * @Title: Test0608
 * @Package test.study.java.mianshiti2021
 * @date 2021-06-0816:30
 */
public class Test0608 {

    public static void main(String[] args) {
        Long a = 100L;

        Long b = 100L;
        Long c = 222L;
        String d = "100";
        Long e = null;

        System.out.println(a.compareTo(b) == 0);
        System.out.println(a.compareTo(c) == 0);
//        System.out.println(a.compareTo(e) == 0);

        System.out.println("---------");

        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a.equals(d));
        System.out.println(a.equals(e));

        System.out.println("---------");
        System.out.println(e instanceof Long);

    }

}