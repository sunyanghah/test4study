package test.security.jwt.config.security;

import lombok.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SysUserDetails implements UserDetails {

    private static final long serialVersionUID = 1L;

    public static final String ROLE_PREFIX = "ROLE_";

    private final Long id;

    private final String username;

    private String password;

    @Singular("authority")
    private final Set<GrantedAuthority> authorities;

    @Builder.Default
    private final boolean accountNonExpired = true;

    @Builder.Default
    private final boolean accountNonLocked = true;

    @Builder.Default
    private final boolean credentialsNonExpired = true;

    @Builder.Default
    private final boolean enabled = true;

    public static GrantedAuthority authority(String authority) {
        if (StringUtils.isNotBlank(authority)) {
            return new SimpleGrantedAuthority(authority);
        }
        return null;
    }

    public static GrantedAuthority role(String role) {
        if (StringUtils.isNotBlank(role)) {
            String roleFullName = StringUtils.startsWithIgnoreCase(role, ROLE_PREFIX)
                    ? role
                    : ROLE_PREFIX + role;
            return new SimpleGrantedAuthority(roleFullName);
        }
        return null;
    }
}
