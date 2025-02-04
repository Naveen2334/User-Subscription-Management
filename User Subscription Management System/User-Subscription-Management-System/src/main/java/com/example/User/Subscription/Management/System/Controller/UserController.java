package com.example.User.Subscription.Management.System.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.User.Subscription.Management.System.Dto.UserRequest;
import com.example.User.Subscription.Management.System.Dto.UserResponse;
import com.example.User.Subscription.Management.System.Exception.UserNotFoundException;
import com.example.User.Subscription.Management.System.Service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	 @Autowired
     UserService userService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE) // Explicitly declare JSON output
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(request));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable long id) {
        try {
            return ResponseEntity.ok(userService.getUserById(id));
        } catch (UserNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (UserNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
