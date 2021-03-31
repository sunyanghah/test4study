package test.study.java.mianshi2020;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.ValueFilter;
import lombok.Data;

import java.math.BigDecimal;
import java.util.*;

public class Test0806 {

    @Data
    static class Teacher{

        public Teacher(){}
        public Teacher(String name,int age,Integer number,Double money){
            this.name = name;
            this.age = age;
            this.number = number;
            this.money = money;
        }

        private String name;

        private int age;

        private Integer number;

        private Double money;

        private Teacher teacher;
    }

    public static void main(String[] args) {

        Map<String,Object> map1 = new HashMap<>();

        List<Teacher> list = new ArrayList<>();
        Teacher t = new Teacher("张三", 1, 2, 3.3D);
        Teacher t2 = new Teacher("张三里面", 111, 222, 333.333D);
        t.setTeacher(t2);
        list.add(t);
        list.add(new Teacher("六六",2,4,0.3232111232333D));
        list.add(new Teacher("王五",3,6,12345678.3D));
        list.add(new Teacher("李四",4,8,3.3D));

        List<Double> list2 = new ArrayList<>();
        list2.add(123132123.23D);
        list2.add(0.3242342423D);
        list2.add(-1231.23D);
        list2.add(44545433323.23D);
        list2.add(null);

        Map<String,Object> map2 = new HashMap<>();
        map2.put("name","张三");
        map2.put("age",2344);
        map2.put("money",234234234.23D);
        map2.put("wrong",0.23234324233443D);
        map2.put("list",list);
        map2.put("list2",list2);
        map2.put(null,null);

        System.out.println(JSON.toJSONString(map2));

        map2 = handleBigDecimal(map2);

        System.out.println(JSON.toJSONString(map2));
    }

//    public static void handleBigDecimal(Object object){
//
//        String objectJson = JSON.toJSONString(object);
//        T object1 = (T) JSON.parseObject(objectJson, t.getClass());
//        handleBigDecimalObject(object1);
//        return object1;
//    }

    public static <T> T handleBigDecimal(T t){

        String objectJson = JSON.toJSONString(t,(ValueFilter)(object, name, value)->{
//            System.out.println("object---"+object);
//            System.out.println("name---"+name);
//            System.out.println("value---"+value);
            if (value != null && value.getClass().getName().startsWith("test.")){
                System.out.println("-----------------"+value);
                return null;
            }
            return value;
        });
        T object1 = (T) JSON.parseObject(objectJson, t.getClass());
        handleBigDecimalObject(object1);
        return object1;
    }


    private static void handleBigDecimalObject(Object object){
        if (object instanceof Map){
            Map<String,Object> map = (Map<String, Object>) object;
            for (Map.Entry<String, Object> en : map.entrySet()) {
                Object value = en.getValue();
                if (value instanceof Double || value instanceof Float || value instanceof BigDecimal){
                    String s = new BigDecimal(String.valueOf(value)).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
                    if (new BigDecimal(String.valueOf(value)).compareTo(BigDecimal.ZERO) == -1){
                        System.out.println("--------+++---------==="+s);
                    }
                    en.setValue(s);
                }else {
                    handleBigDecimalObject(value);
                }
            }
        }else if (object instanceof Collection){
            Collection collection = (Collection) object;
            Object[] objects = collection.toArray();
            for (int i=0;i<objects.length;i++){
                Object object1 = objects[i];
                if (object1 instanceof Double || object1 instanceof Float || object1 instanceof BigDecimal){
                    String s = new BigDecimal(String.valueOf(object1)).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
                    if (new BigDecimal(String.valueOf(object1)).compareTo(BigDecimal.ZERO) == -1){
                        System.out.println("--------+++---------=="+s);
                    }
                    objects[i] = s;
                }else{
                    handleBigDecimalObject(object1);
                }
            }
        }
    }



}
