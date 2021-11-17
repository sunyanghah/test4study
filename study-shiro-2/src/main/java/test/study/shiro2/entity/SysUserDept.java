package test.study.shiro2.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户机构信息
 * @author sunYang
 * @date 2021/10/12 9:54
 */
@Data
@TableName("sys_user_dept")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysUserDept {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 机构ID
     */
    private String deptId;

}
