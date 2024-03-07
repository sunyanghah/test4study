package test.socket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sunyang
 * @date 2023-11-17
 * @desc
 */
public class ApiRequestCondition implements RequestCondition<ApiRequestCondition> {
    private int apiVersion;

    public ApiRequestCondition(int apiVersion) {
        this.apiVersion = apiVersion;
    }
    public int getApiVersion() {
        return apiVersion;
    }

    @Override
    public ApiRequestCondition combine(ApiRequestCondition other) {
        // 采用最后定义优先原则，则方法上的定义覆盖类上面的定义
        return new ApiRequestCondition(other.getApiVersion());
    }

    @Override
    public int compareTo(ApiRequestCondition other, HttpServletRequest request) {
        //对符合请求版本的版本号进行排序
        return other.getApiVersion() - this.apiVersion;
    }

    @Override
    public ApiRequestCondition getMatchingCondition(HttpServletRequest request) {
        //设置默认版本号，请求版本号错误时使用最新版本号的接口
        Integer version=10000;
        //得到请求版本号
        String apiVersion = request.getHeader("apiVersion");
        if(null != apiVersion && !"".equals(apiVersion)){
            Matcher m = Pattern.compile("v(\\d+)").matcher(apiVersion);
            if (m.find()) {
                version = Integer.valueOf(m.group(1));
            }
        }
        // 返回小于等于请求版本号的版本
        if (version >= this.apiVersion){
            return this;
        }
        return null;
    }
}
