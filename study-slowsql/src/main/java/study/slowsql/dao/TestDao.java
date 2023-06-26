package study.slowsql.dao;

import org.apache.ibatis.annotations.Mapper;
import study.slowsql.dto.OutTestDto;

/**
 * @author sunYang
 * @date 2023/1/5 17:18
 */
@Mapper
public interface TestDao {

    OutTestDto test();

}
