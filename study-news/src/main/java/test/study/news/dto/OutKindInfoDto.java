package test.study.news.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by dell on 2019/3/11.
 * @author dell
 */
@Data
public class OutKindInfoDto {

    /**
     * 新闻分类主键
     */
    private Long id;

    /**
     * 新闻分类名称
     */
    private String kindName;

    /**
     * 新闻分类排序
     */
    private Double kindSort;

    /**
     * 新闻分类备注
     */
    private String kindRemark;


    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;
}
