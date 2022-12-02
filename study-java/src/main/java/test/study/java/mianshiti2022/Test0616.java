package test.study.java.mianshiti2022;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sunYang
 * @date 2022/6/16 14:46
 */
public class Test0616 {

    public static <Filed> void main(String[] args) throws Exception{
        List<Student> list = new ArrayList<>();
        Student s1 = Student.builder()
                .id("1")
                .name("张三")
                .age(18)
                .build();

        Student s2 = Student.builder()
                .id("2")
                .name("李四")
                .age(18)
                .build();

        Student s3 = Student.builder()
                .id("1")
                .name("王五")
                .age(18)
                .build();

        Student s4 = Student.builder()
                .id("2")
                .name("王五")
                .age(18)
                .build();


        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

//        Student::methodName


        List<Map> result = list.stream()
                .map(Test0616::getCheckValue)
                .collect(Collectors.toList());

        //qc
        Set<Object> set = new HashSet<>();
        for (Map map : result) {
            Object value = map.get("value");
            if (set.contains(value)){
                System.out.println(map.get("fieldName")+"重复了，重复值为"+ value);
            }else {
                set.add(value);
            }

        }

    }

    public static Map<String,Object> getCheckValue(Student student) {

        Map<String,Object> map = new HashMap<>();

        try {
            Class<Student> studentClass = Student.class;
            Field[] fields = studentClass.getDeclaredFields();
            Method method = null;
            String fieldName = null;
            for (Field field : fields) {
                if (field.isAnnotationPresent(Check.class)){
                    fieldName = field.getAnnotation(Check.class).name();
                    String methodName = "get"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
                    method = studentClass.getMethod(methodName);
                    break;
                }
            }

            Object result = method.invoke(student);
            map.put("fieldName",fieldName);
            map.put("value",result);
            return map;
        }catch (Exception e){
            return null;
        }

    }




    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Student {

        private String name;


        @Check(name = "主键",unique = true)
        private String id;


        private Integer age;

    }

    @Target({ ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface Check{

        String name();
        boolean unique();



    }


}
