package test.security.jwt.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import test.security.jwt.config.JwtHelper;
import test.security.jwt.config.cache.CacheUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * jwt认证
 * @date 2020-08-03
 */
@Slf4j
public class RestJwtAuthorizationFilter extends OncePerRequestFilter {

  @lombok.Setter
  private JwtHelper jwtHelper;

  @lombok.Setter
  private UserDetailsService userDetailsService;

//  @lombok.Setter
//  private StringRedisTemplate stringRedisTemplate;
  @lombok.Setter
  private CacheUtil cacheUtil;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
    FilterChain filterChain) throws ServletException, IOException {
    // fail-fast: 1）已经校验通过
    if ((SecurityContextHolder.getContext().getAuthentication() != null)) {
      if (log.isTraceEnabled()) {
        log.trace("fail-fast: 已认证通过。");
      }
      filterChain.doFilter(request, response);
      return;
    }
    // 获取Token
    // fail-fast: 1)未获取到Token；2）获取到的Token不合法；2）Token过期；3）Token主题为空
    Jws<Claims> jwt = obtainJws(request);
    if (jwt == null) {
      if (log.isTraceEnabled()) {
        log.trace("fail-fast: Token无效。");
      }
      filterChain.doFilter(request, response);
      return;
    }
    // 有效Token： 二次检查
    String username = jwtHelper.getSubject(jwt);
    String cachedToken = fetchCachedToken(username);
    if ((cachedToken == null) || StringUtils.isBlank(cachedToken)) {
      if (log.isTraceEnabled()) {
        log.trace("fail-fast: Token已过期或删除。");
      }
      filterChain.doFilter(request, response);
      return;
    }
    // 生成认证信息
    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
      userDetails, null, userDetails.getAuthorities());
    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
    log.info("Authenticated user [{}], setting security context.", username);
    SecurityContextHolder.getContext().setAuthentication(authentication);
    filterChain.doFilter(request, response);
  }

  /**
   * 从缓存中获取Token
   *
   * @param username username
   * @return token with schema
   */
  private String fetchCachedToken(String username) {
    String userTokenCacheKey = jwtHelper.getSysJwtProperties().getTokenCacheKeyPrefix()
      + username;
    if (StringUtils.isBlank(userTokenCacheKey)) {
      return null;
    }
    if (!Optional.of(userTokenCacheKey)
      .map(cacheUtil::hasKey)
      .orElse(false)) {
      return null;
    }
    return Optional.of(userTokenCacheKey)
      .map(cacheUtil::get)
      .map(Object::toString)
      .orElse(null);
  }

  /**
   * 获取 JWT
   *
   * @param request 请求
   * @return jwt
   */
  private Jws<Claims> obtainJws(HttpServletRequest request) {
    SysJwtProperties jwtProperties = jwtHelper.getSysJwtProperties();
    String authSchema = jwtProperties.getAuthSchema();
    String authHeaderValue = obtainAuthHeader(request);

    // fail-fast: 1)未获取到Token
    if (!StringUtils.startsWithIgnoreCase(authHeaderValue, authSchema)) {
      return null;
    }
    String token = StringUtils.substring(authHeaderValue, authSchema.length());

    if (log.isDebugEnabled()) {
      log.debug("获取到的 Token 内容: {}", token);
    }
    // fail-fast: 1）未获取到合法Token；2）Token过期；3）Token主题为空
    Jws<Claims> claimsJws = jwtHelper.parse(token);
    if ((claimsJws == null)
      || jwtHelper.isExpired(claimsJws)
      || StringUtils.isBlank(jwtHelper.getSubject(claimsJws))) {
      if (log.isTraceEnabled()) {
        log.trace("fail-fast: Token无效。");
      }
      return null;
    }
    return claimsJws;
  }

  /**
   * 获取 authorization header
   *
   * @param request 请求
   * @return authorization header value
   */
  private String obtainAuthHeader(HttpServletRequest request) {
    SysJwtProperties jwtProperties = jwtHelper.getSysJwtProperties();
    return request.getHeader(jwtProperties.getAuthHeader());
  }
}
