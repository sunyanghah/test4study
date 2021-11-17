package test.study.shiro3.config;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class RedisCache <K, V> implements Cache<K, V> {

    private static Logger logger = LoggerFactory.getLogger(RedisCache.class);

    private String keyPrefix = RedisCacheManager.DEFAULT_CACHE_KEY_PREFIX;

    private RedisTemplate<String,Object> redisTemplate;

    /**
     *
     * @param prefix authorization prefix
     */
    public RedisCache(RedisTemplate<String,Object> redisTemplate,String prefix) {
        this.redisTemplate = redisTemplate;
        if (prefix != null && !"".equals(prefix)) {
            this.keyPrefix = prefix;
        }
    }

    /**
     * get shiro authorization redis key-value
     * @param key key
     * @return value
     * @throws CacheException get cache exception
     */
    @Override
    public V get(K key) throws CacheException {
        logger.debug("get key [" + key + "]");

        if (key == null) {
            return null;
        }

        V value = (V) redisTemplate.opsForValue().get(getRedisCacheKey(key));

        return value;

    }

    @Override
    public V put(K key, V value) throws CacheException {
        if (key == null) {
            logger.warn("Saving a null key is meaningless, return value directly without call Redis.");
            return value;
        }

        redisTemplate.opsForValue().set(getRedisCacheKey(key),value,20, TimeUnit.MINUTES);
        return value;

    }

    @Override
    public V remove(K key) throws CacheException {

        V value = (V)redisTemplate.opsForValue().get(getRedisCacheKey(key));
        redisTemplate.delete(getRedisCacheKey(key));
        return value;

    }

    /**
     * get the full Redis key including prefix by Redis key
     * @param key
     * @return
     */
    private String getRedisCacheKey(K key) {
        return this.keyPrefix + key;
    }


    @Override
    public void clear() throws CacheException {

        Set<String> keys = redisTemplate.keys(this.keyPrefix + "*");

        for (String key : keys) {
            redisTemplate.delete(key);
        }

    }

    /**
     * get all authorization key-value quantity
     * @return key-value size
     */
    @Override
    public int size() {
        Long longSize = 0L;

        Set<String> keys = redisTemplate.keys(this.keyPrefix + "*");

        if (keys == null){
            return 0;
        }
        return keys.size();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Set<K> keys() {

        Set<String> keys = redisTemplate.keys(this.keyPrefix + "*");

        if (CollectionUtils.isEmpty(keys)) {
            return Collections.emptySet();
        }

        Set<K> convertedKeys = new HashSet<K>();
        for (String key:keys) {
            convertedKeys.add((K) key);
        }
        return convertedKeys;
    }

    @Override
    public Collection<V> values() {

        Set<String> keys = redisTemplate.keys(this.keyPrefix + "*");

        if (CollectionUtils.isEmpty(keys)) {
            return Collections.emptySet();
        }

        List<V> values = new ArrayList<V>(keys.size());
        for (String key : keys) {
            V value = (V)redisTemplate.opsForValue().get(key);

            if (value != null) {
                values.add(value);
            }
        }
        return Collections.unmodifiableList(values);
    }

}
