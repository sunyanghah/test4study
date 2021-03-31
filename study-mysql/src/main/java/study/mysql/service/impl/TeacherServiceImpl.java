package study.mysql.service.impl;

import study.mysql.entity.Teacher;
import study.mysql.mapper.TeacherMapper;
import study.mysql.service.ITeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dell
 * @since 2020-12-18
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

}
