package com.example.User.Subscription.Management.System.Mapper;


import com.example.User.Subscription.Management.System.Dto.SubscriptionRequest;
import com.example.User.Subscription.Management.System.Dto.SubscriptionResponse;
import com.example.User.Subscription.Management.System.Entity.Subscription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    // Map SubscriptionRequest to Subscription entity
    Subscription toEntity(SubscriptionRequest request);

    // Map Subscription entity to SubscriptionResponse DTO
    SubscriptionResponse toResponse(Subscription subscription);
}
