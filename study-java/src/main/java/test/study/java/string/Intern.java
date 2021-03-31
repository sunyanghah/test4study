package test.study.java.string;

/**
 * Created by dell on 2019/11/1.
 */
public class Intern {

    public static void main(String[] args) throws Exception{
        System.out.println("-----test1-------");
        test1();
        System.out.println("-----test2-------");
        test2();
        System.out.println("-----test3-------");
        test3();
        System.out.println("------test4------");
        test4();
    }

    /**
     *
     *  首先，我们要知道Java会确保一个字符串常量只有一个拷贝。
     　　因为例子中的s0和s1中的"kvill"都是字符串常量，它们在编译期就被确定了，
        所以s0==s1为true；而"kv"和"ill"也都是字符串常量，
        当一个字符串由多个字符串常量连接而成时，它自己肯定也是字符串常量，
        所以s2也同样在编译期就被解析为一个字符串常量，所以s2也是常量池中"kvill"的一个引用。
     　　所以我们得出s0==s1==s2;
     *
     *
     */
    public static void test1() {
        String s0 = "kvill";
        String s1 = "kvill";
        String s2 = "kv" + "ill";
        // true
        System.out.println( s0 == s1 );
        // true
        System.out.println( s0 == s2 );
    }


    /**
     * 例2中s0还是常量池中"kvill"的引用，s1因为无法在编译期确定，
     * 所以是运行时创建的堆中对象new String("kvill")的引用，s2因为有后半部分new String("ill")所以同s1，
     * 明白了这些也就知道为何得出此结果了.
     */
    public static void test2() {
        String s0 = "kvill";
        String s1 = new String("kvill");
        String s2 = "kv" + new String("ill");
        // false
        System.out.println( s0 == s1 );
        // false
        System.out.println( s0 == s2 );
        // false
        System.out.println( s1 == s2 );
    }

    /**
     *String的intern()方法就是扩充常量池的一个方法；
     * 当一个String实例str调用intern()方法时，Java查找常量池中是否有相同Unicode的字符串常量，
     * 如果有，则返回其的引用，如果没有，则在常量池中增加一个Unicode等于str的字符串并返回它的引用
     */
    public static void test3() {
        String s0 = "kvill";
        String s1 = new String("kvill");
        String s2 = new String("kvill");
        // false
        System.out.println( s0 == s1 );
        System.out.println( "**********" );
        s1.intern();
        // 把常量池中"kvill"的引用赋给s2
        s2 = s2.intern();
        // false 虽然执行了s1.intern(),但它的返回值没有赋给s1
        System.out.println( s0 == s1);
        // true 说明s1.intern()返回的是常量池中”kvill”的引用
        System.out.println( s0 == s1.intern() );
        // true
        System.out.println( s0 == s2 );
    }

    public static void test4(){
        // true
        System.out.println(new String("abc").intern() == "abc");
        // false
        System.out.println(new String("abc") == "abc");

        String s1 = new String("kvill");
        String s2 = s1.intern();
        // false
        System.out.println( s1 == s1.intern() );
        // kvill kvill
        System.out.println( s1 + " " + s2 );
        // true
        System.out.println( s2 == s1.intern() );
        // false
        System.out.println(s2 == s1);
    }

}
