package test.study.datasources3.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sunYang
 * @date 2022/1/7 13:57
 */
@TableName("test_0105")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Test0105 {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer amount;

    private String description;


}
