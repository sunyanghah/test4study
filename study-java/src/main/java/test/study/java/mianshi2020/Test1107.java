package test.study.java.mianshi2020;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author sunYang
 * @Date 2020/8/21
 */
@Data
public class Test1107 {

    public static void main(String[] args) {

        Map<Student,String> data = getData();

        data.entrySet().forEach(entry -> {
            Student student = entry.getKey();
            double sum = new BigDecimal(student.getChineseGuard()).add(new BigDecimal(student.getEnglishGuard()))
                    .add(new BigDecimal(student.getMathGuard())).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            System.out.println(entry.getValue()+"===="+sum);
        });
        
    }

    private static Map<Student,String> getData(){
        Map<Student,String> map = new TreeMap<>();
        Student student1 = new Student("张三",9f,2.1f,3.5f);
        Student student2 = new Student("李四",1f,40.1f,5f);
        Student student3 = new Student("王五",5f,30f,9f);
        Student student4 = new Student("王六",5f,30f,9f);
        map.put(student1,"001");
        map.put(student2,"002");
        map.put(student3,"003");
        map.put(student4,"004");

        return map;
    }


    @Data
    @AllArgsConstructor
    static class Student implements Comparable<Student>{

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
            int compare = o1Sum.compareTo(o2Sum);
            return compare == 0 ? -1: 0-compare;
        }
    }

}
