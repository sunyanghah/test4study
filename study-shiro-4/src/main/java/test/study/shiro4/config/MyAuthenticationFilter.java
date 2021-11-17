package test.study.shiro4.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyAuthenticationFilter extends FormAuthenticationFilter {

    private RedisTemplate<String,Object> redisTemplate;

    public MyAuthenticationFilter(RedisTemplate<String,Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {

        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("token");
        if (StringUtils.isBlank(token)){
            return false;
        }

        return redisTemplate.hasKey(ShiroConfig.keyPrefix+token);

    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        response.setContentType("application/json; charset=utf-8");//返回json
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(ApiResult.fail(401,"认证失败")));
        return false;
    }
}
