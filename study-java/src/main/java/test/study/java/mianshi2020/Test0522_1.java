package test.study.java.mianshi2020;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 2020/5/22.
 * @author dell
 */
public class Test0522_1 {

    public static void main(String[] args) {
        Map map = new HashMap<>(10);
        map.put(null,null);
        map.put("a","b");
        map.put("c","d");
        map.put("d","b");
        map.put("e","d");

    }
}
