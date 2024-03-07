package test.study.java.decorator;

import java.util.Map;

/**
 * @author sun yang
 * @date 2023/11/27
 */
// 策略接口
public interface Strategy {

    Map<String, Object> getConfig();

    void setStrategy(Strategy strategy);

}
