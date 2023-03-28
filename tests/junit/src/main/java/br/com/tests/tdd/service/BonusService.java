package br.com.tests.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.tests.tdd.model.Employee;

public class BonusService {
	public BigDecimal calculateBonus(Employee employee) {
		BigDecimal value = employee.getSalary().multiply(new BigDecimal("0.1"));
		if (value.compareTo(new BigDecimal("1000")) > 0) {
			throw new IllegalArgumentException("This employee's salary surpasses the bonus limit.");
		}
		return value.setScale(2, RoundingMode.HALF_UP);
	}
}
