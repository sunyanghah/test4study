package study.mysql.service.impl;

import study.mysql.entity.ClassTeacher;
import study.mysql.mapper.ClassTeacherMapper;
import study.mysql.service.IClassTeacherService;
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
public class ClassTeacherServiceImpl extends ServiceImpl<ClassTeacherMapper, ClassTeacher> implements IClassTeacherService {

}
