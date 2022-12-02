package test.study.java.mianshiti2022;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunYang
 * @date 2022/2/24 14:55
 */
public class Test0224 {

    public static void main(String[] args) {

        TestDto testDtoF1S1 = new TestDto();
        testDtoF1S1.setCode("f1-s1");

        TestDto testDtoF1S2 = new TestDto();
        testDtoF1S2.setCode("f1-s2");

        TestDto testDtoF1 = new TestDto();
        testDtoF1.setCode("f1");
        testDtoF1.setOthers(Arrays.asList(testDtoF1S1,testDtoF1S2));

        TestDto testDtoF2S1 = new TestDto();
        testDtoF2S1.setCode("f2-s1");

        TestDto testDtoF2S2 = new TestDto();
        testDtoF2S2.setCode("f2-s2");

        TestDto testDtoF2 = new TestDto();
        testDtoF2.setCode("f2");
        testDtoF2.setOthers(Arrays.asList(testDtoF2S1,testDtoF2S2));

        List<TestDto> testDtos = Arrays.asList(testDtoF1, testDtoF2);

        List<TestDto> others = testDtos.stream().flatMap(f -> f.getOthers().stream()).collect(Collectors.toList());

        others.stream().map(TestDto::getCode).forEach(System.out::println);


    }

    @Data
    public static class TestDto{

        private String code;

        private List<TestDto> others;

    }

}
