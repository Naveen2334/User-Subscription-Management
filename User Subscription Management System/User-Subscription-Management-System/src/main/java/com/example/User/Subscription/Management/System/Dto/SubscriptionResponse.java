package com.example.User.Subscription.Management.System.Dto;

import java.time.LocalDate;

import com.example.User.Subscription.Management.System.enumtype.SubscriptionStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionResponse {
    public SubscriptionResponse(String string, String string2, String planName2, SubscriptionStatus status2, LocalDate endDate2,
			LocalDate startDate2) {
		// TODO Auto-generated constructor stub
	}
	private long id;
    private long userId;
    private String planName;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
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
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
    
}