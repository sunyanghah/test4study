package test.study.algorithm;

import java.util.*;

/**
 * @author sunYang
 * @Date 2021-03-24
 */
public class LeetCode05 {

    public static void main(String[] args) {
        String s = "{{}}";
        System.out.println(test1(s));

        String s1 = "{[()]}";
        System.out.println(test1(s1));

        String s2 = "{]";
        System.out.println(test1(s2));

        String s3 = "{";
        System.out.println(test1(s3));

        String s4 = "123";
        System.out.println(test1(s4));

        String s5 = "(23)";
        System.out.println(test1(s5));

        String s6 = "{123[4(wer)]....}";
        System.out.println(test1(s6));
    }

    private static boolean test1(String s){

        Deque<Character> stack = new LinkedList();

        Map<Character,Character> map = new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                stack.push(aChar);
            }else if (map.values().contains(aChar)){
                Character topChar = stack.poll();
                if (topChar == null || aChar != map.get(topChar)){
                    return false;
                }
            }
        }
        if (stack.size() > 0){
            return false;
        }

        return true;
    }

}
