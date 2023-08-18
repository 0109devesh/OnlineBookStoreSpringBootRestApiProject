package com.example.bookstore.models;

import java.io.Serializable;
import java.util.Date;

public class JwtResponse implements Serializable {

	
	private static final long serialVersionUID = -8091879091924046844L;

	private String jwtToken;
	
	private String username;

	private Date expiration;
	
	public JwtResponse() {
	
	}


	

	public JwtResponse(String jwtToken, String username, Date expiration) {
		super();
		this.jwtToken = jwtToken;
		this.username = username;
		this.expiration = expiration;
	}




	public String getJwtToken() {
		return jwtToken;
	}


	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}




	public Date getExpiration() {
		return expiration;
	}


	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}


	
	
	
	
	
	
}
