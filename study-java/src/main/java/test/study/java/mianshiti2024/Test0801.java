package test.study.java.mianshiti2024;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/8/1
 */
public class Test0801 {

    public static void main(String[] args) {

        List<DeptOfUserConflictDto> dtos = Arrays.asList(new DeptOfUserConflictDto("1,2,3", "aca"),
                new DeptOfUserConflictDto("1,2,3,4", "bbb"),
                new DeptOfUserConflictDto("1,2,3,4,5", "ccc"),
                new DeptOfUserConflictDto("1,2,3", "abc"));

        dtos.sort(Comparator.comparingInt((DeptOfUserConflictDto o) -> o.getAncestors().split(",").length).thenComparing((o1,o2) -> StringUtils.compare(o1.getDeptName(), o2.getDeptName())));


        System.out.println(dtos.get(0));


    }

    @Data
    @AllArgsConstructor
    public static class DeptOfUserConflictDto{
        private String ancestors;
        private String deptName;
    }

}
