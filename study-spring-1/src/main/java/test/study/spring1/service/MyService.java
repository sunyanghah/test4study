package test.study.spring1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.study.spring1.mapper.StudentMapper;
import test.study.spring1.mapper.TeacherMapper;

import javax.annotation.Resource;

/**
 * Created by dell on 2019/6/24.
 * @author dell
 */
@Service
public class MyService {

    @Resource(name = "studentMapperImpl2")
    private StudentMapper studentMapper;

    private TeacherMapper teacherMapper;

    public void test(){
        System.out.println("======================"+studentMapper.getNum());
    }

    public void testTeacher(){
        System.out.println("----------------"+teacherMapper.getTeacherNum());
    }
}
