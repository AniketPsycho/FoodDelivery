package com.learn.FoodDelivery.controllers;

import com.learn.FoodDelivery.config.security.isAdmin;
import com.learn.FoodDelivery.services.FoodService;
import com.learn.FoodDelivery.util.RegisterFoodRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/food")
public class FoodController {

    public final FoodService foodService;

    @GetMapping
    public ResponseEntity<List<RegisterFoodRequest>> getAllFood(){
        return ResponseEntity.ok(foodService.getAllFood());
    }


    @isAdmin
    @PostMapping
    public ResponseEntity<String> registerFood( @RequestBody RegisterFoodRequest request){
        foodService.registerFood(request);
        return ResponseEntity.ok("");
    }
}



