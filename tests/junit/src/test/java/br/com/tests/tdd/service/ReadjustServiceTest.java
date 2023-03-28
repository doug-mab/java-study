package br.com.tests.tdd.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.tests.tdd.model.Employee;
import br.com.tests.tdd.model.Performance;

public class ReadjustServiceTest {

	private ReadjustService service;
	private Employee employee;

	@BeforeEach
	public void init() {
		this.service = new ReadjustService();
		this.employee = new Employee("David", LocalDate.now(), new BigDecimal("8900"));
	}
	
	@Test
	public void shouldReadjustThreePercentIfThePerformanceIsPoor() {
		service.readjustSalary(employee, Performance.POOR);
								   //8900 * 1.03
		assertEquals(new BigDecimal("9167.00"), employee.getSalary());
	}
	
	@Test
	public void shouldReadjustFifteenPercentIfThePerformanceIsGood() {
		service.readjustSalary(employee, Performance.GOOD);
								   //8900 * 1.15
		assertEquals(new BigDecimal("10235.00"), employee.getSalary());
	}
	
	@Test
	public void shouldReadjustTwentyPercentIfThePerformanceIsVeryGood() {
		service.readjustSalary(employee, Performance.VERY_GOOD);
								   //8900 * 1.20
		assertEquals(new BigDecimal("10680.00"), employee.getSalary());
	}

}
