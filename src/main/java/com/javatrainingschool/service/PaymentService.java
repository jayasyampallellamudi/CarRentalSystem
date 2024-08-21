package com.javatrainingschool.service;

import java.util.List;

import com.javatrainingschool.entity.PaymentHandling;

public interface PaymentService {
	public PaymentHandling savePayment(PaymentHandling Handling);
	public List<PaymentHandling> retrivePayment();
	public PaymentHandling retrivePaymentById(int id);
	public PaymentHandling updatePayment(PaymentHandling Handling);
	public void deletePaymentById(int id);
}
