package br.com.tests.tdd.service;

import java.math.BigDecimal;

import br.com.tests.tdd.model.Employee;
import br.com.tests.tdd.model.Performance;

public class ReadjustService {
	public void readjustSalary(Employee employee, Performance performance) {
		BigDecimal percentage = null;

		switch(performance) {
			case POOR:
				percentage = new BigDecimal("1.03");
				break;
			case GOOD:
				percentage = new BigDecimal("1.15");
				break;
			case VERY_GOOD:
				percentage = new BigDecimal("1.20");
				break;
		}
		
		BigDecimal newSalary = employee.getSalary().multiply(percentage);
		employee.setSalary(newSalary);
	}
}
