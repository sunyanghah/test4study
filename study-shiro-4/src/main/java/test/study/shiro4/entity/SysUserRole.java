package test.study.shiro4.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户角色关系
 * @author sunYang
 * @date 2021/10/12 10:08
 */
@Data
@TableName("sys_user_role")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysUserRole {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 角色ID
     */
    private String roleId;

}
