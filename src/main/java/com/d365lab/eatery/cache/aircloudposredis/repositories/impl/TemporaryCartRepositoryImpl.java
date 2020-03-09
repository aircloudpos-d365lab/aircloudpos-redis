package com.d365lab.eatery.cache.aircloudposredis.repositories.impl;

import com.d365lab.eatery.cache.aircloudposredis.model.TemporaryCart;
import com.d365lab.eatery.cache.aircloudposredis.repositories.TemporaryCartRepository;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class TemporaryCartRepositoryImpl implements TemporaryCartRepository {
    private RedisTemplate<String, TemporaryCart> redisCartTemplate;

    private HashOperations hashOperations;


    public TemporaryCartRepositoryImpl(RedisTemplate<String, TemporaryCart> redisCartTemplate) {
        this.redisCartTemplate = redisCartTemplate;
        hashOperations = redisCartTemplate.opsForHash();
    }

    @Override
    public void save(TemporaryCart temporaryCart) {
        hashOperations.put("CART", temporaryCart.getId(), temporaryCart);
    }

    @Override
    public Map<String, TemporaryCart> findAll() {
        return hashOperations.entries("CART");
    }

    @Override
    public TemporaryCart findById(String id) {
        return (TemporaryCart)hashOperations.get("CART", id);
    }

    @Override
    public void update(TemporaryCart temporaryCart) {
        save(temporaryCart);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete("CART", id);
    }

}
