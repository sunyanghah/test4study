package test.study.news.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import test.study.common.entity.BaseEntity;

/**
 * Created by dell on 2019/3/11.
 * @author dell
 */
@Data
@TableName("news_kind")
public class NewsKind extends BaseEntity {

    @TableId(value = "id",type = IdType.INPUT)
    private Long id;

    @TableField("kind_name")
    private String kindName;

    @TableField("kind_sort")
    private Double kindSort;

    @TableField("kind_remark")
    private String kindRemark;

}
