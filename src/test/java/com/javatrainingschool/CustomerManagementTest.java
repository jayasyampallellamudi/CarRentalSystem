package com.javatrainingschool;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import com.javatrainingschool.entity.CustomerManagement;
import com.javatrainingschool.repository.CustomerRepository;
import com.javatrainingschool.service.CustomerServiceImpl;

@SpringBootTest(classes = CarRentalSystemApplication.class)
public class CustomerManagementTest {
	
	@Mock
	CustomerRepository repository;
	
	@InjectMocks
	CustomerServiceImpl impl = new CustomerServiceImpl();
	
    private CustomerManagement management;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        management = new CustomerManagement();
        management.setCustId(1);
        management.setAge(23);
        management.setAddress("rajahmundry");
        management.setDrivingLicence("AP1234567890");
        management.setEmailId("jayasyam12356@gmail.com");
        management.setMobileNumber(732465488);
        management.setGender("male");
        management.setUserName("jayasyam");
    }
	
	@Test
	public void updateCustomerTest1() {
	    // Arrange
	    CustomerManagement management1 = new CustomerManagement();
	    management1.setCustId(1);
	    management1.setAge(23);
	    management1.setAddress("Hyderabad");
	    management1.setDrivingLicence("AP1234567890");
	    management1.setEmailId("jayasyam12356@gmail.com");
	    management1.setMobileNumber(732465488);
	    management1.setGender("male");
	    management1.setUserName("jayasyam");
	    
	    // Mocking the repository to return an Optional of the management object
	    when(repository.findById(management.getCustId())).thenReturn(Optional.of(management1));
	    // Mocking the repository save method to return the updated management object
	    when(repository.save(any(CustomerManagement.class))).thenReturn(management1);

	    // Assuming `impl` is the instance of your service or class under test
	    CustomerManagement customerManagement = impl.saveCustomer(management);
	    
	    // Assert
	    assertEquals("Hyderabad", customerManagement.getAddress());
	}
	
	@Test
	public void retriveCustomerTest() {
		List<CustomerManagement> customers = new ArrayList<>();
		customers.add(management);
		when(repository.findAll()).thenReturn(customers);
		List<CustomerManagement> list = impl.retriveCustomer();
		assertEquals("prasad", list.get(0).getUserName());
	}
	
	@Test
	public void saveCustomerTest() {
		when(repository.save(any(CustomerManagement.class))).thenReturn(management);
		CustomerManagement management2 =  impl.saveCustomer(management);
		//assertEquals(1, management2.getCustId());
		Assertions.assertThat(management2.getCustId()).isGreaterThan(0);
	}
	
	@Test
	public void updateCustomerTest() {
		CustomerManagement management1 = new CustomerManagement();
	        management.setCustId(1);
	        management.setAge(23);
	        management.setAddress("Hyderabad");
	        management.setDrivingLicence("AP1234567890");
	        management.setEmailId("jayasyam12356@gmail.com");
	        management.setMobileNumber(732465488);
	        management.setGender("male");
	        management.setUserName("jayasyam");
	        when(repository.findById(management.getCustId())).thenReturn(Optional.of(management));
		
		CustomerManagement customerManagement = impl.saveCustomer(management);
		assertEquals("Hyderabad", customerManagement.getAddress());
	}


}
