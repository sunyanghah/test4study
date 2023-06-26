package study.slowsql2.dao;

import org.apache.ibatis.annotations.Mapper;
import study.slowsql2.dto.OutTestDto;

/**
 * @author sunYang
 * @date 2023/1/5 17:18
 */
@Mapper
public interface TestDao {

    OutTestDto test();

}
