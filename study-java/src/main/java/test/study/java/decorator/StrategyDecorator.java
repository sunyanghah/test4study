package test.study.java.decorator;

import java.util.Map;

/**
 * @author sun yang
 * @date 2023/11/27
 */
// 装饰者类
public abstract class StrategyDecorator implements Strategy {
    protected Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Map<String, Object> getConfig() {
        Map<String, Object> config = strategy.getConfig();
        // 添加额外的配置项
        return config;
    }
}
