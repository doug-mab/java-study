package br.com.lists.test;

import java.util.Calendar;
import java.util.Date;

public class Book implements Comparable<Book> {
	private String author;
	private String title;
	
	public Book(String author, String title) {
		this.author = author;
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}
	
	public String getTitle() {
		return title;
	}

	@Override
	public int compareTo(Book o) {
		
		return title.compareTo(o.getTitle());
	}
	
	@Override
	public String toString() {
		return String.format("%s (%s)", title, author);
	}
	
}
