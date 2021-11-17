package test.study.shiro1.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyAuthenticationFilter extends FormAuthenticationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        response.setContentType("application/json; charset=utf-8");//返回json
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(ApiResult.fail(401,"没有登录")));
        return false;
    }
}
