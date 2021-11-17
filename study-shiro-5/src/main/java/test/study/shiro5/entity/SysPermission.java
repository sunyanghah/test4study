package test.study.shiro5.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 资源
 * @author sunYang
 * @date 2021/10/12 9:54
 */
@Data
@TableName("sys_permission")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysPermission {

    /**
     * 主键id
     */
    private String id;

    /**
     * code
     */
    private String code;

    /**
     * 父级id
     */
    private String parentId;

    /**
     * 功能名称
     */
    private String name;

    /**
     * 请求路径
     */
    private String url;

    /**
     * 图标
     */
    private String icon;

    /**
     * 路由路径
     */
    private String path;

    /**
     * 权限类型(1 菜单 2按钮）
     */
    private Integer type;

    /**
     * 显示顺序
     */
    private Integer sort;

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
