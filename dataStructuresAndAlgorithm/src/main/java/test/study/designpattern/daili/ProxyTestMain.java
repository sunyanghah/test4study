package test.study.designpattern.daili;

import java.lang.reflect.Proxy;
/**
 * Created by dell on 2020/8/4.
 * @author dell
 */
//接口：MyBusinessInterface.java
interface MyBusinessInterface {
    void method1();
    void method2();
}

//实现类：MyBusinessInterfaceImpl.java
class MyBusinessInterfaceImpl implements MyBusinessInterface {
    @Override
    public void method1() {
        System.out.println("************** method1 *****************");
    }
    @Override
    public void method2() {
        System.out.println("************** method2 *****************");
    }
}

//代理类：ProxyTestMain.java
public class ProxyTestMain {
    public static void main(String[] args) {
        //得到一个真正的对象
        final MyBusinessInterface myObject = new MyBusinessInterfaceImpl();
        //生成真正对象的代理对象
        /*
        * public static Object Proxy.newProxyInstance(ClassLoader loader, 类加载器
        *                                             Class<?>[] interfaces, 真正对象的接口
        *                                             InvocationHandler h) 表示客户端如何调用代理对象
        */
        //需求：重写method1方法，不重写method2
        MyBusinessInterface proxyObject = (MyBusinessInterface) Proxy.newProxyInstance(ProxyTestMain.class.getClassLoader(),
                myObject.getClass().getInterfaces(),
                (proxy, method, args1) -> {
                    //代表客户端的调用
                    if(method.getName().equals("method1")){
                        //表示客户端掉调用到了method1
                        System.out.println("************** in proxy: method1 **************");
                        return null;
                    }else{
                        //其他方法
                        return method.invoke(myObject, args1);
                    }
                });
        //调用：代理对象
        proxyObject.method1();
        proxyObject.method2();
    }
}
