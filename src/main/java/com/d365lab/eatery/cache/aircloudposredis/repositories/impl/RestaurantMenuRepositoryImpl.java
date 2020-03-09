package com.d365lab.eatery.cache.aircloudposredis.repositories.impl;

import com.d365lab.eatery.cache.aircloudposredis.model.MenuListOfARestaurant;
import com.d365lab.eatery.cache.aircloudposredis.repositories.RestaurantMenuRepository;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class RestaurantMenuRepositoryImpl implements RestaurantMenuRepository {

    private RedisTemplate<String, MenuListOfARestaurant> redisMenuTemplate;
    private HashOperations hashOperations;

    public RestaurantMenuRepositoryImpl(RedisTemplate<String, MenuListOfARestaurant> redisMenuTemplate) {
        this.redisMenuTemplate = redisMenuTemplate;
        hashOperations = redisMenuTemplate.opsForHash();
    }

    @Override
    public void save(MenuListOfARestaurant menuListOfARestaurant) {
        hashOperations.put("MENU_NAME_AND_ID", menuListOfARestaurant.getRestaurantTenantId(), menuListOfARestaurant);
    }

    @Override
    public Map<String, MenuListOfARestaurant> findAll() {
        return hashOperations.entries("MENU_NAME_AND_ID");
    }

    @Override
    public MenuListOfARestaurant findById(String id) {
        return (MenuListOfARestaurant)hashOperations.get("MENU_NAME_AND_ID", id);
    }

    @Override
    public void update(MenuListOfARestaurant menuListOfARestaurant) {
        save(menuListOfARestaurant);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete("MENU_NAME_AND_ID", id);
    }
}
