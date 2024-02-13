package com.learn.FoodDelivery.config;

import com.learn.FoodDelivery.config.security.JWTAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    public final JWTAuthenticationFilter jwtAuthenticationFilter;
    public final AuthenticationProvider authenticationProvider;

    private final String[] WHITELIST_URL_PATTERN = { "/api/auth/**", "/api/home", "/api/user/**"};
    private final String[] GET_ALLOWED_URL_PATTERN = {"/api/food"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests( auth -> auth
                                                .requestMatchers(WHITELIST_URL_PATTERN)
                                                .permitAll()
                                                .requestMatchers(HttpMethod.GET, GET_ALLOWED_URL_PATTERN)
                                                .permitAll()
                                                .anyRequest()
                                                .authenticated()
                )
                .sessionManagement(configurer -> configurer
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
