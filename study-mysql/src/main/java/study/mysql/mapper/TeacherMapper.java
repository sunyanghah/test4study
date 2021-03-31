package study.mysql.mapper;

import org.apache.ibatis.annotations.Mapper;
import study.mysql.entity.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dell
 * @since 2020-12-18
 */
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

}
