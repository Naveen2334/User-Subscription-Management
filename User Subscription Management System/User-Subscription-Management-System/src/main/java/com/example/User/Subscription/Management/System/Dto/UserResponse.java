package com.example.User.Subscription.Management.System.Dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    public UserResponse(String string, String name2, String email2) {
		// TODO Auto-generated constructor stub
	}
	public UserResponse(String name2, String email2) {
		// TODO Auto-generated constructor stub
	}
	private long id;
    private String name;
    private String email;
    private LocalDateTime createdAt;
}