package test.study.java.mianshiti2024;

/**
 * @author sun yang
 * @date 2024/1/29
 */
public class Test0129_2 {

    public static void main(String[] args) {
        System.out.println(test("1"));
    }

    public static String test(String str){
        System.out.println("this is start");
        try{

            System.out.println("this is try111");

            if ("1".equals(str)) {
                return "111";
            }

            System.out.println("this is try222");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("this is finally");
        }
        System.out.println("this is end");
        return null;
    }

}
