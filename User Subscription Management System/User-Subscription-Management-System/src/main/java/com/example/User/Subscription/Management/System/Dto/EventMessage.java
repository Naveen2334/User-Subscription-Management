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
public class EventMessage {
    private UUID subscriptionId;
    private UUID userId;
    private String planName;
    private String status;
    private String event;
    private LocalDateTime timestamp;
	public EventMessage(UUID id, UUID id2, String planName2, String name, String eventType, LocalDateTime now) {
		// TODO Auto-generated constructor stub
	}
	public UUID getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(UUID subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
    
}