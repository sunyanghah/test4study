package test.study.java.mianshiti2022;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunYang
 * @date 2022/7/13 14:18
 */
public class Test0713 {

    public static void main(String[] args) {

        Student s1 = Student.builder()
                .name("张三")
                .age(18)
                .no("1")
                .build();
        Student s2 = Student.builder()
                .name("李四")
                .age(18)
                .no("2")
                .build();
        Student s3 = Student.builder()
                .name("张三")
                .age(18)
                .no("3")
                .build();

        List<Student> studentList = Arrays.asList(s1,s2,s3);

        Student student = studentList.stream().filter(s -> "张三".equals(s.getName()) && 19 == s.getAge())
                .findFirst().orElse(null);

        System.out.println(student.getNo());

    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Student {

        private String name;

        private Integer age;

        private String no;
    }

}
