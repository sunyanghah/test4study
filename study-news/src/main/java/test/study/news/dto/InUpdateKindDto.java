package test.study.news.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by dell on 2019/3/11.
 * @author dell
 */
@Data
public class InUpdateKindDto extends InAddKindDto{
    @NotNull
    private Long id;
}
