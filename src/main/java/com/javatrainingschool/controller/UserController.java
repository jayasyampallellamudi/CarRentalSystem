package com.javatrainingschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatrainingschool.dto.PaymentDto;
import com.javatrainingschool.entity.CarManagement;
import com.javatrainingschool.entity.CustomerManagement;
import com.javatrainingschool.entity.LeaseManagement;
import com.javatrainingschool.entity.PaymentHandling;
import com.javatrainingschool.service.CarServiceImpl;
import com.javatrainingschool.service.CustomerServiceImpl;
import com.javatrainingschool.service.LeaseServiceImpl;
import com.javatrainingschool.service.PaymentServiceImpl;

@RestController
@RequestMapping("api/user")
public class UserController {
	
	@Autowired
	CustomerServiceImpl customerServiceImpl;
	
	@Autowired
	LeaseServiceImpl leaseServiceImpl;
	
	@Autowired
	PaymentServiceImpl paymentServiceImpl;
	
	@Autowired
	CarServiceImpl serviceImpl;
	
	@GetMapping(value = "getCars" , produces = "application/json")
	public List<CarManagement> getCars(){
		return serviceImpl.retriveCar();
	}
	
	@PostMapping(value = "rentcar" , produces = "application/json")
	public String rentACar(@RequestBody LeaseManagement management) {
		leaseServiceImpl.saveLease(management);
		List<LeaseManagement> list= leaseServiceImpl.retriveLease();
		LeaseManagement management2 =  list.getLast();
		int amount  = (management.getCar().getSeatingCapacity() == 7) ? management.getLeaseDuration() * 2500 : management.getLeaseDuration() * 1500;
		return "the amount you have to pay  = " + amount + "Your Lease Id : " + management2.getLeaseId();
	}
	
	@PostMapping(value = "makepayment" , produces = "application/json")
	public String makePayment(@RequestBody PaymentDto dto) {
		
		PaymentHandling handling = new PaymentHandling();
		
		CarManagement carManagement = new CarManagement();
		
		LeaseManagement leaseManagement = new LeaseManagement();
		
		CustomerManagement customerManagement = new CustomerManagement();
		
		leaseManagement = leaseServiceImpl.retriveLeaseById(dto.getLease());
		
		carManagement = serviceImpl.retriveCarById(leaseManagement.getCar().getCarId());
		
		customerManagement = customerServiceImpl.retriveCustomerById(leaseManagement.getCustomer().getCustId());
		
		leaseManagement.setLeaseId(dto.getLease());
		
		handling.setAmount(dto.getAmount());
		handling.setCar(carManagement);
		handling.setCustomer(customerManagement);
		handling.setLease(leaseManagement);
		handling.setStatus("Sucessful");
		paymentServiceImpl.savePayment(handling);
		
		return "Payment Sucessful , \n" + dto.getAmount() + " Received";
	}
}
