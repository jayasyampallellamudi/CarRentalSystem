package com.javatrainingschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatrainingschool.entity.CarManagement;
import com.javatrainingschool.exception.CarException;
import com.javatrainingschool.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarRepository repository;
	
	public CarManagement saveCar(CarManagement management) {
		
		return management;
	}

	public List<CarManagement> retriveCar() {
		List<CarManagement> list = repository.findAll();
		return list;
	}

	public CarManagement retriveCarById(int id) {
		return repository.findById(id).orElseThrow(() -> new CarException(id));
	}
	
	public CarManagement updateCar(CarManagement management) {
		CarManagement management2 = repository.findById(management.getCarId()).get();
		management2.setColor(management.getColor());
		management2.setAccidentHistory(management.getAccidentHistory());
		management2.setCompany(management.getCompany());
		management2.setModel(management.getModel());
		management2.setLicensePlateNumber(management.getLicensePlateNumber());
		management2.setSeatingCapacity(management.getSeatingCapacity());
		management2.setVin(management.getVin());
		management2.setYear(management.getYear());
		return repository.save(management2);
	}

	public void deleteCarById(int id) {
		repository.delete(repository.findById(id).get());
	}

}
