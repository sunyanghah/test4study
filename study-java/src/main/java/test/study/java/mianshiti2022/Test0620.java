package test.study.java.mianshiti2022;

import lombok.Data;

/**
 * @author sunYang
 * @date 2022/6/20 9:39
 */
public class Test0620 {

    public static void main(String[] args) {
        Aaa aaa = new Aaa();
        aaa.setName("张三");
        aaa.setTestFlag(true);

        Bbb bbb = new Bbb();


    }

    @Data
    public static class Aaa {

        private String name;

        private boolean testFlag;

    }

    @Data
    public static class Bbb {

        private String name;

        private Integer testFlag;

    }

}


