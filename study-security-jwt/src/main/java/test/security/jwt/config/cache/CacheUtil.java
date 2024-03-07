package test.security.jwt.config.cache;

import java.util.concurrent.TimeUnit;

/**
 * 封装的缓存上层工具，基于当前是否配置Redis连接决定使用Redis还是内存缓存
 * 只是简单封装，实际使用时需要根据业务需求进行扩展
 * @author sunYang
 * @date 2021/12/27 14:06
 */
public interface CacheUtil<T> {

    void set(String key,T value);

    T get(String key);

    void set(String key, T value, Long timeout, TimeUnit timeUnit);

    boolean hasKey(String key);

}
