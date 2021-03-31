package test.study.java.mianshi2020;

import java.lang.ref.WeakReference;

/**
 * Created by dell on 2020/6/21.
 */
public class Test0621_1 {

    public static void main(String[] args) {

        User u2 = new User("李四");
        User u3 = new User("王五");

        WeakTest weakTest1 = new WeakTest(new User("张三"));
        WeakTest weakTest2 = new WeakTest(u2);
        WeakTest weakTest3 = new WeakTest(u3);


        System.out.println("----"+weakTest1.get());
        System.out.println("----"+weakTest2.get());
        System.out.println("----"+weakTest3.get());

        System.gc();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // null
        System.out.println("----"+weakTest1.get());
        // 不为null User对象
        System.out.println("----"+weakTest2.get());
        // 不为null User对象
        System.out.println("----"+weakTest3.get());


    }

    static class User{

        public User(String name){
            this.name = name;
        }

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class WeakTest extends WeakReference<User>{

        public WeakTest(User referent) {
            super(referent);
        }


    }

}
