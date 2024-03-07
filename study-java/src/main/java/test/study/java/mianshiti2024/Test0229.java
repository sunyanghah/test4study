package test.study.java.mianshiti2024;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sun yang
 * @date 2024/2/29
 */
public class Test0229 {

    public static void main(String[] args) {
        test1_1();
    }

    public static void test1(){
        String[] names = {"风天养","曹操","爆爆","曹丹","张之维","曹阿瞒","安宁"};
        Collator collator = Collator.getInstance(Locale.CHINA);
        Arrays.sort(names,collator::compare);
        Arrays.stream(names).forEach(System.out::println);
    }

    public static void test1_1(){
        String[] names = {"哔","百度","中国政府网","12","44","bb","gth","中风","重复","重量","41哈哈"};
        Collator collator = Collator.getInstance();
        Arrays.sort(names,collator::compare);
        Arrays.stream(names).forEach(System.out::println);
    }

    public static void test2(){
        String[] names = {"风天养","曹操","爆爆","曹丹","张之维","曹阿瞒","安宁"};
        List<String> nameList = Arrays.stream(names).collect(Collectors.toList());
        Collator collator = Collator.getInstance(Locale.CHINA);
        Collections.sort(nameList,collator::compare);
        nameList.forEach(System.out::println);
    }

    public static void test3(){

        Student s1 = new Student(1,"风天养");
        Student s2 = new Student(2,"曹操");
        Student s3 = new Student(3,"爆爆");
        Student s4 = new Student(4,"曹丹");
        Student s5 = new Student(5,"张之维");
        Student s6 = new Student(6,"曹阿瞒");
        Student s7 = new Student(7,"安宁");
        List<Student> studentList = Arrays.asList(s1, s2, s3, s4, s5, s6, s7);

        Collator collator = Collator.getInstance(Locale.CHINA);
        Collections.sort(studentList, (o1, o2) ->
            collator.compare(o1.getName(),o2.getName())
        );

        studentList.forEach(student -> System.out.println(JSON.toJSONString(student)));
    }

    @Data
    @AllArgsConstructor
    public static class Student{

        private Integer id;

        private String name;

    }


}
