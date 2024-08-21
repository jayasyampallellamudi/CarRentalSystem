package com.javatrainingschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatrainingschool.entity.LeaseManagement;

@Repository
public interface LeaseRepository extends JpaRepository<LeaseManagement, Integer>{

}
