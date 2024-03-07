package test.study.java.decorator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sun yang
 * @date 2023/11/27
 */
// 具体策略实现
public class ActionStrategy implements Strategy {

    @Override
    public Map<String, Object> getConfig() {
        // 返回行为策略的具体配置项
        Map map = new HashMap();
        return map;
    }

    @Override
    public void setStrategy(Strategy strategy) {
    }

}
