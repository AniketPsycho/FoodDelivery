package com.learn.FoodDelivery.services;

import com.learn.FoodDelivery.models.User;
import com.learn.FoodDelivery.repositories.UserRepository;
import com.learn.FoodDelivery.util.AuthenticateRequest;
import com.learn.FoodDelivery.util.AuthenticationResponseBody;
import com.learn.FoodDelivery.util.Authority;
import com.learn.FoodDelivery.util.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    public final UserRepository userRepository;
    public final JwtService jwtService;
    public final PasswordEncoder passwordEncoder;
    public final AuthenticationManager authenticationManager;

    public AuthenticationResponseBody register(RegisterRequest request) {
        User user = User.builder()
                .firstName( request.getFirstname() )
                .lastName( request.getLastname() )
                .email( request.getEmail() )
                .password( passwordEncoder.encode(request.getPassword()) )
                .mobileNumber( request.getMobileNumber() )
                .authority(Authority.USER)
                .build();

        userRepository.save(user);

        String jwt = jwtService.generateToken(user);

        return AuthenticationResponseBody.builder()
                .token(jwt)
                .build();
    }

    public AuthenticationResponseBody authenticate(AuthenticateRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String jwt = jwtService.generateToken(user);

        return AuthenticationResponseBody.builder()
                .token(jwt)
                .build();
    }
}
