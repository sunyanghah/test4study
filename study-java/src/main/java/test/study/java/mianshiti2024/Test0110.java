package test.study.java.mianshiti2024;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Map;

/**
 * @author sun yang
 * @date 2024/1/10
 */
public class Test0110 {

    public static void main(String[] args) {
        String str = "{\"packageId\":1,\"pageConf\":{\"margin-left\":\"30px\",\"color\":\"red\",\"font-size\":\"14px\"}}";

        OutConfigDownloadVo user = JSON.parseObject(str, OutConfigDownloadVo.class);
        System.out.println(user);

    }

    @Data
    public static class User{

        private Long packageId;

        @JsonIgnore
        private Map pageConf;

        @JsonAnyGetter
        public Map getPageConf() {
            return pageConf;
        }
    }

}
