package test.study.spring2.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @author sunYang
 * @date 2023/2/16 14:03
 */
@Data
public class FinalPerformanceDTO {

    private String ciCode;
    private String metric;
    private Double value;
    private Long classId;
    private Long domainId;
    private String instance;
    private String unit;
    private Long time;

    private String val;
    private String ci_name;
    private String kpi_name;
    private Long create_time;
    private Long modify_time;
    private String perfIdentify;

    private JSONObject otherFiledMap = new JSONObject();
    private JSONObject metricAttrs;

    public void addField(String fieldName, Object value) {
        otherFiledMap.put(fieldName, value);
    }

    public Object getFiledValue(String fieldName) {
        return otherFiledMap.get(fieldName);
    }

    /**
     * 转化为json字符串
     * @author: weixuesong
     * @date: 2020/7/10 16:35
     * @return: java.lang.String
     */
    public String toJsonString() {
        JSONObject baseFieldJson = (JSONObject) JSON.toJSON(this);
        JSONObject result = new JSONObject();
        result.putAll(baseFieldJson);
        result.putAll(otherFiledMap);
        return result.toJSONString();
    }

    /**
     * 转化为json对象
     * @author: weixuesong
     * @date: 2020/7/10 16:35
     * @return: java.lang.String
     */
    public JSONObject toJsonObject() {
        JSONObject baseFieldJson = (JSONObject) JSON.toJSON(this);
        JSONObject result = new JSONObject();
        result.putAll(baseFieldJson);
        result.putAll(otherFiledMap);
        return result;
    }

}
