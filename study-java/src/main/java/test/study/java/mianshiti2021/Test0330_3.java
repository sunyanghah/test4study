package test.study.java.mianshiti2021;

import java.util.Comparator;

/**
 * @author sunYang
 * @Date 2021-03-30
 */
public class Test0330_3<E> {

    public Test0330_3(Comparator<E> comparator){

    }

    public static void main(String[] args) {
        Test0330_3<Integer> test0330_3 = new Test0330_3<>((o1,o2) -> {

            return 1;
        });
    }

}
