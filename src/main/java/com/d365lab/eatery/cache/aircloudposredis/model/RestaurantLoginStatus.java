package com.d365lab.eatery.cache.aircloudposredis.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class RestaurantLoginStatus implements Serializable {
    private String restaurantUserName;
    private String restaurantOutletTenantId;
    private Integer restaurantUserLoginStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "EEE MMM dd HH:mm:ss Z yyyy")
    private Date restaurantUserLastLoggedInAt;

    public RestaurantLoginStatus() {
    }

    public RestaurantLoginStatus(String restaurantUserName, String restaurantOutletTenantId, Integer restaurantUserLoginStatus, Date restaurantUserLastLoggedInAt) {
        this.restaurantUserName = restaurantUserName;
        this.restaurantOutletTenantId = restaurantOutletTenantId;
        this.restaurantUserLoginStatus = restaurantUserLoginStatus;
        this.restaurantUserLastLoggedInAt = restaurantUserLastLoggedInAt;
    }

    public String getRestaurantUserName() {
        return restaurantUserName;
    }

    public void setRestaurantUserName(String restaurantUserName) {
        this.restaurantUserName = restaurantUserName;
    }

    public String getRestaurantOutletTenantId() {
        return restaurantOutletTenantId;
    }

    public void setRestaurantOutletTenantId(String restaurantOutletTenantId) {
        this.restaurantOutletTenantId = restaurantOutletTenantId;
    }

    public Integer getRestaurantUserLoginStatus() {
        return restaurantUserLoginStatus;
    }

    public void setRestaurantUserLoginStatus(Integer restaurantUserLoginStatus) {
        this.restaurantUserLoginStatus = restaurantUserLoginStatus;
    }

    public Date getRestaurantUserLastLoggedInAt() {
        return restaurantUserLastLoggedInAt;
    }

    public void setRestaurantUserLastLoggedInAt(Date restaurantUserLastLoggedInAt) {
        this.restaurantUserLastLoggedInAt = restaurantUserLastLoggedInAt;
    }
}
