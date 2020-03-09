package com.d365lab.eatery.cache.aircloudposredis.controllers;

import com.d365lab.eatery.cache.aircloudposredis.model.CartItem;
import com.d365lab.eatery.cache.aircloudposredis.model.TemporaryCart;
import com.d365lab.eatery.cache.aircloudposredis.repositories.TemporaryCartRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/cache/temporary/cart")
public class TemporaryCartResourceController {

    private TemporaryCartRepository temporaryCartRepository;

    public TemporaryCartResourceController(TemporaryCartRepository temporaryCartRepository) {
        this.temporaryCartRepository = temporaryCartRepository;
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/add/{id}", consumes = "application/json", produces = "application/json")
    public TemporaryCart add(@PathVariable("id") final String id,
                             @RequestBody TemporaryCart temporaryCartToPersistInRedis) {
        List<CartItem> cartMenuListForNonZeroQuantity = new ArrayList<>();
        temporaryCartToPersistInRedis.getcartMenuList().stream().forEach(cartItem -> {
            if (cartItem.getCartRestaurantMenuQty() > 0) {
                cartMenuListForNonZeroQuantity.add(cartItem);
            }
        });
        TemporaryCart cartWithOnlyNonZeroItem = new TemporaryCart(id, cartMenuListForNonZeroQuantity);
        temporaryCartRepository.save(cartWithOnlyNonZeroItem);
        return temporaryCartRepository.findById(id);
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/update/{id}")
    public TemporaryCart update(@PathVariable("id") final String id,
                                @RequestBody TemporaryCart temporaryCartToPersistInRedis) {
        List<CartItem> cartMenuListForNonZeroQuantity = new ArrayList<>();
        temporaryCartToPersistInRedis.getcartMenuList().stream().forEach(cartItem -> {
            if (cartItem.getCartRestaurantMenuQty() > 0) {
                cartMenuListForNonZeroQuantity.add(cartItem);
            }
        });
        TemporaryCart cartWithOnlyNonZeroItem = new TemporaryCart(id, cartMenuListForNonZeroQuantity);
        temporaryCartRepository.update(cartWithOnlyNonZeroItem);
        return temporaryCartRepository.findById(id);
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public TemporaryCart getSingleCart(@PathVariable("id") final String id) {
        return temporaryCartRepository.findById(id);
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") final String id) {
        temporaryCartRepository.delete(id);
        return new String("Success");
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public Map<String, TemporaryCart> all() {
        return temporaryCartRepository.findAll();
    }
}

