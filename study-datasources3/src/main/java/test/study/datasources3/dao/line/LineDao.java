package test.study.datasources3.dao.line;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import test.study.datasources3.entity.Line;

/**
 * @author sunYang
 * @date 2022/1/7 16:52
 */
@Mapper
public interface LineDao extends BaseMapper<Line> {
}
