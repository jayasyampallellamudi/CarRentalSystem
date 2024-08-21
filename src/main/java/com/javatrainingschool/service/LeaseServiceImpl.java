package com.javatrainingschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.javatrainingschool.entity.LeaseManagement;
import com.javatrainingschool.repository.LeaseRepository;

public class LeaseServiceImpl implements LeaseService{
	
	@Autowired
	private LeaseRepository repository;
	
	public LeaseManagement saveLease(LeaseManagement management) {
		
		return management;
	}

	public List<LeaseManagement> retriveLease() {
		List<LeaseManagement> list = repository.findAll();
		return list;
	}

	public LeaseManagement retriveLeaseById(int id) {
		return repository.findById(id).get();
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
