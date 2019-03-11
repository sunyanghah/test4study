package test.study.news.service;

import com.baomidou.mybatisplus.extension.service.IService;
import test.study.news.dto.InAddKindDto;
import test.study.news.dto.InKindListDto;
import test.study.news.dto.InUpdateKindDto;
import test.study.news.dto.OutKindInfoDto;
import test.study.news.entity.NewsKind;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by dell on 2019/3/11.
 * @author dell
 */
public interface NewsKindService extends IService<NewsKind>{

    /**
     * 查询新闻种类分页
     * @param inKindListDto
     * @return
     * @throws Exception
     */
    List<OutKindInfoDto> getKindList(InKindListDto inKindListDto) throws Exception;

    /**
     * 新增分类
     * @param inAddKindDto
     * @throws Exception
     */
    void addKind(InAddKindDto inAddKindDto) throws Exception;

    /**
     * 查询单条信息
     * @param id
     * @return
     * @throws Exception
     */
    OutKindInfoDto getKindInfo(Long id) throws Exception;

    /**
     * 修改
     * @param inUpdateKindDto
     * @throws Exception
     */
    void updateKind(InUpdateKindDto inUpdateKindDto) throws Exception;

    /**
     * 删除
     * @param id
     * @throws Exception
     */
    void deleteKind(Long id) throws Exception;
}
