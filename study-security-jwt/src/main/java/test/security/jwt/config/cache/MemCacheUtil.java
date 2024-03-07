package test.security.jwt.config.cache;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;
import sun.security.util.Cache;

import java.util.concurrent.TimeUnit;

/**
 * 内存缓存
 * @author sunYang
 * @date 2021/12/27 14:13
 */
@Component
@ConditionalOnMissingBean(ClusterConditionBean.class)
public class MemCacheUtil<T> implements CacheUtil<T> {

    private Cache<String,T> cache = Cache.newHardMemoryCache(Short.MAX_VALUE);

    @Override
    public void set(String key, T value) {
        cache.put(key,value);
    }

    @Override
    public T get(String key) {
        return cache.get(key);
    }

    @Override
    @Deprecated
    public void set(String key, T value, Long timeout, TimeUnit timeUnit) {
        set(key,value);
        // TODO 暂未实现memCache的超时机制
    }

    public boolean hasKey(String key){
        return cache.get(key) != null;
    }

}
