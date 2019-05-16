package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sqlLink.Link;

public abstract class Person {
	String name;
	String password;
	
	protected Connection conn = new Link().link();
	protected ResultSet set = null;
	protected PreparedStatement stmt;
	protected String passwordcheck;
	
	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
