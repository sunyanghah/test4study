package test.study.java.mianshiti2023;

import java.lang.ref.WeakReference;

/**
 * 弱引用
 * 弱引用也是用来描述非必需对象的，但是它的强度比软引用更弱一些，被弱引用关联的对象只能生存到下一次垃圾收集发生之前。当垃圾收集器工作时，无论当前内存是否足够，都会回收掉只被弱引用关联的对象。
 * 弱引用需要用
 * java.lang.ref.WeakReference
 * 类来实现，它比软引用的生存期更短。
 * 对于只有弱引用的对象来说，只要垃圾回收机制一运行，不管 JVM 的内存空间是否足够，都会回收该对象占用的内存。
 * @author sunyang
 * @date 2023-10-23
 * @desc
 */
public class Test1023_1 {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> w1 = new WeakReference<Object>(o1);
        System.out.println(o1);
        System.out.println(w1.get());
        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(w1.get());
    }
}
