package test.study.java.mianshiti2021;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author sunYang
 * @Date 2021-03-24
 */
public class Test0324 {

    public static void main(String[] args) {
        Deque stack = new LinkedList();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);

        Iterator iterator = stack.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("------");

        System.out.println(stack.peek());
        System.out.println(stack.peek());

        System.out.println("------");

        System.out.println(stack.poll());
        System.out.println(stack.poll());

    }



}
