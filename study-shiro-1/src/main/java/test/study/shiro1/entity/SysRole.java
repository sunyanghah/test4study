package test.study.shiro1.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 角色
 * @author sunYang
 * @date 2021/10/12 9:59
 */
@Data
@TableName("sys_role")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysRole {

    /**
     * 角色ID
     */
    private String id;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人id
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;


}
