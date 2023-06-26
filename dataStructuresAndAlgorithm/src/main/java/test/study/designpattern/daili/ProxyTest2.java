package test.study.designpattern.daili;

import java.lang.reflect.Proxy;

/**
 * Created by dell on 2020/8/4.
 * @author dell
 */
public class ProxyTest2 {

    interface MyInterface{

        String method1(String str);

        void method2();

        String method3(String str);
    }

    static class MyImpl implements MyInterface{
        @Override
        public String method1(String str) {
            return str.toUpperCase();
        }

        @Override
        public void method2() {
            System.out.println("this is method2");
        }

        @Override
        public String method3(String str) {
            return str;
        }
    }

    public static void main(String[] args) {
        MyInterface myInterface = new MyImpl();
        MyInterface object = (MyInterface) Proxy.newProxyInstance(ProxyTest2.class.getClassLoader(), myInterface.getClass().getInterfaces(), (proxy, method, args2) -> {
            System.out.println("this is proxy before");
            Object returnValue;
            if (method.getName().equals("method1")){
                String args2Str = (String) args2[0];
                returnValue =  (args2Str+"--proxy").toUpperCase();
            }else {
                returnValue = method.invoke(myInterface, args2);
            }
            System.out.println("this is proxy after");
            return returnValue;
        });
        System.out.println(object.method1("abcd"));
        System.out.println("----------");
        object.method2();
        System.out.println("----------");
        System.out.println(object.method3("kkkk"));
        System.out.println("----------");
        System.out.println(Proxy.getInvocationHandler(object));
        System.out.println("----------");
        System.out.println(Proxy.getProxyClass(ProxyTest2.class.getClassLoader(), myInterface.getClass().getInterfaces()));
        System.out.println("----------");
        System.out.println(Proxy.isProxyClass(myInterface.getClass()));
        System.out.println(Proxy.isProxyClass(object.getClass()));
    }


}
