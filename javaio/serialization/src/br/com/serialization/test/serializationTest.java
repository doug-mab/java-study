package br.com.serialization.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class serializationTest {
	public static void main(String[] args) throws IOException {
		Employee e = new Employee("John Doe", 29, new Date());
		
		 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.ser"));
		
		oos.writeObject(e);
		
		oos.close();
		System.out.println("Object serialized!");
	}
}