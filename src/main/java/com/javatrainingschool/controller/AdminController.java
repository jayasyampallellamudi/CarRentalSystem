package com.javatrainingschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javatrainingschool.entity.CarManagement;
import com.javatrainingschool.entity.CustomerManagement;
import com.javatrainingschool.entity.LeaseManagement;
import com.javatrainingschool.entity.PaymentHandling;
import com.javatrainingschool.service.CarServiceImpl;
import com.javatrainingschool.service.CustomerServiceImpl;
import com.javatrainingschool.service.LeaseServiceImpl;
import com.javatrainingschool.service.PaymentServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("admin")
@Validated
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
	public CustomerManagement saveCustomer(@Valid @RequestBody CustomerManagement management){
		return impl.saveCustomer(management);
	}
	
	@PostMapping("/updatecustomer")
	public CustomerManagement updateCustomer(@Valid @RequestBody CustomerManagement management) {
		CustomerManagement update = impl.updateCustomer(management);
		return update;
	}
	
	@DeleteMapping("/deletecustomer/{custId}")
	public String deleteCustomer(@Valid @PathVariable("custId") int id) {
		impl.deleteCustomerById(id);
		return "Deleted Succesfully";
	}
	
	@GetMapping("/getcustomers")
	public List <CustomerManagement> getCustomers(){
		return impl.retriveCustomer();
	}
	
	@GetMapping("/getcustomer/{custId}")
	public CustomerManagement getCustomer( @PathVariable("custId") int custId){
		return impl.retriveCustomerById(custId);
	}

//-----------------------------------------------------------------------------------------------------------------------------
	
	@PostMapping("/savecar")
	public CarManagement saveCustomer( @RequestBody CarManagement management){
		return carServiceImpl.saveCar(management);
	}
	
	@PostMapping("/updatecar")
	public CarManagement updateCustomer(@Valid @RequestBody CarManagement management) {
		CarManagement update = carServiceImpl.updateCar(management);
		return update;
	}
	
	@DeleteMapping("/deletecustomer/{carId}")
	public String deleteCar(@Valid @PathVariable("carId") int id) {
		carServiceImpl.deleteCarById(id);
		return "Deleted Succesfully";
	}
	
	@GetMapping("/getcars")
	public List <CarManagement> getCars(){
		return carServiceImpl.retriveCar();
	}
	
	@GetMapping("/getcar/{carId}")
	public CustomerManagement getCar(@PathVariable("carId") int carId){
		return impl.retriveCustomerById(carId);
	}
	
//----------------------------------------------------------------------------------------------------------------------------

	@PostMapping("/savelease")
	public LeaseManagement saveLease( @RequestBody LeaseManagement management){
		return leaseServiceImpl.saveLease(management);
	}
	
	@PostMapping("/updatelease")
	public LeaseManagement updateLease(@Valid @RequestBody LeaseManagement management) {
		LeaseManagement update = leaseServiceImpl.updateLease(management);
		return update;
	}
	
	@DeleteMapping("/deletelease/{leaseId}")
	public String deleteLease(@Valid @PathVariable("leaseId") int id) {
		carServiceImpl.deleteCarById(id);
		return "Deleted Succesfully";
	}
	
	@GetMapping("/getleases")
	public List <CarManagement> getLeases(){
		return carServiceImpl.retriveCar();
	}
	
	@GetMapping("/getcar/{leaseId}")
	public LeaseManagement getLease(@PathVariable("leaseId") int leaseId){
		return leaseServiceImpl.retriveLeaseById(leaseId);
	}
	
//----------------------------------------------------------------------------------------------------------------------------------------
	@PostMapping("/savepayment")
	public PaymentHandling savePayment( @RequestBody PaymentHandling management){
		return paymentServiceImpl.savePayment(management);
	}
	
	@PostMapping("/updatepayment")
	public PaymentHandling updatePayment(@Valid @RequestBody PaymentHandling management) {
		PaymentHandling update = paymentServiceImpl.updatePayment(management);
		return update;
	}
	
	@DeleteMapping("/deletelease/{paymentId}")
	public String deletePayment(@Valid @PathVariable("paymentId") int id) {
		paymentServiceImpl.deletePaymentById(id);
		return "Deleted Succesfully";
	}
	
	@GetMapping("/getpayments")
	public List <PaymentHandling> getPayments(){
		return paymentServiceImpl.retrivePayment();
	}
	
	@GetMapping("/getcar/{paymentId}")
	public PaymentHandling getPayment(@PathVariable("paymentId") int paymentId){
		return paymentServiceImpl.retrivePaymentById(paymentId);
	}
}
