package test.security.jwt.config.security;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 没有权限时会走这里
 * @date 2020-08-03
 */
@Component
@Slf4j
public class RestAccessDeniedHandler implements AccessDeniedHandler {

  @Override
  public void handle(HttpServletRequest request,
    HttpServletResponse response,
    AccessDeniedException ex)
    throws IOException, ServletException {
    if (log.isDebugEnabled()) {
      log.debug("拒绝访问");
    }
    // 返回错误信息
    response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
    Map<String,String> accessDeniedResponse = new HashMap();
    accessDeniedResponse.put("ACCESS_DENIED", "您的账号无权限访问");
    response.getWriter().write(JSON.toJSONString(accessDeniedResponse));
  }
}
