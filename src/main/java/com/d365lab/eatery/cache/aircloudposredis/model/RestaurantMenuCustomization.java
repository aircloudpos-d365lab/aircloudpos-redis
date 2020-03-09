package com.d365lab.eatery.cache.aircloudposredis.model;

import java.util.Date;


public class RestaurantMenuCustomization {

    private Integer restaurantMenuCustomizationId;
    private String restaurantTenantId;
    private Integer restaurantMenuId;
    private String restaurantMenuCustomizationDescription;
    private Date createdAt;
    private Date updatedAt;

    public RestaurantMenuCustomization() {
    }

    public RestaurantMenuCustomization(Integer restaurantMenuCustomizationId, String restaurantTenantId, Integer restaurantMenuId, String restaurantMenuCustomizationDescription, Date createdAt, Date updatedAt) {
        this.restaurantMenuCustomizationId = restaurantMenuCustomizationId;
        this.restaurantTenantId = restaurantTenantId;
        this.restaurantMenuId = restaurantMenuId;
        this.restaurantMenuCustomizationDescription = restaurantMenuCustomizationDescription;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getRestaurantMenuCustomizationId() {
        return restaurantMenuCustomizationId;
    }

    public void setRestaurantMenuCustomizationId(Integer restaurantMenuCustomizationId) {
        this.restaurantMenuCustomizationId = restaurantMenuCustomizationId;
    }

    public String getRestaurantTenantId() {
        return restaurantTenantId;
    }

    public void setRestaurantTenantId(String restaurantTenantId) {
        this.restaurantTenantId = restaurantTenantId;
    }

    public Integer getRestaurantMenuId() {
        return restaurantMenuId;
    }

    public void setRestaurantMenuId(Integer restaurantMenuId) {
        this.restaurantMenuId = restaurantMenuId;
    }

    public String getRestaurantMenuCustomizationDescription() {
        return restaurantMenuCustomizationDescription;
    }

    public void setRestaurantMenuCustomizationDescription(String restaurantMenuCustomizationDescription) {
        this.restaurantMenuCustomizationDescription = restaurantMenuCustomizationDescription;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
