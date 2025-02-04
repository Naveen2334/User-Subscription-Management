package com.example.User.Subscription.Management.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.User.Subscription.Management.System.Entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}