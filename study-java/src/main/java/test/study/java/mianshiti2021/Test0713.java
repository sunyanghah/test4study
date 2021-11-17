package test.study.java.mianshiti2021;

/**
 * @author sunYang
 * @Description:
 * @Title: Test0713
 * @Package test.study.java.mianshiti2021
 * @date 2021-07-1315:28
 */
public class Test0713 {


    public static void main(String[] args) {
        Son son = new Son();
        son.saySomething();
        Son.doSomething();
    }

    static class Father {
        public void saySomething(){
            System.out.println("阿巴阿巴阿巴");
        }

        public static void doSomething(){
            System.out.println("动次打次");
        }
    }

    static class Son extends Father {

        @Override
        public void saySomething() {
            System.out.println("我说个锤子");
        }

//        @Override
        public static void doSomething(){
            System.out.println("哇哈哈哈哈");
        }

    }


}