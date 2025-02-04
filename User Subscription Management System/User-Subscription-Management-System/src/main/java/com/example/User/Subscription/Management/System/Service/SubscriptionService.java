package com.example.User.Subscription.Management.System.Service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.User.Subscription.Management.System.Dto.SubscriptionRequest;
import com.example.User.Subscription.Management.System.Dto.SubscriptionResponse;
import com.example.User.Subscription.Management.System.Entity.Subscription;
import com.example.User.Subscription.Management.System.Entity.User;
import com.example.User.Subscription.Management.System.Exception.SubscriptionNotFoundException;
import com.example.User.Subscription.Management.System.Exception.UserNotFoundException;
import com.example.User.Subscription.Management.System.Repository.SubscriptionRepository;
import com.example.User.Subscription.Management.System.Repository.UserRepository;
import com.example.User.Subscription.Management.System.enumtype.SubscriptionStatus;

@Service
@Transactional
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;
    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.create.routing-key}")
    private String createRoutingKey;

    @Value("${rabbitmq.cancel.routing-key}")
    private String cancelRoutingKey;

    public SubscriptionService(SubscriptionRepository subscriptionRepository, 
                                UserRepository userRepository, 
                                RabbitTemplate rabbitTemplate) {
        this.subscriptionRepository = subscriptionRepository;
        this.userRepository = userRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    public SubscriptionResponse createSubscription(SubscriptionRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + request.getUserId()));

        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setPlanName(request.getPlanName());
        subscription.setStartDate(request.getStartDate());
        subscription.setStatus(SubscriptionStatus.ACTIVE);

        Subscription savedSubscription = subscriptionRepository.save(subscription);
        rabbitTemplate.convertAndSend(exchange, createRoutingKey, "Subscription created: " + savedSubscription.getId());
        return convertToResponse(savedSubscription);
    }

    public SubscriptionResponse cancelSubscription(Long id) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new SubscriptionNotFoundException("Subscription not found with ID: " + id));

        subscription.setStatus(SubscriptionStatus.CANCELLED);
        subscription.setEndDate(LocalDate.now());

        Subscription updatedSubscription = subscriptionRepository.save(subscription);
        rabbitTemplate.convertAndSend(exchange, cancelRoutingKey, "Subscription cancelled: " + updatedSubscription.getId());
        return convertToResponse(updatedSubscription);
    }

    public SubscriptionResponse getSubscriptionById(Long id) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new SubscriptionNotFoundException("Subscription not found with ID: " + id));
        return convertToResponse(subscription);
    }

    private SubscriptionResponse convertToResponse(Subscription subscription) {
        return new SubscriptionResponse(
                subscription.getId(),
                subscription.getUser().getId(),
                subscription.getPlanName(),
                subscription.getStatus(),
                subscription.getStartDate(),
                subscription.getEndDate()
        );
    }
}
