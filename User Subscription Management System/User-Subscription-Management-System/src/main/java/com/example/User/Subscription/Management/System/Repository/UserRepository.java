package com.example.User.Subscription.Management.System.Repository;

import java.util.Optional;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.User.Subscription.Management.System.Entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

}
