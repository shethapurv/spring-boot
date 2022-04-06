package com.shethap.tech.rediscounterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@SpringBootApplication
public class RedisCounterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisCounterServiceApplication.class, args);
	}
}
