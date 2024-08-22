package com.javatrainingschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatrainingschool.entity.PaymentHandling;
import com.javatrainingschool.exception.PaymentException;
import com.javatrainingschool.repository.PaymentRepository;

@Service
public class PaymentServiceImpl {
	
	@Autowired
	private PaymentRepository repository;
	
	public PaymentHandling savePayment(PaymentHandling Handling) {
		return repository.save(Handling);
	}

	public List<PaymentHandling> retrivePayment() {
		List<PaymentHandling> list = repository.findAll();
		return list;
	}

	public PaymentHandling retrivePaymentById(int id) {
		return repository.findById(id).orElseThrow(() -> new PaymentException(id));
	}
	
	@SuppressWarnings("unused")
	public PaymentHandling updatePayment(PaymentHandling handling) {
	    // Ensure getPaymentId() returns Integer to handle null checks
	    if ((Integer)handling.getPaymentId() == null) {
	        throw new IllegalArgumentException("Payment ID must not be null");
	    }
	    
	    // Fetch the existing PaymentHandling from the repository
	    PaymentHandling existingHandling = repository.findById(handling.getPaymentId())
	            .orElseThrow(() -> new PaymentException(handling.getPaymentId()));
	    
	    // Update the existing PaymentHandling object with new values
	    existingHandling.setAmount(handling.getAmount());
	    existingHandling.setCar(handling.getCar());
	    existingHandling.setCustomer(handling.getCustomer());
	    existingHandling.setLease(handling.getLease());
	    existingHandling.setStatus(handling.getStatus());
	    
	    // Save and return the updated object
	    return repository.save(existingHandling);
	}


	public void deletePaymentById(int id) {
		repository.delete(repository.findById(id).orElseThrow(() -> new PaymentException(id)));
	}
}
