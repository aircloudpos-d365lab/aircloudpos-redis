package com.d365lab.eatery.cache.aircloudposredis.model;

import java.util.List;

public class RestaurantMenuWithCustomization {

    private RestaurantMenu restaurantMenu;
    private List<RestaurantMenuCustomization> restaurantMenuCustomizationList;

    public RestaurantMenuWithCustomization() {
    }

    public RestaurantMenuWithCustomization(RestaurantMenu restaurantMenu, List<RestaurantMenuCustomization> restaurantMenuCustomizationList) {
        this.restaurantMenu = restaurantMenu;
        this.restaurantMenuCustomizationList = restaurantMenuCustomizationList;
    }

    public RestaurantMenu getRestaurantMenu() {
        return restaurantMenu;
    }

    public void setRestaurantMenu(RestaurantMenu restaurantMenu) {
        this.restaurantMenu = restaurantMenu;
    }

    public List<RestaurantMenuCustomization> getRestaurantMenuCustomizationList() {
        return restaurantMenuCustomizationList;
    }

    public void setRestaurantMenuCustomizationList(List<RestaurantMenuCustomization> restaurantMenuCustomizationList) {
        this.restaurantMenuCustomizationList = restaurantMenuCustomizationList;
    }
}
