package com.learn.JwtTokenSecurity.controllers;

import com.learn.JwtTokenSecurity.services.AuthenticationService;
import com.learn.JwtTokenSecurity.util.AuthenticateRequest;
import com.learn.JwtTokenSecurity.util.AuthenticationResponseBody;
import com.learn.JwtTokenSecurity.util.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
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
