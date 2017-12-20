package com.chen.springbootjparedisdemo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.lang.reflect.Method;


/**
 * 配置参考:
 * http://blog.csdn.net/yy756127197/article/details/75092236
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisConfig.class);

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private Integer port;
    @Value("${spring.redis.password}")
    private String password;


    @Bean
    public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        redisCacheManager.setDefaultExpiration(60);
        return redisCacheManager;
    }

    @Bean
    public RedisTemplate<Serializable, Serializable> redisTemplate(JedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Serializable, Serializable> template = new RedisTemplate<>();
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//
//
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setHashKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(new JdkSerializationRedisSerializer());
//        template.setHashValueSerializer(new JdkSerializationRedisSerializer());

        template.setConnectionFactory(redisConnectionFactory);
//        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
        redisConnectionFactory.setHostName(host);
        redisConnectionFactory.setPort(port);
//        redisConnectionFactory.setPassword(password);
        LOGGER.info("JedisConnectionFactory initial at " + host + ":" + port);
        return redisConnectionFactory;
    }


    @Bean
    public KeyGenerator keyGenerator() {
        LOGGER.info("keyGenerator load ...");
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(target.getClass().getName());
                stringBuilder.append(method.getName());
                for (Object obj : params) {
                    stringBuilder.append(obj.toString());
                }
                LOGGER.info("keyGenerator = " + stringBuilder.toString());
                return stringBuilder.toString();
            }
        };
    }


}

