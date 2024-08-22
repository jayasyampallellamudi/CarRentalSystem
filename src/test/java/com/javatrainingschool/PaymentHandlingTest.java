package com.javatrainingschool;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
import com.javatrainingschool.entity.CarManagement;
import com.javatrainingschool.entity.CustomerManagement;
import com.javatrainingschool.entity.LeaseManagement;
import com.javatrainingschool.entity.PaymentHandling;
import com.javatrainingschool.repository.PaymentRepository;
import com.javatrainingschool.service.PaymentServiceImpl;

@SpringBootTest
public class PaymentHandlingTest {
	@Mock
	PaymentRepository repository;
	
	@InjectMocks
	PaymentServiceImpl impl = new PaymentServiceImpl();
	
    private PaymentHandling Handling;
    private PaymentHandling Handling1;
    
    private CustomerManagement customer;
    
    private CarManagement car;
    
    private LeaseManagement lease;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        car = new CarManagement();
        car.setCarId(1);
        customer = new CustomerManagement();
        customer.setCustId(1); 
        lease = new LeaseManagement();
        lease.setLeaseId(1);
        Handling = new PaymentHandling();
        Handling.setCar(car);
        Handling.setCustomer(customer);
        Handling.setAmount(2000);
        Handling.setPaymentId(101);
        Handling.setStatus("Sucessfull");
        Handling1.setLease(lease);
    }
    @BeforeEach
    public void setUp1() {
        MockitoAnnotations.openMocks(this);
        car = new CarManagement();
        car.setCarId(2);
        customer = new CustomerManagement();
        customer.setCustId(2); 
        lease = new LeaseManagement();
        lease.setLeaseId(2);
        Handling1 = new PaymentHandling();
        Handling1.setCar(car);
        Handling1.setCustomer(customer);
        Handling1.setAmount(4000);
        Handling1.setPaymentId(102);
        Handling1.setStatus("Failed");
        Handling1.setLease(lease);
    }
	
	@Test
	public void updatePaymentTest() {
	    // Arrange
	    when(repository.findById(Handling.getPaymentId())).thenReturn(Optional.of(Handling1));
	    when(repository.save(any(PaymentHandling.class))).thenReturn(Handling1);
	    
	    PaymentHandling PaymentHandling = impl.updatePayment(Handling);
	    
	    assertEquals(Handling1.getCar(), PaymentHandling.getCar());
	}
	
	@Test
	public void retrivePaymentTest() {
		List<PaymentHandling> Payments = new ArrayList<>();
		Payments.add(Handling);
		when(repository.findAll()).thenReturn(Payments);
		List<PaymentHandling> list = impl.retrivePayment();
		assertEquals(Handling.getPaymentId(), list.get(0).getPaymentId());
	}
	
	@Test
	public void retrivePaymentByIdTest() {
		
		when(repository.findById(Handling.getPaymentId())).thenReturn(Optional.of(Handling1));
	    when(repository.save(any(PaymentHandling.class))).thenReturn(Handling1);
		PaymentHandling PaymentHandling = impl.retrivePaymentById(Handling.getPaymentId());
		assertEquals(Handling1.getAmount(), PaymentHandling.getAmount());
	}
	
	@Test
	public void savePaymentTest() {
		when(repository.save(any(PaymentHandling.class))).thenReturn(Handling);
		PaymentHandling Handling2 =  impl.savePayment(Handling);
		//assertEquals(1, Handling2.getPaymentId());
		Assertions.assertThat(Handling2.getPaymentId()).isGreaterThan(0);
	}

	@Test
	public void deletePaymentByIdTest() {
	    // Arrange
	    when(repository.findById(Handling.getPaymentId())).thenReturn(Optional.of(Handling));
	    doNothing().when(repository).delete(any(PaymentHandling.class));

	    // Act
	    impl.deletePaymentById(Handling.getPaymentId());

	    // Assert
	    // Verify that the repository's delete method was called with the correct object
	    verify(repository, times(1)).delete(Handling);

	    // Optionally verify that findById was also called
	    verify(repository, times(1)).findById(Handling.getPaymentId());
	}
}
