package test.study.datasources2.service.impl;

import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.study.datasources2.config.IdGenerator;
import test.study.datasources2.dao.ClassMergeTreeDao;
import test.study.datasources2.dao.LineDao;
import test.study.datasources2.dao.Test0105Dao;
import test.study.datasources2.dao.Test1208Dao;
import test.study.datasources2.entity.ClassMergeTree;
import test.study.datasources2.entity.Line;
import test.study.datasources2.entity.Test0105;
import test.study.datasources2.entity.Test1208;
import test.study.datasources2.service.TestService;

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
    private ClassMergeTreeDao classMergeTreeDao;
    @Resource
    private IdGenerator idGenerator;

    @Override
    public List<? extends Object> testQuery() {

        List<Object> result = new ArrayList<>();
        List<Test0105> test0105List = test0105Dao.selectList(Wrappers.emptyWrapper());
        result.addAll(test0105List);

        List<Line> lineList = lineDao.selectList(Wrappers.emptyWrapper());
        result.addAll(lineList);

        List<ClassMergeTree> classMergeTrees = classMergeTreeDao.selectList(Wrappers.emptyWrapper());
        result.addAll(classMergeTrees);

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
    @DSTransactional
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
