package test.study.shiro3.config;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import test.study.shiro3.dao.SysUserDao;
import test.study.shiro3.entity.SysPermission;
import test.study.shiro3.entity.SysRole;
import test.study.shiro3.entity.SysUser;

import javax.annotation.Resource;
import java.util.List;

public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private SysUserDao sysUserDao;

    /**
     * @MethodName doGetAuthorizationInfo
     * @Description 权限配置类
     * @Param [principalCollection]
     * @Return AuthorizationInfo
     * @Author WangShiLin
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String name = (String) principalCollection.getPrimaryPrincipal();
        //查询用户名称
        SysUser user = sysUserDao.getInfoByUsername(name);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        List<SysRole> roleList = sysUserDao.getRoleListByUsername(name);

        //添加角色
        for (SysRole role : roleList) {
            simpleAuthorizationInfo.addRole(role.getCode());
        }

        List<SysPermission> permissionList = sysUserDao.getPermissionListByUsername(name);

        //添加权限
        for (SysPermission permission : permissionList) {
            simpleAuthorizationInfo.addStringPermission(permission.getCode());
        }

        return simpleAuthorizationInfo;
    }

    /**
     * @MethodName doGetAuthenticationInfo
     * @Description 认证配置类
     * @Param [authenticationToken]
     * @Return AuthenticationInfo
     * @Author WangShiLin
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        String name = authenticationToken.getPrincipal().toString();
        SysUser user = sysUserDao.getInfoByUsername(name);
        if (user == null) {
            //这里返回后会报出对应异常
            return null;
        } else {

            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(JSON.toJSONString(user), user.getPassword(), getName());
            return simpleAuthenticationInfo;
        }
    }

}
