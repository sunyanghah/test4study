package test.study.datasources.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import test.study.datasources.entity.Line;

/**
 * @author sunYang
 * @date 2022/1/7 16:52
 */
@Mapper
public interface LineDao extends BaseMapper<Line> {
}
