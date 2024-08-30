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
import com.javatrainingschool.repository.CarRepository;
import com.javatrainingschool.service.CarServiceImpl;

@SpringBootTest
public class CarManagementTest {
	@Mock
	CarRepository repository;

	@InjectMocks
	CarServiceImpl impl = new CarServiceImpl();

	private CarManagement management;
	private CarManagement management1;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		management = new CarManagement();
		management.setAccidentHistory("No Accidents");
		management.setCarId(1);
		management.setColor("red");
		management.setCompany("TATA");
		management.setLicensePlateNumber("AP 39 AA 9999");
		management.setModel("Tigore");
		management.setSeatingCapacity(5);
		management.setVin("AAA12345678901234");
		management.setYear(2020);
	}

	@BeforeEach
	public void setUp1() {
		MockitoAnnotations.openMocks(this);
		management1 = new CarManagement();
		management1.setAccidentHistory("One Accidents");
		management1.setCarId(2);
		management1.setColor("white");
		management1.setCompany("Maruti Suzuki");
		management1.setLicensePlateNumber("AP 39 AA 8888");
		management1.setModel("Eartiga");
		management1.setSeatingCapacity(7);
		management1.setVin("AAA12345678904321");
		management1.setYear(2022);
	}

	@Test
	public void updateCarTest() {
		// Arrange
		when(repository.findById(management.getCarId())).thenReturn(Optional.of(management1));
		when(repository.save(any(CarManagement.class))).thenReturn(management1);

		CarManagement CarManagement = impl.updateCar(management);

		assertEquals(management1.getCompany(), CarManagement.getCompany());
	}

	@Test
	public void retriveCarTest() {
		List<CarManagement> Cars = new ArrayList<>();
		Cars.add(management);
		when(repository.findAll()).thenReturn(Cars);
		List<CarManagement> list = impl.retriveCar();
		assertEquals(management.getModel(), list.get(0).getModel());
	}

	@Test
	public void retriveCarByIdTest() {

		when(repository.findById(management.getCarId())).thenReturn(Optional.of(management1));
		when(repository.save(any(CarManagement.class))).thenReturn(management1);
		CarManagement CarManagement = impl.retriveCarById(management.getCarId());
		assertEquals(management1.getCompany(), CarManagement.getCompany());
	}

	@Test
	public void saveCarTest() {
		when(repository.save(any(CarManagement.class))).thenReturn(management);
		CarManagement management2 = impl.saveCar(management);
		// assertEquals(1, management2.getCarId());
		Assertions.assertThat(management2.getCarId()).isGreaterThan(0);
	}

	@Test
	public void deleteCarByIdTest() {
		// Arrange
		when(repository.findById(management.getCarId())).thenReturn(Optional.of(management));
		doNothing().when(repository).delete(any(CarManagement.class));

		// Act
		impl.deleteCarById(management.getCarId());

		// Assert
		// Verify that the repository's delete method was called with the correct object
		verify(repository, times(1)).delete(management);

		// Optionally verify that findById was also called
		verify(repository, times(1)).findById(management.getCarId());
	}
}
