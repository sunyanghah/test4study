package test.security.jwt.config.security;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * 认证请求参数
 * @date 2020-08-01
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class UsernameAndPasswordAuthenticationCmd {

  private static final long serialVersionUID = -8854652955007624451L;

  @NotNull(message = "请输入用户名")
  private String username;

  @NotNull(message = "请输入密码")
  private String password;
}
