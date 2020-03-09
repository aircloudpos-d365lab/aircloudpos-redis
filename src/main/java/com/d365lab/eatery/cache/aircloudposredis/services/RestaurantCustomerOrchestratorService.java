package com.d365lab.eatery.cache.aircloudposredis.services;

import org.springframework.stereotype.Service;

@Service
public interface RestaurantCustomerOrchestratorService {
    public void buildMenuListTrie(String restaurantTenantId);
    public void uploadCustomersForRestaurant(String restaurantTenantId);
}
