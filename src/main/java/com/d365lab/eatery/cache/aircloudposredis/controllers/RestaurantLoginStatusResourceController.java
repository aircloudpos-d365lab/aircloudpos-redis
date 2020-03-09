package com.d365lab.eatery.cache.aircloudposredis.controllers;

import com.d365lab.eatery.cache.aircloudposredis.model.RestaurantLoginStatus;
import com.d365lab.eatery.cache.aircloudposredis.repositories.RestaurantLoginStatusRepository;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/cache/login/status")
public class RestaurantLoginStatusResourceController {

    private RestaurantLoginStatusRepository restaurantLoginStatusRepository;
    private static final Gson gson = new Gson();

    public RestaurantLoginStatusResourceController(RestaurantLoginStatusRepository restaurantLoginStatusRepository) {
        this.restaurantLoginStatusRepository = restaurantLoginStatusRepository;
    }

    @PostMapping(value="/add/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> add(@PathVariable("id") final String id,
                                      @RequestBody RestaurantLoginStatus restaurantLoginStatusToPersistInRedis) {
        restaurantLoginStatusRepository.save(restaurantLoginStatusToPersistInRedis);
        return new ResponseEntity<String>(gson.toJson("Success"), HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable("id") final String id,
                                @RequestBody RestaurantLoginStatus restaurantLoginStatusToPersistInRedis) {
        restaurantLoginStatusRepository.update(restaurantLoginStatusToPersistInRedis);
        return new ResponseEntity<String>(gson.toJson("Success"), HttpStatus.OK);
    }

    //    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public RestaurantLoginStatus getLoginStatusForUser(@PathVariable("id") final String id) {
        return restaurantLoginStatusRepository.findById(id);
    }


}
