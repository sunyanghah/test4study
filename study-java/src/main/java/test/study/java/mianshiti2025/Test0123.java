package test.study.java.mianshiti2025;

import lombok.Data;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 判断字段类型
 * @author sun yang
 * @date 2025/1/23
 */
public class Test0123<T> {

    public static void main(String[] args) {
        test(new Test());
    }

    public static void test(TestFather testFather){
        Class<?> testClass = testFather.getClass();
        List<Field> declaredFields = getAllFields(testClass);
        for (Field declaredField : declaredFields) {
            if (declaredField.getType().equals(String.class)) {
                if (declaredField.isAnnotationPresent(Text.class)){
                    System.out.println(declaredField.getName()+"是Text类型");
                }else{
                    System.out.println(declaredField.getName()+"是String类型");
                }
            }else if (declaredField.getType().equals(Integer.class) || declaredField.getType().equals(int.class)){
                System.out.println(declaredField.getName()+"是Integer类型");
            }else if (declaredField.getType().equals(Float.class)){
                System.out.println(declaredField.getName()+"是Float类型");
            }
        }
    }

    /**
     * 获取类的所有字段，包括继承父祖级的
     * @param clazz
     * @return
     */
    public static List<Field> getAllFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        // 遍历类及其父类
        while (clazz != null) {
            // 获取当前类的所有字段（包括 private 和 protected）
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : declaredFields) {
                fields.add(field);
            }
            // 获取父类
            clazz = clazz.getSuperclass();
        }
        return fields;
    }

    @Data
    public static class TestFather{
        private Integer pId;

        private int age;
    }

    @Data
    public static class Test extends TestFather{
        private Integer id;

        private String name;

        private Float price;

        @Text
        private String address;
    }

    @Target({ ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface Text {
    }

}
