package test.study.java.decorator;

import java.util.Map;

/**
 * @author sun yang
 * @date 2023/11/27
 */
public class StrategyBuilder {

    private Strategy strategy;

    public StrategyBuilder(Strategy strategy) {
        this.strategy = strategy;
    }

    public static StrategyBuilder create() {
        return new StrategyBuilder(new ActionStrategy());
    }

    public StrategyBuilder with(Strategy strategy) {
        strategy.setStrategy(this.strategy);
        this.strategy = strategy;
        return this;
    }

    public StrategyBuilder withAll(){
        return this.with(new DeviceStrategyDecorator())
                .with(new AccessStrategyDecorator());
    }

    public Map<String, Object> getConfig() {
        return strategy.getConfig();
    }

}
