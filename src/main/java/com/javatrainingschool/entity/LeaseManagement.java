package com.javatrainingschool.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Lease")
public class LeaseManagement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int leaseId;
	
	@ManyToOne
    @JoinColumn(name = "custId", nullable = false)
    private CustomerManagement customer;
	
    @ManyToOne
    @JoinColumn(name = "carId", nullable = false)
    private CarManagement car;
    
    @NotNull(message = "Lease start date cannot be null")
	private LocalDate leaseStartDate;
    
    @NotNull(message = "Lease start date cannot be null")
	private LocalDate leaseEndDate;
    
    @NotNull(message = "Lease start date cannot be null")
	private int leaseDuration;
    
    @NotBlank(message = "leasetype can not be null")
	private String leaseType;
    
	public int getLeaseId() {
		return leaseId;
	}
	public void setLeaseId(int leaseId) {
		this.leaseId = leaseId;
	}
	public CustomerManagement getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerManagement customer) {
		this.customer = customer;
	}
	public CarManagement getCar() {
		return car;
	}
	public void setCar(CarManagement car) {
		this.car = car;
	}
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
	@Override
	public String toString() {
		return "LeaseManagement [leaseId=" + leaseId + ", customer=" + customer + ", car=" + car + ", leaseStartDate="
				+ leaseStartDate + ", leaseEndDate=" + leaseEndDate + ", leaseDuration=" + leaseDuration
				+ ", leaseType=" + leaseType + "]";
	}
	public LeaseManagement(int leaseId, CustomerManagement customer, CarManagement car, LocalDate leaseStartDate,
			LocalDate leaseEndDate, int leaseDuration, String leaseType) {
		super();
		this.leaseId = leaseId;
		this.customer = customer;
		this.car = car;
		this.leaseStartDate = leaseStartDate;
		this.leaseEndDate = leaseEndDate;
		this.leaseDuration = leaseDuration;
		this.leaseType = leaseType;
	}
	public LeaseManagement() {
		super();
	}
	
	
}
