package br.com.maps.test;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
	public static void main(String[] args) {
		Map<String, User> users = new HashMap<>();
		
		User user1 = new User("Pedrin_BR");
		User user2 = new User("Xavier9334");
		User user3 = new User("Treta-novas");
		
		users.put(user1.getId(), user1);
		users.put(user2.getId(), user2);
		users.put(user3.getId(), user3);
		
//		System.out.println(users.get(user1.getId()));
		
		users.values().forEach(System.out::println);
	}
}
