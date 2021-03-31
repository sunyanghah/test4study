package test.study.java.mianshi2020;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 2020/5/21.
 */
public class Test0521_1 {

    public static void main(String[] args) {
        HashMap map = new HashMap<>();
        System.out.println(map.size());
        HashMap map2 = new HashMap<>(1000);
        System.out.println(map2.size());
        System.out.println(map2);

        Test0521_B test0521_b = new Test0521_B();

    }

}
