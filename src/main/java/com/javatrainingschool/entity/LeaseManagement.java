package com.javatrainingschool.entity;

import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Lease")
public class LeaseManagement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int leaseId;
	
	@ManyToOne
    @JoinColumn(name = "custId", nullable = false)
    private CustomerManagement customer;
	
    @ManyToOne
    @JoinColumn(name = "carId", nullable = false)
    private CarManagement car;
    
	private Date leaseStartDate;
	private Date leaseEndDate;
	private int leaseDuration;
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
	public Date getLeaseStartDate() {
		return leaseStartDate;
	}
	public void setLeaseStartDate(Date leaseStartDate) {
		this.leaseStartDate = leaseStartDate;
	}
	public Date getLeaseEndDate() {
		return leaseEndDate;
	}
	public void setLeaseEndDate(Date leaseEndDate) {
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
	public LeaseManagement(int leaseId, CustomerManagement customer, CarManagement car, Date leaseStartDate,
			Date leaseEndDate, int leaseDuration, String leaseType) {
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
		// TODO Auto-generated constructor stub
	}
	
}
