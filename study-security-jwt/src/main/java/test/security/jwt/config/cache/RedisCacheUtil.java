package test.security.jwt.config.cache;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * redis缓存
 * @author sunYang
 * @date 2021/12/27 14:15
 */
@Component
@ConditionalOnBean(ClusterConditionBean.class)
public class RedisCacheUtil<T> implements CacheUtil<T> {

    @Resource
    private RedisTemplate<String,T> redisTemplate;

    @Override
    public void set(String key, T value) {
        redisTemplate.opsForValue().set(key, value);
        System.out.println("redis set");
    }

    @Override
    public T get(String key) {
        redisTemplate.opsForValue().get(key);
        return null;
    }

    @Override
    public void set(String key, T value, Long timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key,value,timeout,TimeUnit.SECONDS);
    }

    public boolean hasKey(String key){
        return redisTemplate.hasKey(key);
    }

}
