package test.study.clickhouse.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.study.clickhouse.config.IdGenerator;
import test.study.clickhouse.dao.ClassMergeTreeDao;
import test.study.clickhouse.dto.ClassDto;
import test.study.clickhouse.dto.ClassStudentDto;
import test.study.clickhouse.entity.ClassMergeTree;
import test.study.clickhouse.service.TestService;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunYang
 * @date 2022/1/6 16:46
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private IdGenerator idGenerator;
    @Resource
    private ClassMergeTreeDao classMergeTreeDao;

    @Override
    public List<ClassDto> testQuery() {
        List<ClassMergeTree> classList = classMergeTreeDao.selectList(Wrappers.emptyWrapper());
        List<ClassDto> dtoList = classList.stream()
                .map(c -> {
                    ClassDto classDto = new ClassDto();
                    classDto.setId(c.getId());
                    classDto.setName(c.getName());
                    return classDto;
                }).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public List<ClassStudentDto> testQuery2() {
        return classMergeTreeDao.testQuery2();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void testEdit(ClassDto classDto) {
        ClassMergeTree classMergeTree = ClassMergeTree.builder()
                .id(classDto.getId())
                .name(classDto.getName())
                .build();
        classMergeTreeDao.updateById(classMergeTree);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String testAdd(ClassDto classDto) {

        String classId = idGenerator.nextStr();
        ClassMergeTree classMergeTree = ClassMergeTree.builder()
                .id(classId)
                .name(classDto.getName())
                .build();
        classMergeTreeDao.insert(classMergeTree);
        return classId;
    }

}
