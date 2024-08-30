package com.javatrainingschool.dto;

public class PaymentDto {
	private int lease;
	private int amount;
	public int getLease() {
		return lease;
	}
	public void setLease(int lease) {
		this.lease = lease;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "PaymentDto [lease=" + lease + ", amount=" + amount + "]";
	}
	public PaymentDto(int lease, int amount) {
		super();
		this.lease = lease;
		this.amount = amount;
	}
	public PaymentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
