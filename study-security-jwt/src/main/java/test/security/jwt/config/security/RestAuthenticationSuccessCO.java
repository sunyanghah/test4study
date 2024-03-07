package test.security.jwt.config.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Map;

/**
 * 认证成功响应
 * @date 2020-08-03
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RestAuthenticationSuccessCO {

  private static final long serialVersionUID = -4402159869830678233L;

  @JsonProperty("auth_schema")
  private String authSchema;

  @JsonProperty("access_token")
  private String accessToken;

  @JsonProperty("refresh_token")
  private String refreshToken;

  protected Map<String, Object> extValues;
}
