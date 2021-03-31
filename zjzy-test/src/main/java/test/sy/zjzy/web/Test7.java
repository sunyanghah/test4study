package test.sy.zjzy.web;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2019/9/9.
 * @author dell
 */
public class Test7 {

    public static void main(String[] args) {
//        String str = "abcdef";
//        System.out.println(str.substring(0,str.length()));
//        Integer a = new Integer(10);
//        Integer b = new Integer(8);
//        Integer c = new Integer(5);
//        System.out.println(a-b < c);

//        int a = 3;
//
//        System.out.println(a++ >= 4 && ++a >= 6);
//        System.out.println(a);
//
//        int b = 3;
//        System.out.println(b++ >=4 & ++b <=6);
//        System.out.println(b);

//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.add("d");
//        list.add("e");
//
//        int size = 2;
//        for (int i=0;true;i++){
//            int toIndex = (i+1)*size;
//            boolean breakFlag = false;
//            if (toIndex >= list.size()){
//                toIndex = list.size();
//                breakFlag = true;
//            }
//            toIndex = toIndex > list.size()?list.size():toIndex;
//            System.out.println(JSON.toJSONString(list.subList(i*size,toIndex)));
//            if (breakFlag){
//                break;
//            }
//        }
//
//        new File("").listFiles(File :: isHidden);

        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        map.put("name","张三");
        list.add(map);
        map.put("name","李四");
        System.out.println(list.get(0).get("name"));


    }

}
