package com.d365lab.eatery.cache.aircloudposredis.model;

public class CustomerInfo {

    private Integer customerId;
    private String customerTenantId;
    private String customerPrimaryContactNo;
    private String customerSecondaryContactNo;
    private String customerName;
    private String customerEmail;
    private String customerAddressType;
    private String customerAddress;
    private String restaurantTenantId;

    public CustomerInfo() {
    }

    public CustomerInfo(Integer customerId, String customerTenantId, String customerPrimaryContactNo, String customerSecondaryContactNo, String customerName, String customerEmail, String customerAddressType, String customerAddress, String restaurantTenantId) {
        this.customerId = customerId;
        this.customerTenantId = customerTenantId;
        this.customerPrimaryContactNo = customerPrimaryContactNo;
        this.customerSecondaryContactNo = customerSecondaryContactNo;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerAddressType = customerAddressType;
        this.customerAddress = customerAddress;
        this.restaurantTenantId = restaurantTenantId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerTenantId() {
        return customerTenantId;
    }

    public void setCustomerTenantId(String customerTenantId) {
        this.customerTenantId = customerTenantId;
    }

    public String getCustomerPrimaryContactNo() {
        return customerPrimaryContactNo;
    }

    public void setCustomerPrimaryContactNo(String customerPrimaryContactNo) {
        this.customerPrimaryContactNo = customerPrimaryContactNo;
    }

    public String getCustomerSecondaryContactNo() {
        return customerSecondaryContactNo;
    }

    public void setCustomerSecondaryContactNo(String customerSecondaryContactNo) {
        this.customerSecondaryContactNo = customerSecondaryContactNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddressType() {
        return customerAddressType;
    }

    public void setCustomerAddressType(String customerAddressType) {
        this.customerAddressType = customerAddressType;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getRestaurantTenantId() {
        return restaurantTenantId;
    }

    public void setRestaurantTenantId(String restaurantTenantId) {
        this.restaurantTenantId = restaurantTenantId;
    }
}
