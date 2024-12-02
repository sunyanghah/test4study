package test.study.java.mianshiti2024;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**
 * @author sun yang
 * @date 2024/7/23
 */
public class Test0723 {

    public static void main(String[] args) {

        PathMatcher pathMatcher = new AntPathMatcher();
        boolean match = pathMatcher.match("http://www.a.com///", "http://www.a.com/");
        System.out.println(match);
    }

}
