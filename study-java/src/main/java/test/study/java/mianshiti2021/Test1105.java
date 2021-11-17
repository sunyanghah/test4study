package test.study.java.mianshiti2021;

import lombok.Data;

/**
 * @author sunYang
 * @date 2021/11/5 10:16
 */
public class Test1105 {

    public static void main(String[] args) {
        new MetroLine(){

        };
    }

    @Data
    public static class MetroLine {

        private String id;

        private String code;

        private String name;

    }

}
