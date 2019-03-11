package test.study.news.dto;

import lombok.Data;
import test.study.common.dto.InBasePageDto;

/**
 * Created by dell on 2019/3/11.
 * @author dell
 */
@Data
public class InKindListDto extends InBasePageDto{

    /**
     * 种类名称，模糊查询
     */
    private String kindName;
}
