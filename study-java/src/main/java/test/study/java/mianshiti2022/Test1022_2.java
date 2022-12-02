package test.study.java.mianshiti2022;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunYang
 * @date 2022/10/22 14:30
 */
public class Test1022_2 {
    public static void main(String[] args) {
        Test1022.T1 t1 = new Test1022.T1();
        t1.setStr("33");
        Test1022.T1 t2 = new Test1022.T1();
        t2.setStr("44");

        List<Test1022.T1> list =new ArrayList<>();
        list.add(t1);
        list.add(t2);

        System.out.println(new Gson().toJson(list));

    }
}
