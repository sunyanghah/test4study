package test.study.news.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.study.common.platform.IdGenerator;
import test.study.news.dto.InAddKindDto;
import test.study.news.dto.InKindListDto;
import test.study.news.dto.InUpdateKindDto;
import test.study.news.dto.OutKindInfoDto;
import test.study.news.entity.NewsKind;
import test.study.news.mapper.NewsKindMapper;
import test.study.news.service.NewsKindService;

import java.util.List;

/**
 * Created by dell on 2019/3/11.
 * @author dell
 */
@Service
public class NewsKindServiceImpl extends ServiceImpl<NewsKindMapper,NewsKind> implements NewsKindService{

    @Autowired
    private NewsKindMapper newsKindMapper;
    @Autowired
    private IdGenerator idGenerator;

    @Override
    public List<OutKindInfoDto> getKindList(InKindListDto inKindListDto) throws Exception {
        Page page = new Page(inKindListDto.getCurrent(),inKindListDto.getSize());
        return newsKindMapper.getKindList(page,inKindListDto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addKind(InAddKindDto inAddKindDto) throws Exception {
        NewsKind newsKind = new NewsKind();
        BeanUtils.copyProperties(inAddKindDto,newsKind);
        newsKind.setId(idGenerator.next());
        // 创建人暂写死
        newsKind.preInsert("123");
        newsKindMapper.insert(newsKind);
    }

    @Override
    public OutKindInfoDto getKindInfo(Long id) throws Exception {
        NewsKind newsKind = newsKindMapper.selectById(id);
        if (newsKind != null) {
            OutKindInfoDto outKindInfoDto = new OutKindInfoDto();
            BeanUtils.copyProperties(newsKind,outKindInfoDto);
            return outKindInfoDto;
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateKind(InUpdateKindDto inUpdateKindDto) throws Exception {
        NewsKind newsKind = new NewsKind();
        BeanUtils.copyProperties(inUpdateKindDto,newsKind);
        newsKind.preUpdate("123");
        newsKindMapper.updateById(newsKind);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteKind(Long id) throws Exception {
        newsKindMapper.deleteById(id);
    }
}
