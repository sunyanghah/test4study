package test.security.jwt.config.security;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录用户名密码错误时会走这里
 * @date 2020-08-03
 */
@Component
@Slf4j
public class RestAuthenticationFailureHandler implements AuthenticationFailureHandler {

  @Override
  public void onAuthenticationFailure(HttpServletRequest request,
    HttpServletResponse response,
    AuthenticationException exception)
    throws IOException, ServletException {
    if (log.isDebugEnabled()) {
      log.debug("认证失败");
    }
    // 认证失败
    response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
    Map<String,String> accessDeniedResponse = new HashMap<>();
    accessDeniedResponse.put("UNAUTHORIZED", "用户名或密码错误");
    response.getWriter().write(JSON.toJSONString(accessDeniedResponse));
  }
}
