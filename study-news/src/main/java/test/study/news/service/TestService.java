package test.study.news.service;

import com.baomidou.mybatisplus.extension.service.IService;
import test.study.news.dto.InAddKindDto;
import test.study.news.dto.InKindListDto;
import test.study.news.dto.InUpdateKindDto;
import test.study.news.dto.OutKindInfoDto;
import test.study.news.entity.NewsKind;
import test.study.news.entity.Test;

import java.util.List;

/**
 * Created by dell on 2019/3/11.
 * @author dell
 */
public interface TestService extends IService<Test>{

    /**
     * test
     * @throws Exception
     */
    void test() throws Exception;
}
