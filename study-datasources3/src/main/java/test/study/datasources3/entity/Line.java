package test.study.datasources3.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sunYang
 * @date 2022/1/7 16:50
 */
@TableName("line")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Line {

    @TableId(value = "lineid",type = IdType.INPUT)
    private String lineid;

    @TableField("linename")
    private String linename;

}
