package test.study.java.mianshiti2023;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.*;

public class Test1120_2 {

    public static void main(String[] args) {

        Student.StudentBuilder builder = Student.builder();

//        builder.name("zhangsan").age("18").scoreInfo(Map.of("语文","100","数学","99")).scoreInfo(Map.of("英语","98","物理","97"));


        List<String> stringList = Arrays.asList("a", "bb", "ccc");

        stringList.stream()
                .map(s -> {
                    Map<String, String> map = new HashMap<>();
                    map.put(s, s);
                    return map;
                })
                .forEach(builder::scoreInfo);

    }

    @Builder
    @Data
    public static class Student{

        private String name;

        private String age;

        @Singular
        private List<Map<String,String>> scoreInfos;

    }

}
