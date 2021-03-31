package test.study.java.mianshi2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunYang
 * @Date 2020/9/21
 */
public class Test0921 {

    public static void main(String[] args) {
        List<Long> guardIdList = Arrays.asList(1L,2L,3L,4L);
        List<Long> oldGuardIdList = Arrays.asList(3L,4L,5L);

        List<Long> addList = new ArrayList<>();
        List<Long> deleteList = new ArrayList<>();
        List<Long> editList = new ArrayList<>();
        for (Long newGuardId : guardIdList) {
            if (!oldGuardIdList.contains(newGuardId)){
                addList.add(newGuardId);
            }else{
                editList.add(newGuardId);
            }
        }

        for (Long oldGuardId : oldGuardIdList) {
            if (!guardIdList.contains(oldGuardId)){
                deleteList.add(oldGuardId);
            }
        }

        addList.forEach(System.out::print);
        System.out.println("----------");
        editList.forEach(System.out::print);
        System.out.println("----------");
        deleteList.forEach(System.out::print);
    }
}
