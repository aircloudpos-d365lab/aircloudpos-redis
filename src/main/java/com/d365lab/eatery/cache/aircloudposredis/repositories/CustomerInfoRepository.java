package com.d365lab.eatery.cache.aircloudposredis.repositories;

import com.d365lab.eatery.cache.aircloudposredis.model.CustomerInfo;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface CustomerInfoRepository {

    void save(CustomerInfo customerInfo);

    Map<String, CustomerInfo> findAll();

    CustomerInfo findById(String id);

    void update(CustomerInfo customerInfo);

    void delete(String id);
}
