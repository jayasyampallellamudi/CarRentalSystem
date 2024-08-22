package com.javatrainingschool.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatrainingschool.entity.CustomerManagement;
import com.javatrainingschool.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository repository;
	
	public CustomerManagement saveCustomer(CustomerManagement management) {
		CustomerManagement management2 = repository.save(management);
		return management2;
	}

	public List<CustomerManagement> retriveCustomer() {
		List<CustomerManagement> list = repository.findAll();
		list.forEach(s -> s.setUserName("prasad"));
		return list;
	}

	public CustomerManagement retriveCustomerById(int id) {
		return repository.findById(id).get();
	}
	
	public CustomerManagement updateCustomer(CustomerManagement management) {
		CustomerManagement management2 = repository.findById(management.getCustId()).get();
		management2.setAddress(management.getAddress());
		management2.setAge(management.getAge());
		management2.setDrivingLicence(management.getDrivingLicence());
		management2.setEmailId(management.getEmailId());
		management2.setGender(management.getGender());
		management2.setMobileNumber(management.getMobileNumber());
		management2.setUserName(management.getUserName());
		return repository.save(management2);
	}

	public void deleteCustomerById(int customerId) {
	    Optional<CustomerManagement> customerOpt = repository.findById(customerId);
	    if (customerOpt.isPresent()) {
	        repository.delete(customerOpt.get()); // Ensure this line is present
	    }
	}
	
}
