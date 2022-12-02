package test.study.fastdfs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author sunYang
 * @date 2022/6/14 14:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DevelopmentValue extends BaseEntity {

    /**
     * 所属开发主表
     */
    private Long developmentId;

    /**
     * 文件名
     */
    private String name;

    /**
     * 代码
     */
    private String code;

    /**
     * 父节点
     */
    private Long pid;

    /**
     * 文件类型 1 file 2 image 3 video 4 folder
     */
    private Integer type;

    /**
     * 文件地址
     */
    private Integer fileId;

    /**
     * 文件地址（新）
     */
    private String filePath;

    /**
     * 状态
     */
    private Integer state;

}
