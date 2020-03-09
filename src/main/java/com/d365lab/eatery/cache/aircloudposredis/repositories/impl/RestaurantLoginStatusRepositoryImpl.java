package com.d365lab.eatery.cache.aircloudposredis.repositories.impl;

import com.d365lab.eatery.cache.aircloudposredis.model.RestaurantLoginStatus;
import com.d365lab.eatery.cache.aircloudposredis.repositories.RestaurantLoginStatusRepository;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class RestaurantLoginStatusRepositoryImpl implements RestaurantLoginStatusRepository {

    private RedisTemplate<String, RestaurantLoginStatus> redisRestaurantLoginStatusTemplate;
    private HashOperations hashOperations;

    public RestaurantLoginStatusRepositoryImpl(RedisTemplate<String, RestaurantLoginStatus> redisRestaurantLoginStatusTemplate) {
        this.redisRestaurantLoginStatusTemplate = redisRestaurantLoginStatusTemplate;
        hashOperations = redisRestaurantLoginStatusTemplate.opsForHash();
    }

    @Override
    public void save(RestaurantLoginStatus restaurantLoginStatus) {
        hashOperations.put("RESTAURANT_USER_LOGIN_STATUS", restaurantLoginStatus.getRestaurantOutletTenantId()+"_"+restaurantLoginStatus.getRestaurantUserName(), restaurantLoginStatus);
    }

    @Override
    public Map<String, RestaurantLoginStatus> findAll() {
        return hashOperations.entries("RESTAURANT_USER_LOGIN_STATUS");
    }

    @Override
    public RestaurantLoginStatus findById(String id) {
        return (RestaurantLoginStatus)hashOperations.get("RESTAURANT_USER_LOGIN_STATUS", id);
    }

    @Override
    public void update(RestaurantLoginStatus restaurantLoginStatus) {
        save(restaurantLoginStatus);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete("RESTAURANT_USER_LOGIN_STATUS", id);
    }
}
