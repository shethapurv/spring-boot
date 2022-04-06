package com.shethap.tech.rediscounterservice.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class JedisConfiguration {

    RedisProperties redisProperties;

    public JedisConfiguration(RedisProperties redisConfig) {
        this.redisProperties = redisConfig;
    }


    @Primary
    @Bean(name = "redis1ConnectionFactory")
    public RedisConnectionFactory redis1ConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(
                redisProperties.getHost(), redisProperties.getPort());
        return new JedisConnectionFactory(config);
    }

    @Bean(name = "redis1StringRedisTemplate")
    public StringRedisTemplate userStringRedisTemplate(@Qualifier("redis1ConnectionFactory") RedisConnectionFactory cf) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(cf);
        return stringRedisTemplate;
    }

    @Bean(name = "redis1RedisTemplate")
    public RedisTemplate userRedisTemplate(@Qualifier("redis1ConnectionFactory") RedisConnectionFactory cf) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(cf);
        //setSerializer(stringRedisTemplate);
        return stringRedisTemplate;
    }

}
