package test.study.java.mianshiti2021;

/**
 * @author sunYang
 * @Date 2021-03-18
 */
public class Test0318 {

    public static void main(String[] args) {
        System.out.println("----------");
        test1();
        System.out.println("----------");
        test2();
        System.out.println("----------");
        test3();
    }

    public static void test1(){
        try{
            System.out.println("try");
        }catch (Exception e){
            System.out.println("catch");
        }finally {
            System.out.println("finally");
        }
    }

    public static void test2(){
        try{
            System.out.println("try");
        }finally {
            System.out.println("finally");
        }
    }

    public static void test3(){
        try {
            System.out.println("try");
        }catch (Exception e){
            System.out.println("catch");
        }
    }

//    public static void test4(){
//        catch(Exception e){
//            System.out.println("catch");
//        }finally{
//            System.out.println("finally");
//        }
//    }

}
