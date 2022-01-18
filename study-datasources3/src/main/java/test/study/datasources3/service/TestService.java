package test.study.datasources3.service;

import java.util.List;

/**
 * @author sunYang
 * @date 2022/1/7 13:55
 */
public interface TestService {

    List<? extends Object> testQuery();

    void testUpdate();

    void testUpdate2();

}
