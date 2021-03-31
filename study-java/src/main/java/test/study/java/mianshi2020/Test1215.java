package test.study.java.mianshi2020;

/**
 * @author sunYang
 * @Date 2020-12-15
 */
public class Test1215 {

    public static void main(String[] args) {

        test3();


    }

    private static void test1(){
        String idStr = "1231234334322";
        Long idLong = 1231234334322L;

        System.out.println(idStr.equals(idLong));
        System.out.println(idLong.compareTo(Long.parseLong(idStr)));
        System.out.println(idStr.equals(idLong.toString()));

        System.out.println("----------");

        String idStr2 = "12";
        Long idLong2 = 12L;

        System.out.println(idStr2.equals(idLong2));
        System.out.println(idLong2.compareTo(Long.parseLong(idStr2)));
        System.out.println(idStr2.equals(idLong2.toString()));
    }

    private static void test2(){
        String a = "asdf";
        String b = "asdf|fff|opi";
        String c = "asdf|fff|";

        System.out.println(a.split("\\|").length);
        System.out.println(b.split("\\|").length);
        System.out.println(c.split("\\|").length);

    }

    private static void test3(){
        String a = "2020-12-11";
        String b = "2020/12/12";

        a = a.replaceAll("/","-");
        b = b.replaceAll("/","-");

        System.out.println(a);
        System.out.println(b);

    }


}
