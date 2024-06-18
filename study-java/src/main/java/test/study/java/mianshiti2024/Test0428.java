package test.study.java.mianshiti2024;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/4/28
 */
public class Test0428 {

    public static void main(String[] args) {

        TTT ttt = new TTT();
        ttt.setList(Arrays.asList("1", "2", "3"));

        TTT ttt2 = new TTT();
        ttt2.setList(null);

        TTT ttt3 = new TTT();
        ttt3.setList(Arrays.asList("1", "3"));

        List<TTT> list = Arrays.asList(ttt, ttt2, ttt3);

        list.forEach(t -> {
            System.out.println(t.getList());
        });

        System.out.println("===============");

        list.sort((o1, o2) -> {
            List<String> list1 = o1.getList();
            List<String> list2 = o2.getList();
            return  (list2 == null ? 0 : list2.size()) - (list1 == null ? 0 : list1.size());
        });

        list.forEach(t -> {
            System.out.println(t.getList());
        });

    }

    @Data
    public static class TTT {

        private List<String> list;

    }

}
