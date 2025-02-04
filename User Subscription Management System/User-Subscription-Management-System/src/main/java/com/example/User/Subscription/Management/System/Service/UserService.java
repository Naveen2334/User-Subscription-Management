package com.example.User.Subscription.Management.System.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.User.Subscription.Management.System.Dto.UserRequest;
import com.example.User.Subscription.Management.System.Dto.UserResponse;
import com.example.User.Subscription.Management.System.Entity.User;
import com.example.User.Subscription.Management.System.Exception.UserNotFoundException;
import com.example.User.Subscription.Management.System.Repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Constructor-based dependency injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserResponse createUser(UserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists: " + request.getEmail());
        }

        // Manual mapping from UserRequest to User entity
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        
        User savedUser = userRepository.save(user);

        // Manual mapping from User to UserResponse
        return new UserResponse(
           
            savedUser.getName(),
            savedUser.getEmail()
        );
    }

    @Transactional(readOnly = true)
    public UserResponse getUserById(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
        
        return new UserResponse(
            user.getId(),
            user.getName(),
            user.getEmail()
        );
    }

    @Transactional
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
        userRepository.delete(user);
    }
}

/*
 * @Service
 * 
 * @RequiredArgsConstructor public class UserService { private final
 * UserRepository userRepository = null;
 * 
 * private final UserMapper userMapper = null;
 * 
 * @Transactional public UserResponse createUser(UserRequest request) { if
 * (userRepository.existsByEmail(request.getEmail())) { throw new
 * IllegalArgumentException("Email already exists: " + request.getEmail()); }
 * 
 * // User user = userMapper.toEntity(request); User savedUser =
 * userRepository.save(request);
 * 
 * return userMapper.toResponse(savedUser); }
 * 
 * @Transactional(readOnly = true) public UserResponse getUserById(UUID id) {
 * return userRepository.findById(id) .map(userMapper::toResponse)
 * .orElseThrow(() -> new UserNotFoundException("User not found with ID: " +
 * id)); }
 * 
 * @Transactional public void deleteUser(UUID id) { User user =
 * userRepository.findById(id) .orElseThrow(() -> new
 * UserNotFoundException("User not found with ID: " + id));
 * userRepository.delete(user); } }
 */