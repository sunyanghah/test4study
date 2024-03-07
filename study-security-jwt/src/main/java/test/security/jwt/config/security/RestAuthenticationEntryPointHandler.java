package test.security.jwt.config.security;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * token不对时会走这里
 * @date 2020-08-03
 */
@Component
@Slf4j
public class RestAuthenticationEntryPointHandler implements AuthenticationEntryPoint {

  @Override
  public void commence(HttpServletRequest request,
    HttpServletResponse response,
    AuthenticationException ex)
    throws IOException, ServletException {
    if (log.isDebugEnabled()) {
      log.debug("Pre-authenticated entry point called. 拒绝访问");
    }
    // 返回错误信息
    response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
    Map<String,String> accessDeniedResponse = new HashMap();
    accessDeniedResponse.put("ERROR_AUTHENTICATION", "错误的身份凭证");
    response.getWriter().write(JSON.toJSONString(accessDeniedResponse));
  }
}
