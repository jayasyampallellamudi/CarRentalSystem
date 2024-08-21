package com.javatrainingschool.service;

import java.util.List;

import com.javatrainingschool.entity.CustomerManagement;

public interface CustomerService {
	public CustomerManagement saveCustomer(CustomerManagement management);
	public List<CustomerManagement> retriveCustomer();
	public CustomerManagement retriveCustomerById(int id);
	public CustomerManagement updateCustomer(CustomerManagement management);
	public void deleteCustomerById(int id);
}
