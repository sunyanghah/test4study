package test.study.java.decorator;

import java.util.Map;

/**
 * @author sun yang
 * @date 2023/11/27
 */
// 具体装饰者类
public class DeviceStrategyDecorator extends StrategyDecorator {
    public DeviceStrategyDecorator() {
    }

    @Override
    public Map<String, Object> getConfig() {
        Map<String, Object> config = super.getConfig();
        // 添加设备策略的配置项
        config.put("device", "device");
        return config;
    }
}
