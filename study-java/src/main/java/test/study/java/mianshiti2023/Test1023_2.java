package test.study.java.mianshiti2023;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用
 * 虚引用也称为“幽灵引用”或者“幻影引用”，它是最弱的一种引用关系。
 * 虚引用，顾名思义，就是形同虚设，与其他几种引用都不太一样，一个对象是否有虚引用的存在，完全不会对其生存时间构成影响，也无法通过虚引用来取得一个对象实例。
 * 虚引用需要
 * java.lang.ref.PhantomReference
 * 来实现。
 * 如果一个对象仅持有虚引用，那么它就和没有任何引用一样，在任何时候都可能被垃圾回收器回收，它不能单独使用也不能通过它访问对象，虚引用必须和引用队列（RefenenceQueue）联合使用。
 * 虚引用的主要作用是跟踪对象垃圾回收的状态。仅仅是提供了一种确保对象被 finalize 以后，做某些事情的机制。
 * PhantomReference 的 get 方法总是返回 null，因此无法访问对应的引用对象。其意义在于说明一个对象已经进入 finalization 阶段，可以被 GC 回收，用来实现比 finalization 机制更灵活的回收操作。
 * 换句话说，设置虚引用的唯一目的，就是在这个对象被回收器回收的时候收到一个系统通知或者后续添加进一步的处理。
 * @author sunyang
 * @date 2023-10-23
 * @desc
 */
public class Test1023_2 {

    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<Object>();
        PhantomReference<Object> phantomReference = new PhantomReference<Object>(o1,referenceQueue);
        System.out.println(o1);
        System.out.println(referenceQueue.poll());
        System.out.println(phantomReference.get());
        o1 = null;
        System.gc();
        Thread.sleep(3000);
        System.out.println(o1);
        System.out.println(referenceQueue.poll()); //引用队列中
        System.out.println(phantomReference.get());
    }

}
