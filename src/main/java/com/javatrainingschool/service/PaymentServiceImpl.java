package com.javatrainingschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.javatrainingschool.entity.PaymentHandling;
import com.javatrainingschool.repository.PaymentRepository;

public class PaymentServiceImpl {
	
	@Autowired
	private PaymentRepository repository;
	
	public PaymentHandling savePayment(PaymentHandling Handling) {
		
		return Handling;
	}

	public List<PaymentHandling> retrivePayment() {
		List<PaymentHandling> list = repository.findAll();
		return list;
	}

	public PaymentHandling retrivePaymentById(int id) {
		return repository.findById(id).get();
	}
	
	public PaymentHandling updatePayment(PaymentHandling Handling) {
		PaymentHandling Handling2 = repository.findById(Handling.getPaymentId()).get();
		Handling2.setAmount(Handling.getAmount());
		Handling2.setCar(Handling.getCar());
		Handling2.setCustomer(Handling.getCustomer());
		Handling2.setLease(Handling.getLease());
		Handling2.setPaymentId(Handling.getPaymentId());
		Handling2.setStatus(Handling.getStatus());
		return repository.save(Handling2);
	}

	public void deletePaymentById(int id) {
		repository.delete(repository.findById(id).get());
	}
}
