//package test.study.news.web;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import test.study.common.platform.IdGenerator;
//
//import java.util.List;
//
///**
// * Created by dell on 2019/8/27.
// */
//@RestController
//public class MyTest6 {
//
//    @Autowired
//    private IdGenerator idGenerator;
//
//
//    @GetMapping("/test6/test")
//    public void test() throws Exception{
//        System.out.println(idGenerator.next());
//    }
//
//    public static void main(String[] args) throws Exception{
//        System.out.println(-1L<<12L);
//        System.out.println(Long.toBinaryString(-1L<<12L));
//        System.out.println(-1L ^ (-1L << 12L));
//        System.out.println(Long.toBinaryString(-1L ^ (-1L << 12L)));
//        System.out.println((-1L ^ (-1L << 12L)) & (0+1) );
//        System.out.println("************");
//        test1();
//    }
//
//    private static void test2() throws Exception{
//
//    }
//
//
//    private static void test1() throws Exception{
//        long a1 = 2524608973L-2524608974L;
////        System.out.println(Long.toBinaryString(2524608974L-1566886994L));
//        System.out.println(a1);
//        System.out.println(Long.toBinaryString(a1));
//
//        System.out.println("a---------------------");
//        long a = a1 << 34;
//        System.out.println(a);
//        System.out.println(Long.toBinaryString(a));
//
//        System.out.println("b---------------------");
//        long b = 16L << 17L;
//        System.out.println(b);
//        System.out.println(Long.toBinaryString(b));
//
//        System.out.println("c---------------------");
//        long c = 16L << 12L;
//        System.out.println(c);
//        System.out.println(Long.toBinaryString(c));
//
//        long d = 0L;
//
//        long result = 7854535285879668736L;
//        System.out.println("------------------");
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(d);
//        System.out.println(a|b|c|d);
//    }
//
//
//
//    public static List<String> getKeys(Integer num) throws Exception{
//        return null;
//    }
//
//    public static String getKey() throws Exception{
//        return String.valueOf(System.currentTimeMillis());
//    }
//
//}
