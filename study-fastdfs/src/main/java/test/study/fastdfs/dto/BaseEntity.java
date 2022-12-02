package test.study.fastdfs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * @author sunyang
 * @date 2022/6/9
 * @desc
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

    private Long id;

    private Long createId;

    private Date createDate;

    private Long updateId;

    private Date updateDate;

    private String description;

    private Integer state;

}
