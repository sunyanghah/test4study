package test.study.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by dell on 2019/11/19.
 */
public class ListRemove {

    public static void main(String[] args) throws Exception {
        test2();
    }

    public static void test1() throws Exception{
        List<String> list = Arrays.asList("a","b","c","c","e");
        for (int i = 0;i<list.size();i++){
            if ("c".equals(list.get(i))) {
                // UnsupportedOperationException
                // arrays.aslist 得到的对象并不是常规的arrayList，而是java util Arrays类的一个内部类
                // 该remove方法是java.util.AbstractList抽象类中提供的，直接抛出异常。
                list.remove(i);
            }
        }

        list.forEach(System.out::println);
    }
    public static void test2() throws Exception{
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("c");
        list.add("e");
        for (int i = 0;i<list.size();i++){
            if ("c".equals(list.get(i))) {
                list.remove(i);
            }
        }
        // a b c e 所以还是有问题
        // 第一个c list.remove会让list.size变小一位成为4，原先的索引位置3上的c和4上的e变为索引2和3.而遍历索引i还在继续成长为3。
        // 所以第二个c 逃过了遍历。
        list.forEach(System.out::println);
    }
    public static void test3() throws Exception{
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("c");
        list.add("e");
        // ConcurrentModificationException
        for (String s : list) {
            if ("c".equals(s)) {
                list.remove(s);
            }
        }
        list.forEach(System.out::println);
    }

    public static void test4() throws Exception{
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("c");
        list.add("e");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            if ("c".equals(iterator.next())){
                iterator.remove();
            }
        }
        // a b e 没毛病
        list.forEach(System.out::println);
    }
}
