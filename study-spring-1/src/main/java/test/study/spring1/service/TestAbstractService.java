package test.study.spring1.service;

/**
 * @author sunYang
 * @Date 2021-03-26
 */
public interface TestAbstractService extends TestServiceExtendService {
    String getInfo();

    default void otherMethod(){};
}
