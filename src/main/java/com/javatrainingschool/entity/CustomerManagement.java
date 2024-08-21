package com.javatrainingschool.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
public class CustomerManagement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int custId;
	private String userName;
	private int age;
	private String gender;
	private double mobileNumber;
	private String emailId;
	private String address;
	private String drivingLicence;
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(double mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDrivingLicence() {
		return drivingLicence;
	}
	public void setDrivingLicence(String drivingLicence) {
		this.drivingLicence = drivingLicence;
	}
	@Override
	public String toString() {
		return "CustomerManagement [custId=" + custId + ", userName=" + userName + ", age=" + age + ", gender=" + gender
				+ ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", address=" + address
				+ ", drivingLicence=" + drivingLicence + "]";
	}
	public CustomerManagement(int custId, String userName, int age, String gender, double mobileNumber, String emailId,
			String address, String drivingLicence) {
		super();
		this.custId = custId;
		this.userName = userName;
		this.age = age;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.address = address;
		this.drivingLicence = drivingLicence;
	}
	public CustomerManagement() {
		super();
		// TODO Auto-generated constructor stub
	}
}
