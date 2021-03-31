package test.study.java.mianshiti2021;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sunYang
 * @Date 2021-03-30
 */
public class Test0330 {

    public static void main(String[] args) {

        List<String> paramDeptList = getParamDept();
        List<String> nowDeptList = getNowDept();

        List<String> needToAddList = paramDeptList.stream().filter(paramDept -> !nowDeptList.contains(paramDept))
                .collect(Collectors.toList());

        Set<String> set = new HashSet<>();

        for (String needToAddDept : needToAddList) {
            List<String> splitDept = getSplitDept(needToAddDept);
            set.addAll(splitDept);
        }

        Set<String> sortedSet = new TreeSet<>((o1,o2) -> {
           if (o1.split("/").length > o2.split("/").length){
               return 1;
           }else {
               return -1;
           }
        });

        sortedSet.addAll(set);

        set.forEach(System.out::println);
        System.out.println("---------------------------");
        sortedSet.forEach(System.out::println);
    }

    private static List<String> getParamDept(){
        List<String> deptList = Arrays.asList("中国/山东/济南/高新/汉峪金谷", "中国/山东/泰安", "中国/上海", "美国/纽约",
                "中国/北京/朝阳", "中国/河北/泰安" , "美国/上海");
        return deptList;
    }


    private static List<String> getNowDept(){
        List<String> deptList = Arrays.asList("中国/山东/济南/历下", "中国/山东/青岛/崂山", "中国/北京/海淀", "中国/上海");
        return deptList;
    }

    private static Integer queryId(String fullDeptName){
        Map<String,Integer> map = new HashMap<>();
        map.put("中国",1);
        map.put("中国/山东",11);
        map.put("中国/北京",12);
        map.put("中国/上海",13);
        map.put("中国/山东/济南",111);
        map.put("中国/山东/青岛",112);
        map.put("中国/北京/海淀",121);
        map.put("中国/山东/济南/历下",1111);
        map.put("中国/山东/青岛/崂山",1121);

        Integer id = map.get(fullDeptName);
        return id;
    }

    private static List<String> getSplitDept(String str){
        List<String> deptList = new ArrayList<>();
        int lastIndex = -1;
        while (true) {

            lastIndex = str.indexOf("/",lastIndex+1);
            if (lastIndex == -1){
                deptList.add(str);
                break;
            }
            String substring = str.substring(0, lastIndex);

            deptList.add(substring);

        }

        return deptList;

    }

}
