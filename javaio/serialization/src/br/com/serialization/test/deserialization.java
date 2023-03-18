package br.com.serialization.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class deserialization {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ios = new ObjectInputStream(new FileInputStream("employee.ser"));
		
		Employee e = (Employee) ios.readObject();
		System.out.println("Object Deserialized!");
		System.out.println(e.getName());
		System.out.println(e.getAge());
		System.out.println(e.getHiringDate());
		
		ios.close();
	}
}
