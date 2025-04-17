package com.example.restaurant.service;

import com.example.restaurant.model.Menu;
import com.example.restaurant.model.Restaurant;
import com.example.restaurant.repository.MenuRepository;
import com.example.restaurant.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    public MenuService(MenuRepository menuRepository, RestaurantRepository restaurantRepository) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public List<Menu> getMenusByRestaurantId(Long restaurantId) {
        Optional<Restaurant> restaurantOpt = restaurantRepository.findById(restaurantId);
        return restaurantOpt.map(Restaurant::getMenus).orElse(Collections.emptyList());
    }

    public Menu createMenu(Long restaurantId, Menu menu) {
        Optional<Restaurant> restaurantOpt = restaurantRepository.findById(restaurantId);
        return restaurantOpt.map(restaurant -> {
            menu.setRestaurant(restaurant);
            return menuRepository.save(menu);
        }).orElse(null);
    }
}
