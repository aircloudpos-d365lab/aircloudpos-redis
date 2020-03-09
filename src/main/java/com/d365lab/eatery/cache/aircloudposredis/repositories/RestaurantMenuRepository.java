package com.d365lab.eatery.cache.aircloudposredis.repositories;

import com.d365lab.eatery.cache.aircloudposredis.model.MenuListOfARestaurant;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface RestaurantMenuRepository {
    void save(MenuListOfARestaurant menuListOfARestaurant);

    Map<String, MenuListOfARestaurant> findAll();

    MenuListOfARestaurant findById(String id);

    void update(MenuListOfARestaurant menuListOfARestaurant);

    void delete(String id);
}
