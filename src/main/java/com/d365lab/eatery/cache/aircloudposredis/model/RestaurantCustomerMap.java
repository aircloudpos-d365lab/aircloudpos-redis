package com.d365lab.eatery.cache.aircloudposredis.model;

import java.util.List;

public class RestaurantCustomerMap {
    private String restaurantTenantId;
    private List<CustomerInfo> customerInfoList;

    public RestaurantCustomerMap() {
    }

    public RestaurantCustomerMap(String restaurantTenantId, List<CustomerInfo> customerInfoList) {
        this.restaurantTenantId = restaurantTenantId;
        this.customerInfoList = customerInfoList;
    }

    public String getRestaurantTenantId() {
        return restaurantTenantId;
    }

    public void setRestaurantTenantId(String restaurantTenantId) {
        this.restaurantTenantId = restaurantTenantId;
    }

    public List<CustomerInfo> getCustomerInfoList() {
        return customerInfoList;
    }

    public void setCustomerInfoList(List<CustomerInfo> customerInfoList) {
        this.customerInfoList = customerInfoList;
    }

    @Override
    public String toString() {
        return "RestaurantCustomerMap{" +
                "restaurantTenantId='" + restaurantTenantId + '\'' +
                ", customerInfoList=" + customerInfoList +
                '}';
    }
}
