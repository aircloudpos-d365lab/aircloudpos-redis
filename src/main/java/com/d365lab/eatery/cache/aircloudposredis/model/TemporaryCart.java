package com.d365lab.eatery.cache.aircloudposredis.model;

import java.io.Serializable;
import java.util.List;

public class TemporaryCart implements Serializable {
    private String id;
    private List<CartItem> cartMenuList;

    public TemporaryCart() {
    }

    public TemporaryCart(String id, List<CartItem> cartMenuList) {
        this.id = id;
        this.cartMenuList = cartMenuList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<CartItem> getcartMenuList() {
        return cartMenuList;
    }

    public void setcartMenuList(List<CartItem> cartMenuList) {
        this.cartMenuList = cartMenuList;
    }
}
