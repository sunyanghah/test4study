package test.study.datasources3.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.study.datasources3.config.IdGenerator;
import test.study.datasources3.dao.line.LineDao;
import test.study.datasources3.dao.test0105.Test0105Dao;
import test.study.datasources3.dao.test0105.Test1208Dao;
import test.study.datasources3.entity.Line;
import test.study.datasources3.entity.Test0105;
import test.study.datasources3.entity.Test1208;
import test.study.datasources3.service.TestService;

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
    private LineDao lineDao;
    @Resource
    private Test0105Dao test0105Dao;
    @Resource
    private Test1208Dao test1208Dao;
    @Resource
    private IdGenerator idGenerator;

    @Override
    public List<? extends Object> testQuery() {

        List<Object> result = new ArrayList<>();

        List<Line> lineList = lineDao.selectList(Wrappers.emptyWrapper());
        result.addAll(lineList);

        List<Test0105> test0105List = test0105Dao.selectList(Wrappers.emptyWrapper());
        result.addAll(test0105List);

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void testUpdate2() {
        Test0105 test0105 = Test0105.builder()
                .id(1)
                .name("张三")
                .amount(100)
                .description(idGenerator.nextStr())
                .build();
        test0105Dao.updateById(test0105);

        Line line = Line.builder()
                .lineid("98")
                .linename("首都机场线" + idGenerator.nextStr())
                .build();
        lineDao.updateById(line);

        System.out.println(1/0);

        Test1208 test1208 = Test1208.builder()
                .id(8)
                .code("ziranxuanze")
                .rate("4")
                .time("1500790703004")
                .tttt(idGenerator.nextStr())
                .vvvv(idGenerator.nextStr())
                .build();
        test1208Dao.updateById(test1208);

    }

}
