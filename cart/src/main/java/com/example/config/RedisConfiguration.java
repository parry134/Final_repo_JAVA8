package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.model.ItemLine;

@Configuration
public class RedisConfiguration {
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
	    return new JedisConnectionFactory();
	}
	
	@Bean
	public RedisTemplate<String, ItemLine> redisTemplate() {
	    final RedisTemplate<String, ItemLine> template = new RedisTemplate<String, ItemLine>();
	    template.setConnectionFactory(jedisConnectionFactory());
	    return template;
	}

}
