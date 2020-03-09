package com.d365lab.eatery.cache.aircloudposredis.controllers;

import com.d365lab.eatery.cache.aircloudposredis.repositories.TemporaryCartRepository;
import com.d365lab.eatery.cache.aircloudposredis.services.RestaurantCustomerOrchestratorService;
import com.d365lab.eatery.cache.aircloudposredis.utils.TrieImpl;
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
@RequestMapping("/api/cache/menu")
public class RestaurantMenuResourceController {

    private final Logger LOGGER = LoggerFactory.getLogger(RestaurantMenuResourceController.class);
    private static final Gson gson = new Gson();

    @Autowired
    private RestaurantCustomerOrchestratorService restaurantCustomerOrchestratorService;

    @PostMapping(value="/upload-menu-list-into-cache/{restaurant-tenant-id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> add(@PathVariable("restaurant-tenant-id") final String restaurantTenantId) {
        restaurantCustomerOrchestratorService.buildMenuListTrie(restaurantTenantId);
        return new ResponseEntity<String>(gson.toJson("Success"), HttpStatus.OK);
    }

    @RequestMapping(value = "/restaurant-menu-search/", method = RequestMethod.GET)
    public ResponseEntity<Set<String>> getRestaurantMenuForSearch(@RequestParam("menu_prefix") String menuPrefix) {
        return new ResponseEntity<>(TrieImpl.getInstance("MENU").prefixSearch(menuPrefix.toLowerCase()), HttpStatus.OK);
    }

}
