package test.study.datasources.service;

import java.util.List;
import java.util.Map;

/**
 * @author sunYang
 * @date 2022/1/7 13:55
 */
public interface TestService {

    List<? extends Object> testQuery();

    void testUpdate();

}
