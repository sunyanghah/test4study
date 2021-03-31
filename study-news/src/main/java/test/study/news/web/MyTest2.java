package test.study.news.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dell on 2019/7/2.
 */
public class MyTest2 {


    public static void main(String[] args) throws Exception{
       test6();
    }

    private static Pattern patternDns = Pattern.compile("^\\bnameserver\\s+(.+?)(?:\\n|\\s+|$)");
    private static void test6() throws Exception{
        String str = "nameserver  202.106.0.20";
        Matcher matcher = patternDns.matcher(str);
        if (matcher.find()){
            System.out.print(matcher.group(1));
        }
        System.out.println("---------");
    }

    private static Pattern pattern = Pattern.compile("(?:\\b|\\s+)(.+?)(?:\\s+)");
    private static void test1() throws Exception{
        String str = "0.0.0.0         172.17.15.253   0.0.0.0         UG    0      0        0 eth0\n";

        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            System.out.println("---");
            System.out.println(matcher.group(1));
        }
    }

    private static void test2() throws Exception{
        String str = " a bc   d";
        System.out.println(str.trim());
        System.out.println(str.replaceAll(" ",""));
    }
    private static void test3() throws Exception{
        String str = "0.0.0.0         172.17.15.253   0.0.0.0         UG    0      0        0 eth0\n";

        System.out.println(str.split("\\s+").length);
    }

    private static void test4() throws Exception{
        String str = "Restarting network (via systemctl):                        [  OK  ]";
        System.out.println(str.replaceAll(" ",""));
    }


    public static String[] charList = new String[]{"\"","'"};
    public static boolean patternNetFile(String regex,String str) throws Exception {
        if (str == null || regex == null) {
            return false;
        }
        StringBuilder sb;
        for (String character : charList) {
            sb = new StringBuilder();
            sb.append(character).append(regex).append(character);
            if (str.equalsIgnoreCase(sb.toString())) {
                return true;
            }
        }
        return false;
    }


    private static void test5() throws Exception{
        StringBuilder sb = new StringBuilder("123456\n");
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }

}
