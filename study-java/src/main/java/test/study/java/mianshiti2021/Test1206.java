package test.study.java.mianshiti2021;

import java.util.LinkedList;

/**
 * @author sunYang
 * @date 2021/12/6 17:14
 */
public class Test1206 {

    public static void main(String[] args) {

        test1();

    }

    private static void test() throws InterruptedException {

        Integer maxNum = 50000;
        LinkedList<String> linkedList = new LinkedList<>();

    }


    private static void test1(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");

        String poll;
        while((poll = linkedList.poll()) != null){
            System.out.println(poll);
        }
        System.out.println(linkedList.size());
    }

    private static void test2(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");

        String pop;
        while((pop = linkedList.pop()) != null){
            System.out.println(pop);
        }
        System.out.println(linkedList.size());
    }

}
