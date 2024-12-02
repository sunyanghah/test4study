package test.study.java.mianshiti2024;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/10/10
 */
public class Test1010 {

    public static void main(String[] args) {

        List<Test> integers = Arrays.asList(new Test("a", 1), new Test("b", 2), new Test("c", 3));
        Integer integer = integers.stream().filter(t -> t.getAge() > 5).map(Test::getAge).reduce(Integer::sum).orElse(0);
        System.out.println(integer);
    }

    @Data
    @AllArgsConstructor
    public static class Test {
        private String name;

        private Integer age;
    }
}
