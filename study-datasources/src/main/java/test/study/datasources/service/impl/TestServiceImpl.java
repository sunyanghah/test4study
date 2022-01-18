package test.study.datasources.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.study.datasources.config.IdGenerator;
import test.study.datasources.config.datasource.TargetDataSource;
import test.study.datasources.dao.LineDao;
import test.study.datasources.dao.Test0105Dao;
import test.study.datasources.dao.Test1208Dao;
import test.study.datasources.entity.Line;
import test.study.datasources.entity.Test0105;
import test.study.datasources.entity.Test1208;
import test.study.datasources.service.TestService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunYang
 * @date 2022/1/7 13:56
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private Test0105Dao test0105Dao;
    @Resource
    private Test1208Dao test1208Dao;
    @Resource
    private LineDao lineDao;
    @Resource
    private IdGenerator idGenerator;

    @Override
    public List<? extends Object> testQuery() {

        List<Object> result = new ArrayList<>();

        result.addAll(query1());
        result.addAll(query2());

        return result;
    }

    /**
     * 同一库内的事务是生效的
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void testUpdate() {
        Test0105 test0105 = Test0105.builder()
                .id(1)
                .name("张三")
                .amount(100)
                .description(idGenerator.nextStr())
                .build();
        test0105Dao.updateById(test0105);

        Test1208 test1208 = Test1208.builder()
                .id(8)
                .code("ziranxuanze")
                .rate("4")
                .time("1500790703004")
                .tttt(idGenerator.nextStr())
                .vvvv(idGenerator.nextStr())
                .build();
        test1208Dao.updateById(test1208);

        System.out.println(1/0);

    }

    /**
     * 不起作用，不会进到aspect中
     * @author sunYang
     * @param
     * @return java.util.List<test.study.datasources.entity.Test0105>
     * @date 2022/1/7 18:06
     */
    @TargetDataSource(name = "test0105")
    private List<Test0105> query1(){
        List<Test0105> test0105List = test0105Dao.selectList(Wrappers.emptyWrapper());
        return test0105List;
    }

    /**
     * 不起作用，不会进到aspect中
     * @author sunYang
     * @param
     * @return java.util.List<test.study.datasources.entity.Line>
     * @date 2022/1/7 18:07
     */
    @TargetDataSource(name = "line")
    private List<Line> query2(){
        List<Line> lineList = lineDao.selectList(Wrappers.emptyWrapper());

        return lineList;
    }

}
