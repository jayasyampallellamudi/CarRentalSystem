package com.javatrainingschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatrainingschool.entity.CarManagement;

@Repository
public interface CarRepository extends JpaRepository<CarManagement, Integer>{

}
