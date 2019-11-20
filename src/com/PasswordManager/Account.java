package com.PasswordManager;


/**
 * @title	Account
 * @author 	Nick Fulton, Jack Fogerson, Jack Gisel 
 * @desc	Class to handle user's account info
 */
public class Account 
{
	//Variables for all accounts
	String username;
	String password;
	String website;
	
	//Account constructor
	public Account(String url, String u, String p) {
		this.website = url;
		this.username = u;
		this.password = p;
	}
	
	//Get methods for account
	public String getURL() {
		return this.website;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public Account encrypt()
	{
		// TODO Make something that makes the accounts secure.
		return null;
	}
}
