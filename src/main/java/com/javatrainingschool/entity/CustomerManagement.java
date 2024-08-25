package com.javatrainingschool.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Customer")
public class CustomerManagement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int custId;
	
	@NotBlank(message = "userName cannot be blank")
	private String userName;
	
	@NotNull(message = "Age cannot be null")
	@Min(value = 18, message = "Age must be a positive number")
	private int age;
	
	private String gender;
	
    @NotBlank(message = "mobileNumber cannot be blank")
    private String mobileNumber;

    @NotBlank(message = "emailId cannot be blank")
    private String emailId;

    @NotBlank(message = "Address cannot be blank")
    private String address;

    @NotBlank(message = "Driving license cannot be blank")
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
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
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
	public CustomerManagement(int custId, String userName, int age, String gender, String mobileNumber, String emailId,
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
