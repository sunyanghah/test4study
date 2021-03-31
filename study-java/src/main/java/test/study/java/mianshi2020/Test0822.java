package test.study.java.mianshi2020;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author sunYang
 * @Date 2020/8/22
 */
public class Test0822 {

    public static void main(String[] args) {

        Map<String, Student> data = getData();
        int minEntryIndex = -1;
        Map.Entry<String,Student>[] entryArr = new Map.Entry[data.size()];
        for (Map.Entry<String, Student> entry : data.entrySet()) {
            Student student = entry.getValue();
            BigDecimal guardSum = new BigDecimal(student.getChineseGuard()).add(new BigDecimal(student.getEnglishGuard()))
                    .add(new BigDecimal(student.getMathGuard()));

            int i = minEntryIndex;

            if (minEntryIndex == -1){
                entryArr[0] = entry;
            }else {
                Map.Entry<String, Student> lastEntry = entryArr[minEntryIndex];
                Student lastStudent = lastEntry.getValue();
                BigDecimal sortedSum = new BigDecimal(lastStudent.getChineseGuard())
                        .add(new BigDecimal(lastStudent.getEnglishGuard()))
                        .add(new BigDecimal(lastStudent.getMathGuard()));

                while (guardSum.compareTo(sortedSum) > 0) {
                    entryArr[i + 1] = entryArr[i];
                    i--;
                    if (i < 0){
                        break;
                    }
                    Map.Entry<String, Student> sortedEntry = entryArr[i];
                    Student sortedStudent = sortedEntry.getValue();
                    sortedSum = new BigDecimal(sortedStudent.getChineseGuard())
                            .add(new BigDecimal(sortedStudent.getEnglishGuard()))
                            .add(new BigDecimal(sortedStudent.getMathGuard()));
                }
                entryArr[i + 1] = entry;
            }
            minEntryIndex++;
        }

        for (Map.Entry<String, Student> entry : entryArr) {
            Student student = entry.getValue();
            System.out.println(entry.getKey()+"----"+new BigDecimal(student.getChineseGuard())
                    .add(new BigDecimal(student.getEnglishGuard()))
                    .add(new BigDecimal(student.getMathGuard())).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
        }

    }

    @Data
    @AllArgsConstructor
    static class Student{

        private String name;

        private Float chineseGuard;

        private Float mathGuard;

        private Float englishGuard;
    }

    private static Map<String, Student> getData(){
        Map<String, Student> map = new TreeMap<>();
        Student student1 = new Student("张三",9f,2.1f,3.5f);
        Student student2 = new Student("李四",1f,40.1f,5f);
        Student student3 = new Student("王五",5f,30f,9f);
        map.put("001",student1);
        map.put("002",student2);
        map.put("003",student3);
        return map;
    }

}
