package test.study.spring1.mapper.impl;

import org.springframework.stereotype.Component;
import test.study.spring1.mapper.StudentMapper;

/**
 * Created by dell on 2019/6/24.
 */
@Component("studentMapperImpl2")
public class StudentMapperImpl2 implements StudentMapper {
    @Override
    public Integer getNum() {
        return 2;
    }
}
