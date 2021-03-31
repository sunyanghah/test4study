package test.study.java.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author sunYang
 * @Date 2020/10/27
 */
public class Test20201027 {

    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        String result = "{\"code\":\"0\",\"msg\":\"success\",\"data\":{\"tagId\":\"acs\",\"taskId\":\"1f276203e5234bdca08f7d99e1097bba\",\"taskType\":1,\"taskOptType\":1,\"startTime\":\"2018-09-03T17:30:08.000+08:00\",\"totalPercent\":80,\"leftTime\":10,\"consumeTime\":40,\"isDownloadFinished\":false,\"resourceDownloadProgress\":[{\"resourceInfo\":{\"resourceIndexCode\":\"b5a017f05e8b4ef9b4af903bf7feec75\",\"resourceType\":\"acsDevice\",\"channelNos\":[1],\"channelIndexCodes\":[\"0a869b06f4ff4da29949acf006405c39\"]},\"startTime\":\"2018-09-03T17:30:08.000+08:00\",\"updateTime\":\"2018-09-03T17:30:48.000+08:00\",\"endTime\":\"2018-09-03T17:31:08.000+08:00\",\"leftTime\":3,\"errorCode\":\"0\",\"downloadResult\":1,\"consumeTime\":1,\"downloadStatus\":\"DOWNLOADING\",\"isDownloadFinished\":false,\"downloadPercent\":80,\"totalPersonCount\":500,\"downloadPersonCount\":500,\"successedPersonCount\":400,\"failedPersonCount\":2}]}}";
        HikResultCO hikResult = JSON.parseObject(result, new TypeReference<HikResultCO<HikTaskProgressCO2>>() {
        });


        // jackson

        HikResultCO hikResult2 = objectMapper.readValue(result, new com.fasterxml.jackson.core.type.TypeReference<HikResultCO<HikTaskProgressCO2>>() {
        });

        System.out.println(hikResult);
    }

    @Data
    public static class HikTaskProgressCO2 {

        private String tagId;
        private String taskId;
        private Integer taskType;
        private Integer taskOptType;
        private String startTime;
        private Integer totalPercent;
        private Integer leftTime;
        private Integer consumeTime;
        private Boolean isDownloadFinished;
        private List<ResourceProgress> resourceDownloadProgress;

    }

    @Data
    public static class ResourceProgress {
        private String startTime;
        private String updateTime;
        private String endTime;
        private Integer leftTime;
        private String errorCode;
        private Integer downloadResult;
        private Integer consumeTime;
        private String downloadStatus;
        private Boolean isDownloadFinished;
        private Integer downloadPercent;
        private Integer totalPersonCount;
        private Integer downloadPersonCount;
        private Integer successedPersonCount;
        private Integer failedPersonCount;
        private List<Resource> resourceInfo;
    }


    @Data
    public static class Resource {
        private String resourceIndexCode;
        private String resourceType;
        private List<Integer> channelNos;
        private List<String> channelIndexCodes;
    }

    @Data
    public static class HikResultCO<T> implements Serializable {

        private static final long serialVersionUID = -5143521758680659067L;

        private String code;

        private String msg;

        private T data;

        private Boolean isSuccess;

        public Boolean getIsSuccess() {
            if ("0".equals(code)) {
                return true;
            } else {
                return false;
            }
        }

    }

}
