package test.security.jwt.config.security;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import test.security.jwt.config.util.JSONUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 配置登录与账号密码认证
 *
 * @date 2020-08-03
 */
@Slf4j
public class RestJwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

  public static final String DEFAULT_LOGIN_URL = "/auth/login";

  @Setter
  private boolean postOnly = true;

  public RestJwtAuthenticationFilter() {
    super(new AntPathRequestMatcher(DEFAULT_LOGIN_URL, HttpMethod.POST.name()));
  }

  public RestJwtAuthenticationFilter(String loginUrl) {
    super(new AntPathRequestMatcher(loginUrl, HttpMethod.POST.name()));
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request,
    HttpServletResponse response)
    throws AuthenticationException, IOException, ServletException {
    if (postOnly && !request.getMethod().equalsIgnoreCase(HttpMethod.POST.name())) {
      throw new AuthenticationServiceException(
        "Authentication method not supported: " + request.getMethod());
    }
    // 获取请求体
    UsernameAndPasswordAuthenticationCmd userLoginCmd = obtainSysUserLoginCmd(request);
    String username = userLoginCmd.getUsername();
    String password = userLoginCmd.getPassword();
    UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
      username, password);

    // 允许使用请求明细 details 属性
    setDetails(request, authRequest);

    return this.getAuthenticationManager().authenticate(authRequest);
  }

  private UsernameAndPasswordAuthenticationCmd obtainSysUserLoginCmd(HttpServletRequest request)
    throws IOException {
    UsernameAndPasswordAuthenticationCmd userLoginCmd = JSONUtils.getObjectMapper()
      .readValue(request.getReader(), UsernameAndPasswordAuthenticationCmd.class);
    String username = userLoginCmd.getUsername();
    String password = userLoginCmd.getPassword();
    // trim username to empty
    // strip password to empty
    userLoginCmd.setUsername(StringUtils.trimToEmpty(username));
    userLoginCmd.setPassword(StringUtils.stripToEmpty(password));
    return userLoginCmd;
  }

  protected void setDetails(HttpServletRequest request,
    UsernamePasswordAuthenticationToken authRequest) {
    authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
  }
}
