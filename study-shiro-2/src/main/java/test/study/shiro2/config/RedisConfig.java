package test.study.shiro2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    private StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

    @Bean
    public RedisTemplate redisTemplate(RedisTemplate redisTemplate){
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setDefaultSerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(stringRedisSerializer);
        return redisTemplate;
    }

}
