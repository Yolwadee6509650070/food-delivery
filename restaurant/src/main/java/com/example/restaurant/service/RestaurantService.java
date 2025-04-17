package com.example.restaurant.service;

import com.example.restaurant.model.Restaurant;
import com.example.restaurant.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long id) {
        Optional<Restaurant> restaurantOpt = restaurantRepository.findById(id);
        return restaurantOpt.orElse(null);
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
}
