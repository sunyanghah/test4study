package test.study.java.stream;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by dell on 2020/1/15.
 * @author dell
 */
public class TestStream1 {

    @Data
    static class Student {
        int no;
        String name;
        String sex;
        float height;

        public Student(int no, String name, String sex, float height) {
            this.no = no;
            this.name = name;
            this.sex = sex;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        Student stuA = new Student(1, "A", "M", 184);
        Student stuB = new Student(2, "B", "G", 163);
        Student stuC = new Student(3, "C", "M", 175);
        Student stuD = new Student(4, "D", "G", 158);
        Student stuE = new Student(5, "E", "M", 170);
        List<Student> list = new ArrayList<>();
        list.add(stuA);
        list.add(stuB);
        list.add(stuC);
        list.add(stuD);
        list.add(stuE);

        /**
         * 在一次聚合操作中，可以有多个Intermediate，但是有且只有一个Terminal.
         * Intermediate：map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、 skip、 parallel、 sequential、 unordered
         * Terminal：forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、iterator
         */
        System.out.println("-----------------------filter-------------------------------");
        list.stream().filter(student -> !"C".equals(student.name))
            .forEach(student -> System.out.println(JSON.toJSONString(student)));

        System.out.println("---------------------------count---------------------------");

        long count = list.stream().filter(student -> "G".equals(student.sex)).count();
        System.out.println(count);

        System.out.println("---------------------of---------------------------------");

        /**
         * of方法，其生成的Stream是有限长度的，Stream的长度为其内的元素个数
         */
        Stream.of(1,2,3,4,5).filter(num -> num > 2).forEach(System.out::println);

        System.out.println("-----------------------generate-------------------------------");
        /**
         * generator方法，返回一个无限长度的Stream,其元素由Supplier接口的提供。
         * 在Supplier是一个函数接口，只封装了一个get()方法，其用来返回任何泛型的值，
         * 该结果在不同的时间内，返回的可能相同也可能不相同，没有特殊的要求。
         *
         * 这种情形通常用于随机数、常量的 Stream，或者需要前后元素间维持着某种状态信息的 Stream
         * 把 Supplier 实例传递给 Stream.generate() 生成的 Stream，默认是串行（相对 parallel 而言）但无序的（相对 ordered 而言）。
         *
         * 一般无限长度的Stream会与filter、limit等配合使用，否则Stream会无限制的执行下去，后果可想而知.
         *
         */
        Stream<Double> generateC = Stream.generate(java.lang.Math::random).limit(4);
        generateC.forEach(System.out::println);

        System.out.println("-------------------------map-----------------------------");
        List<Integer> noList = list.stream().map(stu -> stu.getNo()).collect(Collectors.toList());

        System.out.println("------------------------collect map------------------------------");
        Map<Integer, Student> studentMap = list.stream().collect(Collectors.toMap(Student::getNo, s -> s));



    }

}
