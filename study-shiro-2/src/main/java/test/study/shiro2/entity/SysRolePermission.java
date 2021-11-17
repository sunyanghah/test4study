package test.study.shiro2.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色权限关系
 * @author sunYang
 * @date 2021/10/12 10:06
 */
@Data
@TableName("sys_role_permission")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysRolePermission {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 权限ID
     */
    private String permissionId;
}
