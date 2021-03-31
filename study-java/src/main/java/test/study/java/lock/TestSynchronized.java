package test.study.java.lock;

/**
 * Created by dell on 2020/1/14.
 * @author dell
 *
 * 1. get()方法中顺利进入了set()方法，说明synchronized的确是可重入锁
 * 2. thread-1先进入get方法体，这个时候thread-0、thread-2、thread-3等待进入，
 *    但当thread-1离开时，thread-2却先进入了方法体，没有按照thread-0、thread-2、thread-3的顺序进入get方法体，
 *    说明sychronized的确是非公平锁
 * 3. 而且在一个线程进入get方法体后，其他线程只能等待，无法同时进入，验证了synchronized是独占锁。
 */
public class TestSynchronized implements Runnable{

    public synchronized void get() {
        System.out.println("2 enter thread name-->" + Thread.currentThread().getName());
        System.out.println("3 get thread name-->" + Thread.currentThread().getName());
        set();
        System.out.println("5 leave run thread name-->" + Thread.currentThread().getName());
    }

    public synchronized void set() {
        System.out.println("4 set thread name-->" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("1 run thread name-->" + Thread.currentThread().getName());
        get();
    }

    public static void main(String[] args) {
        TestSynchronized test = new TestSynchronized();
        for (int i = 0; i < 10; i++) {
            new Thread(test, "thread-" + i).start();
        }

        /**
         * 1 run thread name-->thread-1
         1 run thread name-->thread-0
         1 run thread name-->thread-2
         2 enter thread name-->thread-1
         3 get thread name-->thread-1
         4 set thread name-->thread-1
         5 leave run thread name-->thread-1
         1 run thread name-->thread-3
         2 enter thread name-->thread-2
         3 get thread name-->thread-2
         4 set thread name-->thread-2
         5 leave run thread name-->thread-2
         2 enter thread name-->thread-0
         3 get thread name-->thread-0
         4 set thread name-->thread-0
         5 leave run thread name-->thread-0
         1 run thread name-->thread-4
         2 enter thread name-->thread-3
         3 get thread name-->thread-3
         4 set thread name-->thread-3
         5 leave run thread name-->thread-3
         1 run thread name-->thread-5
         2 enter thread name-->thread-4
         3 get thread name-->thread-4
         4 set thread name-->thread-4
         5 leave run thread name-->thread-4
         1 run thread name-->thread-6
         2 enter thread name-->thread-5
         1 run thread name-->thread-7
         3 get thread name-->thread-5
         4 set thread name-->thread-5
         5 leave run thread name-->thread-5
         2 enter thread name-->thread-7
         3 get thread name-->thread-7
         4 set thread name-->thread-7
         5 leave run thread name-->thread-7
         1 run thread name-->thread-9
         2 enter thread name-->thread-9
         3 get thread name-->thread-9
         4 set thread name-->thread-9
         5 leave run thread name-->thread-9
         1 run thread name-->thread-8
         2 enter thread name-->thread-6
         3 get thread name-->thread-6
         4 set thread name-->thread-6
         5 leave run thread name-->thread-6
         2 enter thread name-->thread-8
         3 get thread name-->thread-8
         4 set thread name-->thread-8
         5 leave run thread name-->thread-8

         */
    }

}
