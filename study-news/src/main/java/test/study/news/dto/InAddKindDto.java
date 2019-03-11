package test.study.news.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by dell on 2019/3/11.
 * @author dell
 */
@Data
public class InAddKindDto {

    @NotBlank
    private String kindName;

    private Double kindSort;

    private String kindRemark;
}
