package com.javatrainingschool.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name = "Payment")
public class PaymentHandling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	
	@ManyToOne
    @JoinColumn(name = "custId", nullable = false)
    private CustomerManagement customer;
	
	@ManyToOne
    @JoinColumn(name = "leaseId", nullable = false)
    private LeaseManagement lease;
	
    @ManyToOne
    @JoinColumn(name = "carId", nullable = false)
    private CarManagement car;
    
    @NotNull(message = "year cannot be null")
    private int amount;
    
    @NotNull(message = "status start date cannot be null")
    private String status;
    
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public CustomerManagement getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerManagement customer) {
		this.customer = customer;
	}
	public LeaseManagement getLease() {
		return lease;
	}
	public void setLease(LeaseManagement lease) {
		this.lease = lease;
	}
	public CarManagement getCar() {
		return car;
	}
	public void setCar(CarManagement car) {
		this.car = car;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "PaymentHandling [paymentId=" + paymentId + ", customer=" + customer + ", lease=" + lease + ", car="
				+ car + ", amount=" + amount + ", status=" + status + "]";
	}
	public PaymentHandling(int paymentId, CustomerManagement customer, LeaseManagement lease, CarManagement car,
			int amount, String status) {
		super();
		this.paymentId = paymentId;
		this.customer = customer;
		this.lease = lease;
		this.car = car;
		this.amount = amount;
		this.status = status;
	}
	public PaymentHandling() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
