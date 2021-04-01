package test.study.java.mianshiti2021;

import java.util.Arrays;

/**
 * @author sunYang
 * @Date 2021-03-31
 */
public class Test0331 {

    public static void main(String[] args) {
        /**
         * A      C
         * AB     BC
         * ABC    ABC
         * ABCA   CABC
         * ABCAB  BCABC*
         *
         */

        int[] nextArr = getNext3("ABCACDDABCABDD");
        Arrays.stream(nextArr).forEach(System.out::println);
    }

    private static int[] getNext(String p){
        int length = p.length();
        int[] next = new int[length];
        for (int i = 0;i < length;i++){
            int preIndex = 0;
            int sufIndex = i;
            int longest = 0;
            while (preIndex < i && sufIndex > 0){
                String pre = p.substring(0, preIndex+1);
                String suf = p.substring(sufIndex, i+1);
                if (pre.equals(suf) && pre.length() > longest){
                    longest = pre.length();
                }
                preIndex++;
                sufIndex--;
            }
            next[i] = longest;
        }
        return next;
    }


    private static int[] getNext2(String p){
        int length = p.length();
        int[] next = new int[length];
        int k = 0;
        for (int i = 1;i<=length-1;i++){
            while (k > 0 && p.charAt(k) != p.charAt(i)){
                k = next[k-1];
            }
            if (p.charAt(k) == p.charAt(i)){
                k += 1;
            }
            next[i] = k;
        }
        return next;
    }


    private static int[] getNext3(String p){
        char[] arr = p.toCharArray();
        if (arr.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[arr.length];

        // 根据定义初始化next数组，0位置为-1，1位置为0.
        next[0] = -1;
        next[1] = 0;
        int pos = 2;    // 当前位置
        int cn = 0;     // 当前位置前一个字符的 next[] 值(最长相等前后缀的长度)
        while (pos < next.length) {
            if (arr[pos - 1] == arr[cn]) {
                // 当字符串的 pos-1 位置与 pos-1 位置字符所对应的最长相同前后缀的下一个字符 arr[next[pos-1]] 相等时
                // 我们就能确定 next[pos] 的值为 pos-1 位置所对应的 next[pos-1] + 1,即 ++cn.
                next[pos++] = ++cn;
            } else if (cn > 0) {
                // 当着两个字符 不相等 时，cn向前跳跃到 next[cn] 的位置，去寻找长度更短的相同前后缀。
                cn = next[cn];
            } else {
                // cn<=0; 此时说明前面已经没有相同前后缀了，即 cn 已经没办法再跳跃了，
                // 此时 pos 对应的 next[pos] 值为 0 （无相同前后缀）
                next[pos++] = 0;
            }
        }

        return next;
    }

}
