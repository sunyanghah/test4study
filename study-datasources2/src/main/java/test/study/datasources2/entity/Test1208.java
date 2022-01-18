package test.study.datasources2.entity;

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
@TableName("test_1208")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Test1208 {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String code;

    private String rate;

    private String time;

    private String tttt;

    private String vvvv;


}
