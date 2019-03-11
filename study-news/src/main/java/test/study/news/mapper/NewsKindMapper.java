package test.study.news.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import test.study.news.dto.InKindListDto;
import test.study.news.dto.OutKindInfoDto;
import test.study.news.entity.NewsKind;

import java.util.List;

/**
 * Created by dell on 2019/3/11.
 * @author dell
 */
@Mapper
public interface NewsKindMapper extends BaseMapper<NewsKind>{

    /**
     * 分页查询新闻种类
     * @param page
     * @param inKindListDto
     * @return
     */
    List<OutKindInfoDto> getKindList(Page page, @Param("dto") InKindListDto inKindListDto);
}
