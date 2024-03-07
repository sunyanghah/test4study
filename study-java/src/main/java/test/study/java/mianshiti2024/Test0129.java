package test.study.java.mianshiti2024;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sun yang
 * @date 2024/1/29
 */
public class Test0129 {

    public static void main(String[] args) {
        AtomicInteger orderNum = new AtomicInteger(1);
        System.out.println(orderNum.getAndIncrement());
        System.out.println(orderNum.getAndIncrement());
        System.out.println(orderNum.get());
    }

}
