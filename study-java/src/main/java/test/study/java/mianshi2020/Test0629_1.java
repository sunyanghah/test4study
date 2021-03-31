package test.study.java.mianshi2020;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dell on 2020/6/29.
 * @author dell
 */
public class Test0629_1 {

    private static Pattern compile = Pattern.compile(".+//.+?(/.*)");

    public static void main(String[] args) {
        String urlStr = "https://www.com/uploadImg/image/20200629/1593405960668690.jpg";
        String handleUrl = test1(urlStr);
        System.out.println(handleUrl);
        Pattern.matches("","");
    }

    private static String test1(String urlStr){
        Matcher matcher = compile.matcher(urlStr);
        if (matcher.find()){
            return matcher.group(1);
        }
        return "";
    }
}
