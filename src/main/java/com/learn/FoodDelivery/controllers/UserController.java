package com.learn.FoodDelivery.controllers;

import com.learn.FoodDelivery.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("hasAuthority('ADMIN')")
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;
    @DeleteMapping("{email}")
    public ResponseEntity<String> delete(
            @PathVariable String email
    ){
        userService.deleteUser(email);
        return ResponseEntity.ok("");
    }
}
