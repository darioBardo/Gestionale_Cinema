package it.fides.cinema.dto;

import java.io.Serializable;

public class LoginDto implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5663123212710151892L;

	private String username;
	private String password;
	
	
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
