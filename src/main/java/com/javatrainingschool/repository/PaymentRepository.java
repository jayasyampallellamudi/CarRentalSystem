package com.javatrainingschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatrainingschool.entity.PaymentHandling;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentHandling, Integer>{

}
