package test.study.java.mianshiti2024;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/5/13
 */
public class Test0513_2 {

    public static void main(String[] args) {

        System.out.println(compareVersion("1.0.1002.9","1.0.1002.10"));// -1
        System.out.println(compareVersion("1.0.1002.10","1.0.1003.1"));// -1
        System.out.println(compareVersion("1.0.1002.10","1.0.1002.9"));// 1
        System.out.println(compareVersion("1.001.1002.9","1.0.1003.1"));// 1
        System.out.println(compareVersion("1.0.1002.9","1.0.1002.9"));// 0

        List<String> versionList = Arrays.asList("1.0.1002.9", "1.0.1002.10", "1.0.1003.1", "1.001.1002.9", "1.0.1002.9");

        versionList.sort((o1, o2) -> o2.compareTo(o1));

        System.out.println(JSON.toJSONString(versionList));

        versionList.sort((o1, o2) -> compareVersion(o2,o1));

        System.out.println(JSON.toJSONString(versionList));

    }

    public static int compareVersion(String o1,String o2){
        String[] version1 = o1.split("\\.");
        String[] version2 = o2.split("\\.");
        int length = Math.min(version1.length, version2.length);
        for (int i = 0; i < length; i++) {
            int v1 = Integer.parseInt(version1[i]);
            int v2 = Integer.parseInt(version2[i]);
            if (v1 > v2){
                return 1;
            }else if (v1 < v2){
                return -1;
            }
        }
        if (version1.length > version2.length){
            return 1;
        }else if (version1.length < version2.length){
            return -1;
        }
        return 0;
    }

}
