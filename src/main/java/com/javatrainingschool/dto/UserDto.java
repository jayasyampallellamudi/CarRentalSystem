package com.javatrainingschool.dto;

import java.time.LocalDate;


public class UserDto {
	
	private LocalDate leaseStartDate;
	private LocalDate leaseEndDate;
	private int leaseDuration;
	private String leaseType;
	public LocalDate getLeaseStartDate() {
		return leaseStartDate;
	}
	public void setLeaseStartDate(LocalDate leaseStartDate) {
		this.leaseStartDate = leaseStartDate;
	}
	public LocalDate getLeaseEndDate() {
		return leaseEndDate;
	}
	public void setLeaseEndDate(LocalDate leaseEndDate) {
		this.leaseEndDate = leaseEndDate;
	}
	public int getLeaseDuration() {
		return leaseDuration;
	}
	public void setLeaseDuration(int leaseDuration) {
		this.leaseDuration = leaseDuration;
	}
	public String getLeaseType() {
		return leaseType;
	}
	public void setLeaseType(String leaseType) {
		this.leaseType = leaseType;
	}
	
    
}
