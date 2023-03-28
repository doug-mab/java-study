package br.com.tests.tdd.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

import br.com.tests.tdd.model.Employee;

public class BonusServiceTest {
	
	BonusService service = new BonusService();

	@Test
	public void bonusShouldNotGiveABonusForHighSalaries() {
		assertThrows(IllegalArgumentException.class,
				() -> service.calculateBonus(new Employee("Louis", LocalDate.now(), new BigDecimal("11000"))));
	}

	@Test
	public void bonusShouldBe10PercentOfTheGivenSalary() {
		BigDecimal bonus = service.calculateBonus(new Employee("Louis", LocalDate.now(), new BigDecimal("8500")));

		assertEquals(new BigDecimal("850.00"), bonus);
	}

	@Test
	public void bonusShouldBeGivenToASalaryWithTheExactLimittedValue() {
		BigDecimal bonus = service.calculateBonus(new Employee("Louis", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
