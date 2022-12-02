package test.study.java.mianshiti2022;

import org.springframework.util.AntPathMatcher;

import java.util.Arrays;
import java.util.List;

/**
 * @author sunYang
 * @date 2022/7/21 13:52
 */
public class Test0721 {

    public static void main(String[] args) {

        List<String> urlList = Arrays.asList("/manager/123","/manager/ttt/we","/manager","/df/manager/fff","/base/sso/redirect");

        AntPathMatcher antPathMatcher = new AntPathMatcher();
//        for (String url : urlList) {
//            System.out.println(url+"------------"+antPathMatcher.match("/manager/**",url));
//        }

        for (String url : urlList) {
            System.out.println(url+"------------"+antPathMatcher.match("/base/sso/redirect/",url));
        }
    }

}
