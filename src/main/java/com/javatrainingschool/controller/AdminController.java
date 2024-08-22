package com.javatrainingschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatrainingschool.entity.CustomerManagement;
import com.javatrainingschool.entity.LeaseManagement;
import com.javatrainingschool.service.CarServiceImpl;
import com.javatrainingschool.service.CustomerServiceImpl;
import com.javatrainingschool.service.LeaseServiceImpl;
import com.javatrainingschool.service.PaymentServiceImpl;

@RestController
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private CustomerServiceImpl impl;
	
	@Autowired
	private CarServiceImpl carServiceImpl;
	
	@Autowired
	private LeaseServiceImpl leaseServiceImpl;
	
	@Autowired
	private PaymentServiceImpl paymentServiceImpl;

	
	@PostMapping("/savecustomer")
	public CustomerManagement saveCustomer( @RequestBody CustomerManagement management){
		return impl.saveCustomer(management);
	}
	
	@GetMapping("/getcustomer/{custId}")
	public CustomerManagement saveCustomer( @PathVariable("custId") int custId){
		return impl.retriveCustomerById(custId);
	}
	
	@PostMapping("/savelease")
	public LeaseManagement saveLease(@RequestBody LeaseManagement management) {
		return leaseServiceImpl.saveLease(management);
	}
	
}
