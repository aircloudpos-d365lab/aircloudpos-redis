package com.d365lab.eatery.cache.aircloudposredis.model;

import com.d365lab.eatery.cache.aircloudposredis.model.enums.RestaurantPaymentMode;

import java.util.Date;

public class RestaurantPaymentOptions {

    private Integer restaurantPaymentOptionId;
    private String restaurantTenantId;
    private RestaurantPaymentMode restaurantPaymentMode;
    private String restaurantQr;
    private Date createdAt;
    private Date updatedAt;

    public RestaurantPaymentOptions() {
    }

    public RestaurantPaymentOptions(Integer restaurantPaymentOptionId, String restaurantTenantId, RestaurantPaymentMode restaurantPaymentMode, String restaurantQr, Date createdAt, Date updatedAt) {
        this.restaurantPaymentOptionId = restaurantPaymentOptionId;
        this.restaurantTenantId = restaurantTenantId;
        this.restaurantPaymentMode = restaurantPaymentMode;
        this.restaurantQr = restaurantQr;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getRestaurantPaymentOptionId() {
        return restaurantPaymentOptionId;
    }

    public void setRestaurantPaymentOptionId(Integer restaurantPaymentOptionId) {
        this.restaurantPaymentOptionId = restaurantPaymentOptionId;
    }

    public String getRestaurantTenantId() {
        return restaurantTenantId;
    }

    public void setRestaurantTenantId(String restaurantTenantId) {
        this.restaurantTenantId = restaurantTenantId;
    }

    public RestaurantPaymentMode getRestaurantPaymentMode() {
        return restaurantPaymentMode;
    }

    public void setRestaurantPaymentMode(RestaurantPaymentMode restaurantPaymentMode) {
        this.restaurantPaymentMode = restaurantPaymentMode;
    }

    public String getRestaurantQr() {
        return restaurantQr;
    }

    public void setRestaurantQr(String restaurantQr) {
        this.restaurantQr = restaurantQr;
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
