package test.study.java.mianshiti2021;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunYang
 * @date 2021/11/10 18:41
 */
public class Test1110 {

    public static void main(String[] args) {
        List<Bottom> bottomList1 = new ArrayList<>();
        bottomList1.add(new Bottom("m1-b1"));
        bottomList1.add(new Bottom("m1-b2"));
        bottomList1.add(new Bottom("m1-b3"));

        Middle m1 = new Middle("m1");
        m1.setBottomList(bottomList1);

        List<Bottom> bottomList2 = new ArrayList<>();
        bottomList2.add(new Bottom("m2-b1"));
        bottomList2.add(new Bottom("m2-b2"));
        bottomList2.add(new Bottom("m2-b3"));

        Middle m2 = new Middle("m2");
        m2.setBottomList(bottomList2);

        List<Middle> middleList = new ArrayList<>();

        middleList.add(m1);
        middleList.add(m2);

        Top t1 = new Top("t1");
        t1.setMiddleList(middleList);

        List<Top> topList = new ArrayList<>();
        topList.add(t1);

        List<String> idList = topList.stream().flatMap(top -> top.getMiddleList().stream()
                .flatMap(middle -> middle.getBottomList().stream()
                        .map(Bottom::getBottomId)))
                .collect(Collectors.toList());

        System.out.println(idList);

    }

    @Data
    public static class Top {

        public Top(String topId){
            this.topId = topId;
        }

        private String topId;

        private List<Middle> middleList;

    }

    @Data
    private static class Middle {

        public Middle(String middleId){
            this.middleId = middleId;
        }

        private String middleId;

        private List<Bottom> bottomList;

    }

    @Data
    private static class Bottom {

        public Bottom(String bottomId){
            this.bottomId = bottomId;
        }

        private String bottomId;
    }

}
