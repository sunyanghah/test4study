package study.mysql.service.impl;

import study.mysql.entity.Student;
import study.mysql.mapper.StudentMapper;
import study.mysql.service.IStudentService;
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
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
