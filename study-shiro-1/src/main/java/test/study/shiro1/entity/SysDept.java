package test.study.shiro1.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 组织机构表
 * @author sunYang
 * @date 2021/10/12 9:54
 */
@Data
@TableName("sys_dept")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysDept {

    /**
     * 机构ID
     */
    private String id;

    /**
     * 机构名称
     */
    private String name;

    /**
     * 父机构ID
     */
    private String parentId;

    /**
     * 排序
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
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;


}
