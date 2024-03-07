package test.security.jwt.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 用户 Authentication
 *
 * @date 2020-08-04
 */
@Service
@Slf4j
public class SysUserDetailServiceImpl implements UserDetailsService {


  /**
   * 根据用户名验证用户名密码是否正确，这里是写死的用户名和密码，以及权限编码
   * 正常使用时，应该从数据库中查询用户信息，包括用户名、密码、权限编码
   * @param username
   * @return
   * @throws UsernameNotFoundException
   */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    SysUserDetails.SysUserDetailsBuilder builder = SysUserDetails.builder();
    builder.id(1L).username("admin").password("123456");

    SysPermissionDO per1 = SysPermissionDO.builder().code("code1").build();
    SysPermissionDO per2 = SysPermissionDO.builder().code("code2").build();
    SysPermissionDO per3 = SysPermissionDO.builder().code("code3").build();
    List<SysPermissionDO> permissionList = new ArrayList<>();
    permissionList.add(per1);
    permissionList.add(per2);
    permissionList.add(per3);

    permissionList.stream()
            .map(SysPermissionDO::getCode)
            .map(SysUserDetails::authority)
            .filter(Objects::nonNull)
            .forEach(builder::authority); // 得益于@Singular注解，可以直接使用addAuthority方法

    return builder.build();

  }
}
