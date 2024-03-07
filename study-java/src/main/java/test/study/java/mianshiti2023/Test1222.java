package test.study.java.mianshiti2023;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;
import org.springframework.util.PathMatcher;

import java.nio.file.Paths;
import java.util.*;

/**
 * @author sun yang
 * @date 2023/12/22
 */
public class Test1222 {

    public static void main(String[] args) {
        User user = new User();
        user.setExtInfo("name","sunyang");
        user.setExtInfo("age",18);

        System.out.println(user.getExtInfo());

        String[] strs = {"1","2"};

        test(strs);

        List<String> strings = new ArrayList<>(Arrays.asList("1", "2"));
        strings.add("3");
        strings.forEach(System.out::println);
        String[] strArr = strings.toArray(new String[strings.size()]);
        System.out.println(strArr);

        System.out.println("---------------------");
        System.out.println(Paths.get("///sf#4"));
    }

    private static void test(String ...args){

    }

    @Data
    public static class User{

        private Map extInfo = new HashMap();

        @JsonAnyGetter
        public Map getExtInfo(){
            return this.extInfo;
        }

        @JsonAnySetter
        public void setExtInfo(String key, Object value) {
            extInfo.put(key, value);
        }
    }

}
