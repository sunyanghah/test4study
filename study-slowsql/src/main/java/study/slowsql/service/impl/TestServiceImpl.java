package study.slowsql.service.impl;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;
import study.slowsql.dao.TestDao;
import study.slowsql.dto.OutTestDto;
import study.slowsql.service.TestService;

import javax.annotation.Resource;

/**
 * @author sunYang
 * @date 2023/1/5 17:18
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestDao testDao;

    @Override
    public void test() {
        OutTestDto outTestDto = testDao.test();

        System.out.println(JSON.toJSONString(outTestDto));
    }
}
