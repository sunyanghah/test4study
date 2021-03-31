package test.study.java.mianshi2020;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author sunYang
 * @Date 2020/8/21
 */
@Data
public class Test0821 {

    public static void main(String[] args) {

        Map<String, Student> data = getData();

        ArrayList<Map.Entry<String, Student>> entryArrayList = new ArrayList<>(data.entrySet());
        entryArrayList.sort((o1,o2) -> {
            Student o1Value = o1.getValue();
            Student o2Value = o2.getValue();
            BigDecimal o1Sum = new BigDecimal(o1Value.getChineseGuard()).add(new BigDecimal(o1Value.getEnglishGuard()))
                    .add(new BigDecimal(o1Value.getMathGuard()));
            BigDecimal o2Sum = new BigDecimal(o2Value.getChineseGuard()).add(new BigDecimal(o2Value.getEnglishGuard()))
                    .add(new BigDecimal(o2Value.getMathGuard()));
            return o2Sum.compareTo(o1Sum);
        });

        entryArrayList.forEach(entry -> {
            Student student = entry.getValue();
            double sum = new BigDecimal(student.getChineseGuard()).add(new BigDecimal(student.getEnglishGuard()))
                    .add(new BigDecimal(student.getMathGuard())).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            System.out.println(entry.getKey() + "----" + sum);
        });
        
    }

    private static Map<String, Student> getData(){
        Map<String, Student> map = new HashMap<>();
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
    static class Student{

        private String name;

        private Float chineseGuard;

        private Float mathGuard;

        private Float englishGuard;
    }

}
