package br.com.sets.test;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetTest {
	public static void main(String[] args) {
		Set<Student> students = new LinkedHashSet<>();
		students.add(new Student("Josué Martinz", 3394));
		students.add(new Student("Pedro Augusto", 8239));
		students.add(new Student("Alberto Silveira", 7105));
		students.add(new Student("Carlos de Neto", 9582));
		students.add(new Student("Sérgio Nunes", 2947));
		students.add(new Student("Matheus Cunha", 4942));
		
		// Ordem de entrada
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
