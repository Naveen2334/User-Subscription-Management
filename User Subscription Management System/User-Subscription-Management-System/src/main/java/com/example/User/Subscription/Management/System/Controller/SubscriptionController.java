package com.example.User.Subscription.Management.System.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.User.Subscription.Management.System.Dto.SubscriptionRequest;
import com.example.User.Subscription.Management.System.Dto.SubscriptionResponse;
import com.example.User.Subscription.Management.System.Service.SubscriptionService;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping
    public ResponseEntity<SubscriptionResponse> createSubscription(@RequestBody SubscriptionRequest request) {
        SubscriptionResponse response = subscriptionService.createSubscription(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionResponse> getSubscriptionById(@PathVariable Long id) {
        SubscriptionResponse response = subscriptionService.getSubscriptionById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<SubscriptionResponse> cancelSubscription(@PathVariable Long id) {
        SubscriptionResponse response = subscriptionService.cancelSubscription(id);
        return ResponseEntity.ok(response);
    }
}
