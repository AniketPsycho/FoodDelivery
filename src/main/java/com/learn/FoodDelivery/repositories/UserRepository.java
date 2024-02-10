package com.learn.FoodDelivery.repositories;

import com.learn.FoodDelivery.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findByEmail(String email);

    @Transactional
    public long deleteByEmail(String email);
}
