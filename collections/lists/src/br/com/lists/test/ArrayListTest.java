package br.com.lists.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		List<String> arr = new ArrayList<String>();
		
		String item3 = "Hey World!!";
		String item2 = "Sup World~";
		String item1 = "Hello World!";
		
		arr.add(item1);
		arr.add(item2);
		arr.add(item3);
		
		String item5 = "2 plus 2 is 4!";
		String item6 = "01001000 01101001 00100001";
		String item4 = "3 is the lucky number!!";
		
		arr.add(item4);
		arr.add(item5);
		arr.add(item6);
		
		arr.forEach(item -> {
			System.out.println("Computer says: " + item);
		});
		
		Collections.sort(arr);
		
		System.out.println("==-------==--------==");
		
		arr.forEach(item -> {
			System.out.println("Computer says: " + item);
		});
	}
}
