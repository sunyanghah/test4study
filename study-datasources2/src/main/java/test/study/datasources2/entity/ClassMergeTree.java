package test.study.datasources2.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sunYang
 * @date 2022/1/6 16:59
 */
@TableName("class_merge_tree")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassMergeTree {

    @TableId("id")
    private String id;

    @TableField("name")
    private String name;

}
