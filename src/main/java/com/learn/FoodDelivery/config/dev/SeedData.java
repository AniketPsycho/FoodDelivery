package com.learn.FoodDelivery.config.dev;

import com.learn.FoodDelivery.models.User;
import com.learn.FoodDelivery.repositories.UserRepository;
import com.learn.FoodDelivery.util.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SeedData implements CommandLineRunner {

    public final UserRepository userRepository;
    public final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        User user = User.builder().firstName("Aniket").lastName("Patel").email("aniket.patel9786@gmail.com").password(passwordEncoder.encode("MyStrongPass@123")).mobileNumber("7566295906").authority(Authority.ADMIN).build();
        userRepository.save(user);
        user = User.builder().firstName("Aniket").lastName("Patel").email("a1").password(passwordEncoder.encode("MyStrongPass@123")).mobileNumber("1").authority(Authority.USER).build();
        userRepository.save(user);
        user = User.builder().firstName("Aniket").lastName("Patel").email("a2").password(passwordEncoder.encode("MyStrongPass@123")).mobileNumber("2").authority(Authority.USER).build();
        userRepository.save(user);
        user = User.builder().firstName("Aniket").lastName("Patel").email("a3").password(passwordEncoder.encode("MyStrongPass@123")).mobileNumber("3").authority(Authority.USER).build();
        userRepository.save(user);
        user = User.builder().firstName("Aniket").lastName("Patel").email("a4").password(passwordEncoder.encode("MyStrongPass@123")).mobileNumber("4").authority(Authority.USER).build();
        userRepository.save(user);
    }
}
