package com.learn.FoodDelivery.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/csrf")
@CrossOrigin
public class CsrfController {

    @GetMapping
    public ResponseEntity<String> home(){
        return ResponseEntity.ok("");
    }
}
