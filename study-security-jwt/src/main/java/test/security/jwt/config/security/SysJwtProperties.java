package test.security.jwt.config.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * JWT 配置。
 *
 * @date 2020-07
 */
@Component
@ConfigurationProperties(prefix = "sys.jwt")
@Data
public class SysJwtProperties {

  private String authHeader = "Authorization";

  private String authSchema = "Bearer";

  /**
   * 秘钥（原始秘钥，不用 Base64 编码，系统使用时进行编码）。
   */
  private String secret = "secret";

  /**
   * 过期时间（秒），默认 2 小时。
   */
  private Long tokenExpiration = 7 * 24 * 60 * 60L;

  /**
   * 过期时间（秒），默认 14 天。
   */
  private Long refreshTokenExpiration = 14 * 24 * 60 * 60L;

  /**
   * 用户Token缓存，参数 1 为 username
   */
  private String tokenCacheKeyPrefix = "sys:u:jwt:";

  /**
   * 用户RefreshToken缓存，参数 1 为 username
   */
  private String refreshTokenCacheKeyPrefix = "sys:u:r-jwt:";
}
