package br.com.sets.test;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		// Sempre mantém a ordem do comparator
		Set<Student> students = new TreeSet<>();
		students.add(new Student("Josué Martinz", 3394));
		students.add(new Student("Pedro Augusto", 8239));
		students.add(new Student("Alberto Silveira", 7105));
		students.add(new Student("Carlos de Neto", 9582));
		students.add(new Student("Sérgio Nunes", 2947));
		students.add(new Student("Matheus Cunha", 4942));
		
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println();
		
		students.add(new Student("Ana Beatriz", 8371));
		
		students.forEach(System.out::println);
	}
}
