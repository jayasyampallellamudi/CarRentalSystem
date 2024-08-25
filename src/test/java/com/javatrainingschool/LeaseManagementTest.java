package com.javatrainingschool;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
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
import com.javatrainingschool.entity.CarManagement;
import com.javatrainingschool.entity.CustomerManagement;
import com.javatrainingschool.entity.LeaseManagement;
import com.javatrainingschool.repository.CarRepository;
import com.javatrainingschool.repository.CustomerRepository;
import com.javatrainingschool.repository.LeaseRepository;
import com.javatrainingschool.service.LeaseServiceImpl;

@SpringBootTest
public class LeaseManagementTest {
	
	@Mock
	LeaseRepository repository;
	
	@Mock
	CustomerRepository customerRepository;
	
	@Mock
	CarRepository carRepository;
	
	@InjectMocks
	LeaseServiceImpl impl = new LeaseServiceImpl();
	
    private LeaseManagement management;
    private LeaseManagement management1;
    
    private CustomerManagement customer;
    
    private CarManagement car;
    

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        
        car = new CarManagement();
        car.setCarId(1);
        customer = new CustomerManagement();
        customer.setCustId(1); 
     
        management = new LeaseManagement();
        management.setCar(car);
        management.setCustomer(customer);
        management.setLeaseDuration(2);
        management.setLeaseEndDate(LocalDate.of(2024, 8, 10));
        management.setLeaseEndDate(LocalDate.of(2024, 8, 8));
        management.setLeaseId(1);
        management.setLeaseType("Hourly");
    }
    @BeforeEach
    public void setUp1() {
        MockitoAnnotations.openMocks(this);
        
        car = new CarManagement();
        car.setCarId(2);
        customer = new CustomerManagement();
        customer.setCustId(2); 
        
        management1 = new LeaseManagement();
        management1.setCar(car);
        management1.setCustomer(customer);
        management1.setLeaseDuration(2);
        management1.setLeaseEndDate(LocalDate.of(2024, 8, 10));
        management1.setLeaseEndDate(LocalDate.of(2024, 8, 8));
        management1.setLeaseId(2);
        management1.setLeaseType("Monthly");
    }
	
	@Test
	public void updateLeaseTest() {
	    // Arrange
	    when(repository.findById(management.getLeaseId())).thenReturn(Optional.of(management1));
	    when(repository.save(any(LeaseManagement.class))).thenReturn(management1);
	    
	    LeaseManagement LeaseManagement = impl.updateLease(management);
	    
	    assertEquals(management1.getCar(), LeaseManagement.getCar());
	}
	
	@Test
	public void retriveLeaseTest() {
		List<LeaseManagement> Leases = new ArrayList<>();
		Leases.add(management);
		when(repository.findAll()).thenReturn(Leases);
		List<LeaseManagement> list = impl.retriveLease();
		assertEquals(management.getLeaseId(), list.get(0).getLeaseId());
	}
	
	@Test
	public void retriveLeaseByIdTest() {
		
		when(repository.findById(management.getLeaseId())).thenReturn(Optional.of(management1));
	    when(repository.save(any(LeaseManagement.class))).thenReturn(management1);
		LeaseManagement LeaseManagement = impl.retriveLeaseById(management.getLeaseId());
		assertEquals(management1.getLeaseType(), LeaseManagement.getLeaseType());
	}
	
	@Test
	public void saveLeaseTest() {
		when(repository.save(any(LeaseManagement.class))).thenReturn(management);
		when(customerRepository.findById(management.getCustomer().getCustId())).thenReturn(Optional.of(management.getCustomer()));
		when(carRepository.findById(management.getCustomer().getCustId())).thenReturn(Optional.of(management.getCar()));
		LeaseManagement management2 =  impl.saveLease(management);
		//assertEquals(1, management2.getLeaseId());
	}

	@Test
	public void deleteLeaseByIdTest() {
	    // Arrange
	    when(repository.findById(management.getLeaseId())).thenReturn(Optional.of(management));
	    doNothing().when(repository).delete(any(LeaseManagement.class));

	    // Act
	    impl.deleteLeaseById(management.getLeaseId());

	    // Assert
	    // Verify that the repository's delete method was called with the correct object
	    verify(repository, times(1)).delete(management);

	    // Optionally verify that findById was also called
	    verify(repository, times(1)).findById(management.getLeaseId());
	}
}
