package test.study.datasources2.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import test.study.datasources2.dto.ClassStudentDto;
import test.study.datasources2.entity.ClassMergeTree;

import java.util.List;

/**
 * @author sunYang
 * @date 2022/1/6 17:01
 */
@Mapper
@DS("clickhouse")
public interface ClassMergeTreeDao extends BaseMapper<ClassMergeTree> {

    List<ClassStudentDto> testQuery2();

}
