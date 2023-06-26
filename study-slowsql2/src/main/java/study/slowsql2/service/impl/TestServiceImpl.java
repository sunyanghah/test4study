package study.slowsql2.service.impl;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;
import study.slowsql2.dao.TestDao;
import study.slowsql2.dto.OutTestDto;
import study.slowsql2.service.TestService;

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
