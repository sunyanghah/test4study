package test.study.java.mianshi2020;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author sunYang
 * @Date 2020/8/21
 */
@Data
public class Test1107_3 {

    public static void main(String[] args) {

        Map<String, Student> data = getData();

        ArrayList<Map.Entry<String, Student>> entryArrayList = new ArrayList<>(data.entrySet());
        entryArrayList.sort(Comparator.comparing(Map.Entry::getValue));

        entryArrayList.forEach(entry -> {
            Student student = entry.getValue();
            double sum = new BigDecimal(student.getChineseGuard()).add(new BigDecimal(student.getEnglishGuard()))
                    .add(new BigDecimal(student.getMathGuard())).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            System.out.println(entry.getKey() + "----" + sum);
        });
        
    }

    private static Map<String, Student> getData(){
        Map<String, Student> map = new TreeMap<>();
        Student student1 = new Student("张三",9f,2.1f,3.5f);
        Student student2 = new Student("李四",1f,40.1f,5f);
        Student student3 = new Student("王五",5f,30f,9f);
        Student student4 = new Student("王六",5f,30f,9f);
        map.put("001",student1);
        map.put("002",student2);
        map.put("003",student3);
        map.put("004",student4);
        return map;
    }


    @Data
    @AllArgsConstructor
    static class Student implements Comparable<Student> {

        private String name;

        private Float chineseGuard;

        private Float mathGuard;

        private Float englishGuard;

        @Override
        public int compareTo(Student o) {
            BigDecimal o1Sum = new BigDecimal(this.getChineseGuard()).add(new BigDecimal(this.getEnglishGuard()))
                    .add(new BigDecimal(this.getMathGuard()));
            BigDecimal o2Sum = new BigDecimal(o.getChineseGuard()).add(new BigDecimal(o.getEnglishGuard()))
                    .add(new BigDecimal(o.getMathGuard()));
            return 0 - o1Sum.compareTo(o2Sum);
        }
    }

}
