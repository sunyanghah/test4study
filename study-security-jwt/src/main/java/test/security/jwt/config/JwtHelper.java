package test.security.jwt.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.Base64Codec;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import test.security.jwt.config.security.SysJwtProperties;

import javax.annotation.Resource;
import java.util.Date;

/**
 * JWT 辅助。
 *
 * @date 2020-07
 */
@Component
@Slf4j
public class JwtHelper {

  public static final String CLAIMS_SUBJECT_ID = "sui";

  @Resource
  @lombok.Getter
  @lombok.Setter
  private SysJwtProperties sysJwtProperties;

  public boolean checkSchema(String tokenWithSchema) {
    String authSchema = sysJwtProperties.getAuthSchema();
    return StringUtils.startsWithIgnoreCase(tokenWithSchema, authSchema);
  }

  public String removeSchema(String tokenWithSchema) {
    String authSchema = sysJwtProperties.getAuthSchema();
    if (StringUtils.length(tokenWithSchema) < authSchema.length()) {
      return StringUtils.EMPTY;
    }
    return StringUtils.substring(tokenWithSchema, authSchema.length());
  }

  public String getSubject(String tokenWithoutSchema) {
    return parse(tokenWithoutSchema).getBody().getSubject();
  }

  public String getSubject(Jws<Claims> claimsJws) {
    return claimsJws.getBody().getSubject();
  }

  public boolean isExpired(String tokenWithoutSchema) {
    return parse(tokenWithoutSchema).getBody().getExpiration().before(new Date());
  }

  public boolean isExpired(Jws<Claims> claimsJws) {
    return claimsJws.getBody().getExpiration().before(new Date());
  }

  public Jws<Claims> parse(String tokenWithoutSchema) {
    if (StringUtils.isBlank(tokenWithoutSchema)) {
      return null;
    }
    try {
      String secretBase64 = generateBase64Secret();
      return Jwts.parser()
        .setSigningKey(secretBase64)
        .parseClaimsJws(tokenWithoutSchema);
    } catch (Exception ex) {
      // just ignore
      if (log.isWarnEnabled()) {
        log.warn("Parse token failed.", ex);
      }
    }
    return null;
  }

  public String buildToken(Claims claims) {
    return build(claims, generateTokenExpirationDate());
  }

  public String buildRefreshToken(Claims claims) {
    return build(claims, generateRefreshTokenExpirationDate());
  }

  private String build(Claims claims, Date expirationDate) {
    try {
      JwtBuilder jwtBuilder = Jwts.builder();
      // alg
      String secretBase64 = generateBase64Secret();
      jwtBuilder.signWith(SignatureAlgorithm.HS512, secretBase64);
//      // jti
//      String id = Optional.ofNullable(claims.getId())
//        .orElseGet(UUIDUtils::uuid32);
//      jwtBuilder.setId(id);
      // exp
      jwtBuilder.setExpiration(expirationDate).addClaims(claims);
      return jwtBuilder.compact();
    } catch (Exception ex) {
      // just ignore
      if (log.isWarnEnabled()) {
        log.warn("Build token failed.", ex);
      }
    }
    return StringUtils.EMPTY;
  }

  /**
   * 生成 Base64 秘钥。
   *
   * @return Base64 秘钥
   */
  private String generateBase64Secret() {
    String secret = sysJwtProperties.getSecret();
    return Base64Codec.BASE64.encode(secret);
  }

  /**
   * 生成过期时间。
   *
   * @return 过期时间
   */
  private Date generateTokenExpirationDate() {
    Long expiration = sysJwtProperties.getTokenExpiration();
    return new Date(System.currentTimeMillis() + expiration * 1000);
  }

  /**
   * 生成RefreshToken过期时间。
   *
   * @return 过期时间
   */
  private Date generateRefreshTokenExpirationDate() {
    Long expiration = sysJwtProperties.getRefreshTokenExpiration();
    return new Date(System.currentTimeMillis() + expiration * 1000);
  }
}
