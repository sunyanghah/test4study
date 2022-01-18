package test.study.datasources2.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import test.study.datasources2.entity.Line;

/**
 * @author sunYang
 * @date 2022/1/7 16:52
 */
@Mapper
@DS("line")
public interface LineDao extends BaseMapper<Line> {
}
