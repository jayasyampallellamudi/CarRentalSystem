package com.javatrainingschool.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Car")
public class CarManagement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carId;
	
	@NotBlank(message = "company cannot be blank")
	private String company;
	
	@NotBlank(message = "model cannot be blank")
	private String model;
	
	@NotNull(message = "year cannot be null")
	private int year;
	
	@NotBlank(message = "color cannot be blank")
	private String color;
	
	@NotBlank(message = "userName cannot be blank")
	private String vin;
	
	@NotBlank(message = "userName cannot be blank")
	private String licensePlateNumber;
	private int seatingCapacity;
	
	@NotBlank(message = "userName cannot be blank")
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
