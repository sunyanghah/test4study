package test.study.java.mianshi2020;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by dell on 2020/7/14.
 * @author dell
 */
public class Test0714 {

    public static void main(String[] args) {
        List<Sheep> sheepList = new ArrayList<>(8);
        Sheep sheep1 = new Sheep(1L,"red","50kg");
        Sheep sheep2 = new Sheep(2L,"black","60kg");
        Sheep sheep2_2 = new Sheep(2L,"black","60kg");
        Sheep sheep3 = new Sheep(3L,"blue","70kg");
        Sheep sheep4 = new Sheep(4L,"greed","80kg");
        Sheep sheep4_2 = new Sheep(4L,"greed","80kg");
        sheepList.add(sheep1);
        sheepList.add(sheep2);
        sheepList.add(sheep2_2);
        sheepList.add(sheep3);
        sheepList.add(sheep4);
        sheepList.add(sheep4_2);

        sheepList = test1(sheepList);
        sheepList.forEach(sheep -> System.out.println(JSON.toJSONString(sheep)));
    }

    public static List<Sheep> test1(List<Sheep> sheepList){
        // 需要重写hashCode和equals方法
        return sheepList.stream().distinct().collect(Collectors.toList());
    }

    public static List<Sheep> test2(List<Sheep> sheepList){
        List<Sheep> newList = new ArrayList<>(sheepList.size());
        for (Sheep sheep : sheepList) {
            boolean hasFlag = false;
            for (Sheep nowSheep : newList) {
                if (sheep.getId().compareTo(nowSheep.getId()) == 0){
                    hasFlag = true;
                }
            }
            if (!hasFlag){
                newList.add(sheep);
            }
        }
        return newList;
    }

    public static List<Sheep> test3(List<Sheep> sheepList){
        // 需要重写hashCode和equals方法
        Set set = new HashSet<>(sheepList);
        return new ArrayList<>(set);
    }

    @Data
    static class Sheep{

        Sheep(Long id,String color,String weight){
            this.id = id;
            this.color = color;
            this.weight = weight;
        }

        private Long id;

        private String color;

        private String weight;

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj != null && obj instanceof Sheep){
                if (((Sheep)obj).getId().compareTo(this.id) == 0){
                    return true;
                }
            }
            return false;
        }
    }


}
