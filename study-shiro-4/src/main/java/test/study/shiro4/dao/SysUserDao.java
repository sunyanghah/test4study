package test.study.shiro4.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import test.study.shiro4.entity.SysPermission;
import test.study.shiro4.entity.SysRole;
import test.study.shiro4.entity.SysUser;

import java.util.List;

@Mapper
public interface SysUserDao extends BaseMapper<SysUser> {

    @Select("select * from sys_user where username = #{username}")
    SysUser getInfoByUsername(@Param("username") String username);

    @Select(" select " +
            " sr.* " +
            " from " +
            " sys_role sr " +
            " inner join " +
            " sys_user_role sur " +
            " on sr.id = sur.role_id " +
            " inner join " +
            " sys_user su" +
            " on su.id = sur.user_id " +
            " where " +
            " su.username = #{username} ")
    List<SysRole> getRoleListByUsername(@Param("username")String username);

    @Select(" select " +
            " sp.* " +
            " from " +
            " sys_permission sp " +
            " inner join " +
            " sys_role_permission srp " +
            " on sp.id = srp.permission_id " +
            " ")
    List<SysPermission> getPermissionListByUsername(@Param("username")String username);

}
