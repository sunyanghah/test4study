package test.security.jwt.config.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.GenericFilterBean;
import test.security.jwt.config.JwtHelper;
import test.security.jwt.config.cache.CacheUtil;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private static final String[] WEB_WHITE_LIST = {
    "/user/register",
    "/third-party/**",
    "/static/**",
    "/public/**",
    "/about",
    "/data/**",
    /* swagger */
    "/swagger-resources/**",
    "/swagger-ui.html**",
    /* common resources */
    "/css/**",
    "/js/**",
    "/images/**",
    "/webjars/**",
    "/**/favicon.ico"
  };

  private static final String[] AUTHORIZE_WHITE_LIST = {
    /* all */
//    "/**",
    /* demo */
    "/demo/**",
//    "/test/**",
    /* white list */
    "/auth/**",
    "/login*",
    "/user/login",
    "/logout*",
    "/user/logout*",
    "/register*",
    "/register/**",
    "/alarm/electronic-fence-log/export",
    "/device/entrance-guard/access-log/export",
    "/device/user-tag-binding-log/export",
    "/vehicle/violate-export",
    "/gs-ints-websocket"
  };

  @Resource
  @lombok.Setter
  private AuthenticationEntryPoint restAuthenticationEntryPoint;

  @Resource
  @lombok.Setter
  private AccessDeniedHandler restAccessDeniedHandler;

  @Resource
  @lombok.Setter
  private AuthenticationSuccessHandler restAuthenticationSuccessHandler;

  @Resource
  @lombok.Setter
  private AuthenticationFailureHandler restAuthenticationFailureHandler;

  @Resource
  @lombok.Setter
  private JwtHelper jwtHelper;

  @Resource
  @lombok.Setter
  private UserDetailsService userDetailsService;

//  @Resource
//  @lombok.Setter
//  private StringRedisTemplate stringRedisTemplate;

  @Resource
  private CacheUtil cacheUtil;

  @Bean
  public PasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder();
    return new PasswordEncoder() {
      @Override
      public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
      }

      @Override
      public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.toString().equals(encodedPassword);
      }
    };
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();

    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.addAllowedOrigin("*");
    corsConfiguration.addAllowedHeader("*");
    corsConfiguration.addAllowedMethod("*");
    corsConfiguration.setAllowCredentials(true);

    corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
    return corsConfigurationSource;
  }

  public GenericFilterBean restJwtAuthenticationFilter() throws Exception {
    RestJwtAuthenticationFilter filter = new RestJwtAuthenticationFilter();
    // handler
    filter.setAuthenticationSuccessHandler(restAuthenticationSuccessHandler);
    filter.setAuthenticationFailureHandler(restAuthenticationFailureHandler);
    // authentication manager
    filter.setAuthenticationManager(authenticationManager());
    return filter;
  }

  public GenericFilterBean restJwtAuthorizationFilter() {
    RestJwtAuthorizationFilter filter = new RestJwtAuthorizationFilter();

    filter.setJwtHelper(jwtHelper);
    filter.setUserDetailsService(userDetailsService);
    filter.setCacheUtil(this.cacheUtil);

    return filter;
  }

  // Authentication: via userDetailService Bean
  // Authorization: Role -> Access
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // @formatter:off
    http
      // CORS and CSRF
      .cors().and()
      .csrf().disable()
      // 会话：无状态
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and()
      // 异常处理：authentication, authorization
      .exceptionHandling()
      .authenticationEntryPoint(restAuthenticationEntryPoint)
      .accessDeniedHandler(restAccessDeniedHandler)
      .and()
      // 鉴权
      .authorizeRequests()
      .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
      .antMatchers(HttpMethod.GET,"/**").permitAll()
      .antMatchers(AUTHORIZE_WHITE_LIST).permitAll()
      .anyRequest().authenticated()
      .and()
      // JWT
      .addFilterBefore(restJwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
      .addFilterBefore(restJwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
      // 禁用缓存
      .headers()
      .cacheControl().disable()
      .and();
    // @formatter:on
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    // @formatter:off
    web.ignoring()
      .antMatchers(WEB_WHITE_LIST)
      .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    // @formatter:on
  }
}
