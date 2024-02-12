package com.learn.FoodDelivery.controllers;

import com.learn.FoodDelivery.services.AuthenticationService;
import com.learn.FoodDelivery.util.AuthenticateRequest;
import com.learn.FoodDelivery.util.AuthenticationResponseBody;
import com.learn.FoodDelivery.util.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationController {

    public final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseBody> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok( authenticationService.register(request) );
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseBody> authenticate(
            @RequestBody AuthenticateRequest request
    ){
        return ResponseEntity.ok( authenticationService.authenticate(request) );
    }


}
