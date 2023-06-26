package test.study.statemachine.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author sunYang
 * @date 2023/5/24 10:23
 */
@TableName("tb_order")
@Data
public class Order {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String orderCode;

    private Integer status;

    private String name;

    private Double price;

    private Short deleteFlag;

    private Date createTime;

    private Date updateTime;

    private String createUserCode;

    private String updateUserCode;

    private int version;

    private String remark;

}
