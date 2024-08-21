package com.javatrainingschool.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Car")
public class CarManagement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int carId;
	private String company;
	private String model;
	private int year;
	private String color;
	private String vin;
	private String licensePlateNumber;
	private int seatingCapacity;
	private String accidentHistory;
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}
	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	public String getAccidentHistory() {
		return accidentHistory;
	}
	public void setAccidentHistory(String accidentHistory) {
		this.accidentHistory = accidentHistory;
	}
	@Override
	public String toString() {
		return "CarManagement [carId=" + carId + ", company=" + company + ", model=" + model + ", year=" + year
				+ ", color=" + color + ", vin=" + vin + ", licensePlateNumber=" + licensePlateNumber
				+ ", seatingCapacity=" + seatingCapacity + ", accidentHistory=" + accidentHistory + "]";
	}
	public CarManagement(int carId, String company, String model, int year, String color, String vin,
			String licensePlateNumber, int seatingCapacity, String accidentHistory) {
		super();
		this.carId = carId;
		this.company = company;
		this.model = model;
		this.year = year;
		this.color = color;
		this.vin = vin;
		this.licensePlateNumber = licensePlateNumber;
		this.seatingCapacity = seatingCapacity;
		this.accidentHistory = accidentHistory;
	}
	public CarManagement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
