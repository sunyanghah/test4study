package test.study.java.mianshi2020;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.*;

/**
 * Created by dell on 2020/5/8.
 */
public class Test0508 {

    public static void main(String[] args) throws Exception{
       test15();

    }

    public static void test(){
        int a =1,b=2;
        String c = "=";
        // 3=12
        System.out.println(a+b+c+a+b);
    }

    public static void test1(){
//        float f = 3.4;
    }

    public static void test2(){
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;

        System.out.println(f1 == f2); // true
        System.out.println(f3 == f4); // false
        //简单的说，如果整型字面量的值在-128到127之间，那么不会new新的Integer对象，而是直接使用IntegerCache的Integer对象，所以上面的面试题中f1==f2的结果是true，而f3==f4的结果是false。
        //IntegerCache 的 high (即127) 可以通过vm options 设置 -Djava.lang.Integer.IntegerCache.high=200 ，但是不可小于127，否则取127
    }

    public static void test3(){
        //四舍五入的算法是在参数上加0.5然后进行下取整
        System.out.println(Math.round(11.5)); //12
        System.out.println(Math.round(-11.5)); //-11
        System.out.println(Math.round(-11.6)); //-12  --- -11.1的向下取整是-12
        System.out.println(Math.round(11.4)); //11
        System.out.println(Math.round(-11.4)); //-11
    }

    public static void test4(){
        switch ("s"){}
        switch (12){}
        //switch (12L){} //Found: 'long', required:char, byte, short, int, Character, Byte, Short, Integer, String, or an enum
//        switch (true){} error
    }

    /**
     * 对象传递
     */
    public static void test5(){
        Student student = new Test0508().new Student();
        student.setName("张三");
        student.setAge(18);
        test5_1(student);
        System.out.println(JSON.toJSONString(student)); //李四
        test5_2(student);
        System.out.println(JSON.toJSONString(student)); //李四
    }

    private static void test5_1(Student student){
        student.setName("李四");
    }

    /**
     * 方法中修改引用的指向不影响调用者
     */
    private static void test5_2(Student student){
        student = new Test0508().new Student();
        student.setName("王五");
    }

    /**
     * 抽象类与接口
     */
    public static void test6(){
        Animal animal = new Test0508().new Cat("orange cat");
        animal.eat(); // eat
        animal.sleep(); // cat sleep

        People people = new Test0508().new Male();
        people.eat(); // male eat
        people.sleep();// sleep
    }

    @Data
    class Student{
        private String name;

        private Integer age;
    }

    abstract class Animal{
        Animal(String kind){
            System.out.println(kind);
        }
        public void eat(){
            System.out.println("eat");
        }
        public abstract void sleep();
    }

    class Cat extends Animal{

        Cat(String kind) {
            super(kind);
        }

        @Override
        public void sleep() {
            System.out.println("cat sleep");
        }
    }

    interface People{
        void eat();
        default void sleep(){
            System.out.println("sleep");
        }
    }

    class Male implements People{

        @Override
        public void eat() {
            System.out.println("male eat");
        }
    }


    public static void test7(){
        //创建对象时构造器的调用顺序是：先初始化静态成员，然后调用父类构造器，再初始化非静态成员，最后调用自身构造器。
        A ab = new B(); //1a2b
        // 类的静态成员只初始化一次
        ab = new B(); //2b
    }


    static class A {

        static {
            System.out.print("1");
        }

        public A() {
            System.out.print("2");
        }
    }

    static class B extends A{

        static {
            System.out.print("a");
        }

        public B() {
            System.out.print("b");
        }
    }

    /**
     * String 转 int 的方式
     */
    public static void test8(){
        String str = "1234";
        System.out.println(Integer.parseInt(str)); // 返回的是int类型
        System.out.println(Integer.valueOf(str)); // 底层也是调用的parseInt，不过返回的是Integer类型，并且检查了IntegerCache
    }

    /**
     * 翻转字符串
     */
    public static void test9(){
        String str = "abcd";
        System.out.println(reverse(str));
    }

    private static String reverse(String originStr) {
        if(originStr == null || originStr.length() <= 1) {
            return originStr;
        }
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }

    public static void test10(){
        try{
            throw new Test0508().new ExampleB(); // example b example a
        }catch (ExampleA a){
            System.out.println("example a");
        }catch (Exception e){
            System.out.println("exception");
        }
    }

    class ExampleA extends Exception{

    }
    class ExampleB extends ExampleA{
        ExampleB(){
            System.out.println("example b");
        }
    }

    public static void test11(){
        try {
            try {
                throw new Test0508().new Sneeze();
            }
            catch ( Annoyance a ) {
                System.out.println("Caught Annoyance"); // 1
                throw a;
            }
        }
        catch ( Sneeze s ) {
            System.out.println("Caught Sneeze"); // 2
            return ;
        }
        finally {
            System.out.println("Hello World!"); // 3
        }
    }

    public static void test12() throws Exception{
        try {
            throw new Test0508().new Annoyance(); // 打印hello world，然后打印异常
        } catch (Sneeze s) { // 不打印，子类异常无法捕获父类异常
            System.out.println("Caught Sneeze");
            return;
        }finally {
            // 打印
            System.out.println("Hello World!");
        }
    }

    class Annoyance extends Exception {}
    class Sneeze extends Annoyance {}


    public static void test13(){
        // 写一个单例模式的类
        Singleton singleton = Singleton.getInstance();
        Singleton2 singleton2 = Singleton2.getInstance();
    }
    // 双重检查
    static class Singleton{
        private Singleton(){}
        private static volatile Singleton instance = null;
        public static Singleton getInstance(){
            if (instance == null){
                synchronized (Singleton.class){
                    if (instance == null){
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }
    // 静态内部类
    static class Singleton2 {

        private Singleton2() {}

        private static class SingletonInstance {
            private static final Singleton2 INSTANCE = new Singleton2();
        }

        public static Singleton2 getInstance() {
            return SingletonInstance.INSTANCE;
        }
    }

    /**
     * 冒泡
     */
    public static void test14(){
        int[] arr = {6,3,5,1,2};
        for (int i =0;i<arr.length-1;i++){
            for (int j =0;j<arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i);
        }
    }

    public static void test14_2(){
        int [] arr = {6,3,5,1,2};
        for (int i=0;i<arr.length;i++){
            for (int j = i;j<arr.length-1;j++){
                if (arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i);
        }
    }

    /**
     * 二分查找法
     */
    public static void test15(){
        int[] arr = {1,2,3,5,5,6};
        int key = 5;
        System.out.println(indexedBinarySearch(arr,key));
    }
    private static int indexedBinarySearch(int[] arr,int key){
        int low = 0;
        int high = arr.length-1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];

            if (midVal < key){
                low = mid + 1;
            }else if (midVal > key){
                high = mid - 1;
            }else{
                return mid; // key found
            }
        }
        return -1;  // key not found
    }

    public static void test16(){
        List v = new ArrayList<>();
        for (;true;) {
            Object o = new Object();
            v.add(o);
        }
    }

}
