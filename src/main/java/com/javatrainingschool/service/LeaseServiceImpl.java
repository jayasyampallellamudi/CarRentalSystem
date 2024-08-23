package com.javatrainingschool.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javatrainingschool.entity.LeaseManagement;
import com.javatrainingschool.exception.CustomerException;
import com.javatrainingschool.exception.LeaseException;
import com.javatrainingschool.repository.CarRepository;
import com.javatrainingschool.repository.CustomerRepository;
import com.javatrainingschool.repository.LeaseRepository;

@Service
public class LeaseServiceImpl implements LeaseService{
	
	@Autowired
	private LeaseRepository repository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CarRepository carRepository;
	
	public LeaseManagement saveLease(LeaseManagement management) {
		System.out.println(management.getCustomer().getCustId());
		customerRepository.findById(management.getCustomer().getCustId()).orElseThrow(() -> new CustomerException(management.getCustomer().getCustId()));
		carRepository.findById(management.getCar().getCarId()).orElseThrow(() -> new CustomerException(management.getCar().getCarId()));
		return repository.save(management);
	}

	public List<LeaseManagement> retriveLease() {
		List<LeaseManagement> list = repository.findAll();
		return list;
	}

	public LeaseManagement retriveLeaseById(int id) {
		return repository.findById(id).orElseThrow(() -> new LeaseException(id));
	}
	
	public LeaseManagement updateLease(LeaseManagement management) {
		LeaseManagement management2 = repository.findById(management.getLeaseId()).get();
		management2.setCar(management.getCar());
		management2.setCustomer(management.getCustomer());
		management2.setLeaseDuration(management.getLeaseDuration());
		management2.setLeaseEndDate(management.getLeaseEndDate());
		management2.setLeaseStartDate(management.getLeaseStartDate());
		management2.setLeaseType(management.getLeaseType());
		return repository.save(management2);
	}

	public void deleteLeaseById(int id) {
		repository.delete(repository.findById(id).get());
	}

}
