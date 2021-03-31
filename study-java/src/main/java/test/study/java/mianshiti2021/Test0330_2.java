package test.study.java.mianshiti2021;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunYang
 * @Date 2021-03-30
 */
public class Test0330_2 {

    public static void main(String[] args) {
        String str = "中国/山东/济南/高新/汉峪金谷";

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

        deptList.forEach(System.out::println);
    }

}
