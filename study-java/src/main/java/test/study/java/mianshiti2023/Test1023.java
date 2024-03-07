package test.study.java.mianshiti2023;

import java.lang.ref.SoftReference;

/**
 * 软引用
 * 软引用是一种相对强引用弱化了一些的引用，需要用
 * java.lang.ref.SoftReference
 * 类来实现，可以让对象豁免一些垃圾收集。
 * 软引用用来描述一些还有用，但并非必需的对象。对于软引用关联着的对象，在系统将要发生内存溢出异常之前，将会把这些对象列进回收范围之中并进行第二次回收。如果这次回收还是没有足够的内存，才会抛出内存溢出异常。
 * 对于只有软引用的对象来说：当系统内存充足时它不会被回收，当系统内存不足时它才会被回收。
 * @author sunyang
 * @date 2023-10-23
 * @desc
 */
public class Test1023 {
    public static void main(String[] args) {
        softRefMemoryEnough();
        System.out.println("------内存不够用的情况------");
        softRefMemoryNotEnough();
    }
    private static void softRefMemoryEnough() {
        Object o1 = new Object();
        SoftReference<Object> s1 = new SoftReference<Object>(o1);
        System.out.println(o1);
        System.out.println(s1.get());
        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(s1.get());
    }
    /**
     * JVM配置`-Xms5m -Xmx5m` ，然后故意new一个一个大对象，使内存不足产生 OOM，看软引用回收情况
     */
    private static void softRefMemoryNotEnough() {
        Object o1 = new Object();
        SoftReference<Object> s1 = new SoftReference<Object>(o1);
        System.out.println(o1);
        System.out.println(s1.get());
        o1 = null;
        byte[] bytes = new byte[10 * 1024 * 1024];
        System.out.println(o1);
        System.out.println(s1.get());
    }
}
