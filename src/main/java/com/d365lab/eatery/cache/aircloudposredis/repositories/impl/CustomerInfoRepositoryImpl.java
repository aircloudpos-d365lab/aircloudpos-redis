package com.d365lab.eatery.cache.aircloudposredis.repositories.impl;

import com.d365lab.eatery.cache.aircloudposredis.model.CustomerInfo;
import com.d365lab.eatery.cache.aircloudposredis.model.MenuListOfARestaurant;
import com.d365lab.eatery.cache.aircloudposredis.repositories.CustomerInfoRepository;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CustomerInfoRepositoryImpl implements CustomerInfoRepository {

    private RedisTemplate<String, CustomerInfo> redisMenuTemplate;
    private HashOperations hashOperations;

    public CustomerInfoRepositoryImpl(RedisTemplate<String, CustomerInfo> redisMenuTemplate) {
        this.redisMenuTemplate = redisMenuTemplate;
        hashOperations = redisMenuTemplate.opsForHash();
    }


    @Override
    public void save(CustomerInfo customerInfo) {
        hashOperations.put("CUSTOMER", customerInfo.getCustomerPrimaryContactNo(), customerInfo);
    }

    @Override
    public Map<String, CustomerInfo> findAll() {
        return hashOperations.entries("CUSTOMER");
    }

    @Override
    public CustomerInfo findById(String id) {
        return (CustomerInfo)hashOperations.get("CUSTOMER", id);
    }

    @Override
    public void update(CustomerInfo customerInfo) {
        save(customerInfo);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete("CUSTOMER", id);
    }
}
