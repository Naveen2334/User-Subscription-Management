package com.example.User.Subscription.Management.System.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.User.Subscription.Management.System.Dto.UserRequest;
import com.example.User.Subscription.Management.System.Dto.UserResponse;
import com.example.User.Subscription.Management.System.Entity.User;

@Mapper(componentModel = "spring")

public interface UserMapper {

UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

UserResponse toResponse(User user);

User toEntity(UserRequest request);

}