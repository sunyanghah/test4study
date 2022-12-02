package test.study.java.mianshiti2022;

import com.google.gson.Gson;

import java.util.*;

/**
 * @author sunYang
 * @date 2022/10/22 13:11
 */
public class Test1022 {

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age",18);
        map.put("addr","北京");

        Set<String> set = map.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("----------");
        T1 t1 = new T1();
        t1.setStr("111");
        String str = new Gson().toJson(t1);
        System.out.println(str);

        Map m = new Gson().fromJson(str, Map.class);
        System.out.println(m.containsKey("list"));
        System.out.println("=");
    }

    public static class T1 {
        private List<Map> list;

        private String str;

        private List<Integer> age;


        public List<Map> getList() {
            return list;
        }

        public void setList(List<Map> list) {
            this.list = list;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public List<Integer> getAge222() {
            return age;
        }

        public void setAge(List<Integer> age) {
            this.age = age;
        }
    }

}
