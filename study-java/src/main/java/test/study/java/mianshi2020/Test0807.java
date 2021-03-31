package test.study.java.mianshi2020;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Test0807 {

    public static void main(String[] args) throws Exception{

        BigDecimal bigDecimal = new BigDecimal("234.324");
        System.out.println(bigDecimal.toString());

        Teacher teacher = new Teacher("张三",-23.33D,33.33f,BigDecimal.TEN,null,23);

        Class<? extends Teacher> aClass = teacher.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        List<String> strings = Arrays.asList("double", "float", "java.math.BigDecimal");
        for (Field declaredField : declaredFields) {
            if (strings.contains(declaredField.getType().getName())){
                String methodName = "get"+declaredField.getName().substring(0,1).toUpperCase()+ declaredField.getName().substring(1);
                Method method = aClass.getDeclaredMethod(methodName);
                System.out.println(method.invoke(teacher));
            }
        }


    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Teacher{
        private String name;

        private double money;

        private float money2;

        private BigDecimal money3;

        private Test0807 test0807;

        private int age;


    }


}
