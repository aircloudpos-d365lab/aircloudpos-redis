package com.d365lab.eatery.cache.aircloudposredis.model;

import java.io.Serializable;
import java.util.List;

public class MenuListOfARestaurant implements Serializable {

    private String restaurantTenantId;
    private List<String> restaurantMenuNameAndIdSeparatedBySlashList;

    public MenuListOfARestaurant() {
    }

    public MenuListOfARestaurant(String restaurantTenantId, List<String> restaurantMenuNameAndIdSeparatedBySlashList) {
        this.restaurantTenantId = restaurantTenantId;
        this.restaurantMenuNameAndIdSeparatedBySlashList = restaurantMenuNameAndIdSeparatedBySlashList;
    }

    public String getRestaurantTenantId() {
        return restaurantTenantId;
    }

    public void setRestaurantTenantId(String restaurantTenantId) {
        this.restaurantTenantId = restaurantTenantId;
    }

    public MenuListOfARestaurant(List<String> restaurantMenuNameAndIdSeparatedBySlashList) {
        this.restaurantMenuNameAndIdSeparatedBySlashList = restaurantMenuNameAndIdSeparatedBySlashList;
    }

    public List<String> getRestaurantMenuNameAndIdSeparatedBySlashList() {
        return restaurantMenuNameAndIdSeparatedBySlashList;
    }

    public void setRestaurantMenuNameAndIdSeparatedBySlashList(List<String> restaurantMenuNameAndIdSeparatedBySlashList) {
        this.restaurantMenuNameAndIdSeparatedBySlashList = restaurantMenuNameAndIdSeparatedBySlashList;
    }
}
