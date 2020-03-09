package com.d365lab.eatery.cache.aircloudposredis.controllers;

import com.d365lab.eatery.cache.aircloudposredis.model.CustomerInfo;
import com.d365lab.eatery.cache.aircloudposredis.repositories.CustomerInfoRepository;
import com.d365lab.eatery.cache.aircloudposredis.repositories.TemporaryCartRepository;
import com.d365lab.eatery.cache.aircloudposredis.services.RestaurantCustomerOrchestratorService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/api/cache/customer")
public class CustomerSearchController {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomerSearchController.class);
    private static final Gson gson = new Gson();

    private CustomerInfoRepository customerInfoRepository;

    public CustomerSearchController(CustomerInfoRepository customerInfoRepository) {
        this.customerInfoRepository = customerInfoRepository;
    }

    @Autowired
    private RestaurantCustomerOrchestratorService restaurantCustomerOrchestratorService;

    @PostMapping(value="/upload-customer-list-into-cache-for-restaurant/{restaurant-tenant-id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> addAllCustomers(@PathVariable("restaurant-tenant-id") final String restaurantTenantId) {
        restaurantCustomerOrchestratorService.uploadCustomersForRestaurant(restaurantTenantId);
        return new ResponseEntity<String>(gson.toJson("Success"), HttpStatus.OK);
    }

    @RequestMapping(value = "/search-customer-by-mobile-for-restaurant/{restaurant-tenant-id}", method = RequestMethod.GET)
    public ResponseEntity<CustomerInfo> getCustomerDetails(@PathVariable("restaurant-tenant-id") final String restaurantTenantId,
                                                           @RequestParam("mobile_number") String customerMobileNumber) {
        CustomerInfo customerInfo = customerInfoRepository.findById(customerMobileNumber);
        if (customerInfo == null || customerInfo.getRestaurantTenantId().equalsIgnoreCase(restaurantTenantId)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<CustomerInfo>(customerInfo, HttpStatus.OK);
    }
}
