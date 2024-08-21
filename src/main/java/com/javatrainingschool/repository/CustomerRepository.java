package com.javatrainingschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatrainingschool.entity.CustomerManagement;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerManagement, Integer>{

}
