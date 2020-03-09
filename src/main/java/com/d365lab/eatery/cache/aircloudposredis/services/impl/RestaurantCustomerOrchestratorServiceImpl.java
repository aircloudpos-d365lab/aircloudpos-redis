package com.d365lab.eatery.cache.aircloudposredis.services.impl;

import com.d365lab.eatery.cache.aircloudposredis.model.MenuListOfARestaurant;
import com.d365lab.eatery.cache.aircloudposredis.model.RestaurantCustomerMap;
import com.d365lab.eatery.cache.aircloudposredis.model.RestaurantDetails;
import com.d365lab.eatery.cache.aircloudposredis.model.RestaurantMenuWithCustomization;
import com.d365lab.eatery.cache.aircloudposredis.repositories.CustomerInfoRepository;
import com.d365lab.eatery.cache.aircloudposredis.repositories.RestaurantMenuRepository;
import com.d365lab.eatery.cache.aircloudposredis.services.RestaurantCustomerOrchestratorService;
import com.d365lab.eatery.cache.aircloudposredis.utils.TrieImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static com.d365lab.eatery.cache.aircloudposredis.utils.CacheConstants.*;

@Service
public class RestaurantCustomerOrchestratorServiceImpl implements RestaurantCustomerOrchestratorService {

    private final Logger LOGGER = LoggerFactory.getLogger(RestaurantCustomerOrchestratorServiceImpl.class);

    @Autowired
    private RestaurantMenuRepository restaurantMenuRepository;

    @Autowired
    private CustomerInfoRepository customerInfoRepository;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public void buildMenuListTrie(String restaurantTenantId) {
        String fetchRestaurantMenuNameIdListUrl = RESTAURANT_CUSTOMER_ORCHESTRATOR_URL +
                RESTAURANT_DETAILS +
                "?" +
                RESTAURANT_TENANT_ID +
                "=" +
                restaurantTenantId;
        List<String> restaurantMenuNameAndIdSlashedList = new ArrayList<>();
        ResponseEntity<RestaurantDetails> result = null;
        try {
            result = restTemplate.getForEntity(new URI(fetchRestaurantMenuNameIdListUrl), RestaurantDetails.class);
        } catch (URISyntaxException e) {
            LOGGER.error("Exception:{} occurred while fetching restaurant-details from Restaurant-Customer-Orchestrator", e.getMessage());
        }
        if (result != null) {
            List<RestaurantMenuWithCustomization> menuWithCustomizationList = result.getBody().getMenuList();
            menuWithCustomizationList.stream().forEach(menu -> {
                String menuNameSlashId = menu.getRestaurantMenu().getRestaurantMenuName() +
                        "/" +
                        menu.getRestaurantMenu().getRestaurantMenuId().toString();
                restaurantMenuNameAndIdSlashedList.add(menuNameSlashId);
            });
        }
        MenuListOfARestaurant menuListOfARestaurant = new MenuListOfARestaurant(restaurantTenantId, restaurantMenuNameAndIdSlashedList);
        restaurantMenuRepository.save(menuListOfARestaurant);
        TrieImpl.getInstance("MENU").clear("MENU");
        TrieImpl.getInstance("MENU").insertAll(restaurantMenuNameAndIdSlashedList);
        TrieImpl.getInstance("MENU").printTrie();
    }

    @Override
    public void uploadCustomersForRestaurant(String restaurantTenantId) {
        String fetchCustomersForARestaurantURL = RESTAURANT_CUSTOMER_ORCHESTRATOR_URL +
                FETCH_CUSTOMER_LIST +
                "?" +
                RESTAURANT_TENANT_ID +
                "=" +
                restaurantTenantId;
        ResponseEntity<RestaurantCustomerMap> result = null;
        try {
            result = restTemplate.getForEntity(new URI(fetchCustomersForARestaurantURL), RestaurantCustomerMap.class);
        } catch (URISyntaxException e) {
            LOGGER.error("Exception:{} occurred while fetching restaurant-details from Restaurant-Customer-Orchestrator", e.getMessage());
        }
        if (result != null) {
            result.getBody().getCustomerInfoList().stream().forEach(
                    customerInfo -> {
                        customerInfoRepository.save(customerInfo);
                    }
            );
        }
    }

}
