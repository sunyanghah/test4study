package test.study.java.mianshiti2024;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sun yang
 * @date 2024/2/27
 */
public class Test0227 {

    public static void main(String[] args) {
        AtomicInteger nextOrderNum = new AtomicInteger(3);

        for (int i = 0; i < 5; i++) {
            System.out.println(nextOrderNum.getAndIncrement());
        }

    }

}
