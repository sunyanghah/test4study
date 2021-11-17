package test.study.shiro3.config;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RedisCacheManager implements CacheManager {

    private final Logger logger = LoggerFactory.getLogger(RedisCacheManager.class);

    // fast lookup by name map
    private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<>();

    // expire time in seconds
    public static final int DEFAULT_EXPIRE = 1800;
    private int expire = DEFAULT_EXPIRE;

    /**
     * The Redis key prefix for caches
     */
    public static final String DEFAULT_CACHE_KEY_PREFIX = "shiro:cache:";
    private String keyPrefix = DEFAULT_CACHE_KEY_PREFIX;

    public static final String DEFAULT_PRINCIPAL_ID_FIELD_NAME = "id";
    private String principalIdFieldName = DEFAULT_PRINCIPAL_ID_FIELD_NAME;

    private RedisTemplate<String,Object> redisTemplate;

    public RedisCacheManager(RedisTemplate<String,Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        logger.debug("get cache, name=" + name);

        Cache<K, V> cache = caches.get(name);

        if (cache == null) {
            cache = new RedisCache<K, V>( redisTemplate,keyPrefix + name + ":");
            caches.put(name, cache);
        }
        return cache;
    }

}
