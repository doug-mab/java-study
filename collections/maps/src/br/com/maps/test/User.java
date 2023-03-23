package br.com.maps.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class User extends Identifier {
	private String username;


	public User(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getId() + " - " + this.getUsername();
	}
}
