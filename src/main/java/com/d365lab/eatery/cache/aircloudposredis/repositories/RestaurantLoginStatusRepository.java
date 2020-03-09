package com.d365lab.eatery.cache.aircloudposredis.repositories;

import com.d365lab.eatery.cache.aircloudposredis.model.RestaurantLoginStatus;
import com.d365lab.eatery.cache.aircloudposredis.model.TemporaryCart;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface RestaurantLoginStatusRepository {
    void save(RestaurantLoginStatus restaurantLoginStatus);

    Map<String, RestaurantLoginStatus> findAll();

    RestaurantLoginStatus findById(String id);

    void update(RestaurantLoginStatus restaurantLoginStatus);

    void delete(String id);
}
