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


@RestController
@RequestMapping("api/admin")
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
	
	 @PostMapping(value = "/savecustomer",  produces = "application/json")
	public CustomerManagement saveCustomer(@RequestBody CustomerManagement management){
		return impl.saveCustomer(management);
	}
	
	@PostMapping(value = "/updatecustomer",  produces = "application/json")
	public CustomerManagement updateCustomer(@RequestBody CustomerManagement management) {
		CustomerManagement update = impl.updateCustomer(management);
		return update;
	}
	
	@DeleteMapping(value = "/deletecustomer/{custId}",  produces = "application/json")
	public String deleteCustomer(@PathVariable("custId") int id) {
		impl.deleteCustomerById(id);
		return "Deleted Succesfully";
	}
	
	@GetMapping(value = "/getcustomers",  produces = "application/json")
	public List <CustomerManagement> getCustomers(){
		return impl.retriveCustomer();
	}
	
	@GetMapping(value = "/getcustomer/{custId}",  produces = "application/json")
	public CustomerManagement getCustomer( @PathVariable("custId") int custId){
		return impl.retriveCustomerById(custId);
	}

//-----------------------------------------------------------------------------------------------------------------------------
	
	@PostMapping(value = "/savecar",  produces = "application/json")
	public CarManagement saveCustomer( @RequestBody CarManagement management){
		return carServiceImpl.saveCar(management);
	}
	
	@PostMapping(value = "/updatecar",  produces = "application/json")
	public CarManagement updateCustomer(@RequestBody CarManagement management) {
		CarManagement update = carServiceImpl.updateCar(management);
		return update;
	}
	
	@DeleteMapping(value = "/deletecar/{carId}",  produces = "application/json")
	public String deleteCar(@PathVariable("carId") int id) {
		carServiceImpl.deleteCarById(id);
		return "Deleted Succesfully";
	}
	
	@GetMapping(value = "/getcars",  produces = "application/json")
	public List <CarManagement> getCars(){
		return carServiceImpl.retriveCar();
	}
	
	@GetMapping( value = "/getcar/{carId}" ,  produces = "application/json")
	public CustomerManagement getCar(@PathVariable("carId") int carId){
		return impl.retriveCustomerById(carId);
	}
	
//----------------------------------------------------------------------------------------------------------------------------

	@PostMapping(value = "/savelease" ,  produces = "application/json")
	public LeaseManagement saveLease( @RequestBody LeaseManagement management){
		return leaseServiceImpl.saveLease(management);
	}
	
	@PostMapping(value = "/updatelease" ,  produces = "application/json")
	public LeaseManagement updateLease(@RequestBody LeaseManagement management) {
		LeaseManagement update = leaseServiceImpl.updateLease(management);
		return update;
	}
	
	@DeleteMapping(value = "/deletelease/{leaseId}" ,  produces = "application/json")
	public String deleteLease(@PathVariable("leaseId") int id) {
		carServiceImpl.deleteCarById(id);
		return "Deleted Succesfully";
	}
	
	@GetMapping(value = "/getleases" ,  produces = "application/json")
	public List <LeaseManagement> getLeases(){
		return leaseServiceImpl.retriveLease();
	}
	
	@GetMapping(value = "/getlease/{leaseId}" ,  produces = "application/json")
	public LeaseManagement getLease(@PathVariable("leaseId") int leaseId){
		return leaseServiceImpl.retriveLeaseById(leaseId);
	}
	
//----------------------------------------------------------------------------------------------------------------------------------------
	@PostMapping(value = "/savepayment" ,  produces = "application/json")
	public PaymentHandling savePayment( @RequestBody PaymentHandling management){
		return paymentServiceImpl.savePayment(management);
	}
	
	@PostMapping(value = "/updatepayment" ,  produces = "application/json")
	public PaymentHandling updatePayment(@RequestBody PaymentHandling management) {
		PaymentHandling update = paymentServiceImpl.updatePayment(management);
		return update;
	}
	
	@DeleteMapping(value = "/deletepayment/{paymentId}" ,  produces = "application/json")
	public String deletePayment(@PathVariable("paymentId") int id) {
		paymentServiceImpl.deletePaymentById(id);
		return "Deleted Succesfully";
	}
	
	@GetMapping(value = "/getpayments" ,  produces = "application/json")
	public List <PaymentHandling> getPayments(){
		return paymentServiceImpl.retrivePayment();
	}
	
	@GetMapping(value = "/getpayment/{paymentId}" ,  produces = "application/json")
	public PaymentHandling getPayment(@PathVariable("paymentId") int paymentId){
		return paymentServiceImpl.retrivePaymentById(paymentId);
	}
}
