package com.d365lab.eatery.cache.aircloudposredis.repositories;

import com.d365lab.eatery.cache.aircloudposredis.model.TemporaryCart;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface TemporaryCartRepository {
    void save(TemporaryCart temporaryCart);

    Map<String, TemporaryCart> findAll();

    TemporaryCart findById(String id);

    void update(TemporaryCart temporaryCart);

    void delete(String id);
}
