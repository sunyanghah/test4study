package study.mysql.service.impl;

import study.mysql.entity.Grade;
import study.mysql.mapper.GradeMapper;
import study.mysql.service.IGradeService;
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
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade> implements IGradeService {

}
