package test.study.java.mianshiti2021;

/**
 * @author sunYang
 * @Date 2021-04-27
 */
public class Test0427_1 {

    public static void main(String[] args) {

        Test0427_2 test0427_2 = new Test0427_2();
        test0427_2.setName("张三");
        test0427_2.setAge(12);

        System.out.println(test0427_2.getName()+"--"+test0427_2.getAge());


        Test0427_2 t2 = Test0427_2.builder().name("李四").age(22).build();
        System.out.println(t2.getName()+"--"+t2.getAge());


    }

}
