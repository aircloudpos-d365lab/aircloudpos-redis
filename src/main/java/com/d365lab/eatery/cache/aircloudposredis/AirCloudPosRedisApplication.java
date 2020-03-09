package com.d365lab.eatery.cache.aircloudposredis;

import com.d365lab.eatery.cache.aircloudposredis.model.CustomerInfo;
import com.d365lab.eatery.cache.aircloudposredis.model.MenuListOfARestaurant;
import com.d365lab.eatery.cache.aircloudposredis.model.RestaurantLoginStatus;
import com.d365lab.eatery.cache.aircloudposredis.model.TemporaryCart;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class AirCloudPosRedisApplication {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jedisConFactory
				= new JedisConnectionFactory();
		jedisConFactory.setHostName("localhost");
		jedisConFactory.setPort(6379);
//		jedisConFactory.setUsePool(true);
		return jedisConFactory;
	}

	@Bean
	RedisTemplate<String, TemporaryCart> redisCartTemplate() {
		RedisTemplate<String, TemporaryCart> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
 	}

	@Bean
	RedisTemplate<String, MenuListOfARestaurant> redisMenuTemplate() {
		RedisTemplate<String, MenuListOfARestaurant> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}

	@Bean
	RedisTemplate<String, RestaurantLoginStatus> redisRestaurantLoginStatusTemplate() {
		RedisTemplate<String, RestaurantLoginStatus> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}

	@Bean
	RedisTemplate<String, CustomerInfo> redisCustomerInfoTemplate() {
		RedisTemplate<String, CustomerInfo> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}



	public static void main(String[] args) {
		SpringApplication.run(AirCloudPosRedisApplication.class, args);
	}
}
