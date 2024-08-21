package com.javatrainingschool.service;

import java.util.List;

import com.javatrainingschool.entity.CarManagement;

public interface CarService {
	public CarManagement saveCar(CarManagement management);
	public List<CarManagement> retriveCar();
	public CarManagement retriveCarById(int id);
	public CarManagement updateCar(CarManagement management);
	public void deleteCarById(int id);
}
