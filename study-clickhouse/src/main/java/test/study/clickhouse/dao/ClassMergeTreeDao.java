package test.study.clickhouse.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import test.study.clickhouse.dto.ClassStudentDto;
import test.study.clickhouse.entity.ClassMergeTree;

import java.util.List;

/**
 * @author sunYang
 * @date 2022/1/6 17:01
 */
@Mapper
public interface ClassMergeTreeDao extends BaseMapper<ClassMergeTree> {

    List<ClassStudentDto> testQuery2();

}
