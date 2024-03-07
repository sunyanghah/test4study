package test.security.jwt.config.cache;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @author sunYang
 * @date 2021/12/28 10:46
 */
@Component
@ConditionalOnProperty(name = "spring.redis.host")
public class ClusterConditionBean {
}
