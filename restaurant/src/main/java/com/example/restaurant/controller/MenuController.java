package com.example.restaurant.controller;

import com.example.restaurant.model.Menu;
import com.example.restaurant.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Menu>> getMenusByRestaurantId(@PathVariable Long restaurantId) {
        List<Menu> menus = menuService.getMenusByRestaurantId(restaurantId);
        return ResponseEntity.ok(menus);
    }

    @PostMapping("/restaurant/{restaurantId}")
    public ResponseEntity<Menu> createMenu(@PathVariable Long restaurantId, @Valid @RequestBody Menu menu) {
        Menu created = menuService.createMenu(restaurantId, menu);
        if (created != null) {
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
