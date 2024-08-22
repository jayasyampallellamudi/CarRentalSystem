package com.javatrainingschool.service;

import java.util.List;

import com.javatrainingschool.entity.LeaseManagement;

public interface LeaseService{
	public LeaseManagement saveLease(LeaseManagement management);
	public List<LeaseManagement> retriveLease();
	public LeaseManagement retriveLeaseById(int id);
	public LeaseManagement updateLease(LeaseManagement management);
	public void deleteLeaseById(int id);
}
