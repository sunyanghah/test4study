package test.study.clickhouse.service;

import test.study.clickhouse.dto.ClassDto;
import test.study.clickhouse.dto.ClassStudentDto;

import java.util.List;

/**
 * @author sunYang
 * @date 2022/1/6 16:46
 */
public interface TestService {

    List<ClassDto> testQuery();

    List<ClassStudentDto> testQuery2();

    void testEdit(ClassDto classDto);

    String testAdd(ClassDto classDto);
}
