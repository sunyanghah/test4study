package test.study.shiro5.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户信息
 * @author sunYang
 * @date 2021/10/12 10:08
 */
@Data
@TableName("sys_user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysUser {

    /**
     * 主键id
     */
    private String id;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 账号名称
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 账号状态  0-关闭 1-开启,参照常量SysUserConstants.UserStatus
     */
    private Integer status;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String description;

}
