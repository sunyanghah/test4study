package test.sy.zjzy.web;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dell on 2020/1/3.
 */
public class Test8 {

    public static void main(String[] args) {
        int j =10;
        for (int i =1 ;i<=10;i++) {
            int aa = i;
            new Thread(() -> {
                System.out.println(aa);
                System.out.println(j);
            }).start();
        }


        List<String> direction = Arrays.asList("E","W","N","S","NE","NW","SE","SW");
        for (int i =0 ;i< 10;i++){
//            System.out.println(direction.get(Ran));
        }

    }

}
