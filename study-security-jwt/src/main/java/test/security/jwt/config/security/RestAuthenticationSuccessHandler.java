package test.security.jwt.config.security;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.DefaultClaims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import test.security.jwt.config.JwtHelper;
import test.security.jwt.config.SingleResponse;
import test.security.jwt.config.cache.CacheUtil;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * 认证成功handler
 * @date 2020-08-03
 */
@Component
@Slf4j
public class RestAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

  @Resource
  @lombok.Setter
  private JwtHelper jwtHelper;

  @Resource
  private CacheUtil cacheUtil;

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
    Authentication authentication) throws IOException, ServletException {
    if (log.isDebugEnabled()) {
      log.debug("认证成功");
    }
    // 认证成功，返回 Token
    // 处理登入成功请求
    Object principal = authentication.getPrincipal();
    Claims claims = new DefaultClaims();
    String username = "";
    if (principal instanceof SysUserDetails) {
      SysUserDetails user = (SysUserDetails) principal;
      username = user.getUsername();
      claims.put(JwtHelper.CLAIMS_SUBJECT_ID, user.getId());
      claims.put(Claims.SUBJECT, username);
    }
    String token = jwtHelper.buildToken(claims);
    // 缓存（带上随机延时）
    cacheToken(username, token);
    // 响应消息
    String authSchema = jwtHelper.getSysJwtProperties().getAuthSchema();
    response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
    RestAuthenticationSuccessCO co = RestAuthenticationSuccessCO.builder()
      .authSchema(authSchema)
      .accessToken(token)
      .build();
    response.getWriter().write(JSON.toJSONString(SingleResponse.success(co)));
  }

  /**
   * 缓存Token
   *
   * @param username username
   * @param token token
   */
  private void cacheToken(String username, String token) {
    String userTokenCacheKey = jwtHelper.getSysJwtProperties().getTokenCacheKeyPrefix()
      + username;
    long timeout = jwtHelper.getSysJwtProperties().getTokenExpiration()
      + ThreadLocalRandom.current().nextInt(0, 60);
    cacheUtil.set(String.format(userTokenCacheKey, username),
        token,
        timeout,
        TimeUnit.SECONDS);
  }
}
