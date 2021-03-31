package test.study.java.mianshi2020;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by dell on 2020/5/28.
 */
public class Test0528_1 {

    public static void main(String[] args) {
        B b = new Test0528_1().new B();
        b.show();

        HashMap hashMap = new HashMap();
        hashMap.put(1,"");
        Iterator iterator = hashMap.keySet().iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println("sdf");
        }
    }

    class A{

        public void show(){
            System.out.println("this is A show");
        }

    }

    class B extends A{
        @Override
        public void show() {
            System.out.println("this is B show");
        }
    }
}

