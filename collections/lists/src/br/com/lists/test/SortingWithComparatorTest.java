package br.com.lists.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingWithComparatorTest {

	public static void main(String[] args) {
		List<Book> bookShelf = new ArrayList<>();

		bookShelf.add(new Book("Machado de Assis", "Dom Casmurro"));
		bookShelf.add(new Book("Chico Buarque", "Anos de chumbo"));
		bookShelf.add(new Book("Antoine de Saint-Exupéry", "O Pequeno Príncipe"));
		bookShelf.add(new Book("Graciliano Ramos", "Vidas Secas"));
		bookShelf.add(new Book("Euclides da Cunha", "Os Sertões"));
		bookShelf.add(new Book("George Orwell", "A revolução dos bixos"));

		Collections.sort(bookShelf);

		System.out.println("Sorting A - Z");
		for (Book book : bookShelf) {
			System.out.println(book);
		}
		System.out.println();

		Collections.sort(bookShelf, (o1, o2) -> o1.compareTo(o2) * -1);

		System.out.println("Sorting Z - A");
		for (Book book : bookShelf) {
			System.out.println(book);
		}
		System.out.println();

		Collections.shuffle(bookShelf);

		System.out.println("Shuffled");
		for (Book book : bookShelf) {
			System.out.println(book);
		}
	}
}