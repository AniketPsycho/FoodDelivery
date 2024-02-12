package com.learn.FoodDelivery.config;

import com.learn.FoodDelivery.config.security.JWTAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    public final JWTAuthenticationFilter jwtAuthenticationFilter;
    public final AuthenticationProvider authenticationProvider;

    private final String[] WHITELIST_URL_PATTERN = { "/api/auth/**", "/api/csrf", "/api/csrf", "/api/user/**"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
        requestHandler.setCsrfRequestAttributeName(null);

        http
                //.csrf(AbstractHttpConfigurer::disable)
                .csrf( csrf -> csrf
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                        .csrfTokenRequestHandler(requestHandler)
                )
                .authorizeHttpRequests( auth -> auth
                                                .requestMatchers(WHITELIST_URL_PATTERN)
                                                .permitAll()
                                                //.requestMatchers("").hasAuthority("ADMIN")
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
