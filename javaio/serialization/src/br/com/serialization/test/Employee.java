package br.com.serialization.test;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Date;

class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private Date hiringDate;

	public Employee(String name, int age, Date hiringDate) throws FileNotFoundException {
		this.name = name;
		this.age = age;
		this.hiringDate = hiringDate;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public Date getHiringDate() {
		return hiringDate;
	}
}