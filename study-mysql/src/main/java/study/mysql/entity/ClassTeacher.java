package study.mysql.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author dell
 * @since 2020-12-18
 */
@Data
@TableName("class_teacher")
@EqualsAndHashCode(callSuper = false)
public class ClassTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.INPUT)
    private Long id;

    @TableField("class_id")
    private Long classId;

    @TableField("teacher_id")
    private Long teacherId;


}
