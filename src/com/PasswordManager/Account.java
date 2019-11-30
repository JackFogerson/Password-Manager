package com.PasswordManager;

import java.io.Serializable;

/**
 * @title	Account
 * @author 	Nick Fulton, Jack Fogerson, Jack Gisel 
 * @desc	Class to handle user's account info
 */
public class Account implements Serializable
{
	private static final long serialVersionUID = 1L;
	//Variables for all accounts
	String username;
	String password;
	String website;
	String name;
	String additionalDetails;
	
	//Account constructor
	public Account(String url, String u, String p, String additional) 
	{
		this.website = url;
		this.username = u;
		this.password = p;
		this.additionalDetails = additional;
	}
	
	public void setName(String n)
	{
		this.name = n;
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
	
	public String getName()
	{
		return this.name;
	}
	
	public String getAdditionalDetails()
	{
		return this.additionalDetails;
	}

	public Account encrypt()
	{
		// TODO Make something that makes the accounts secure.
		// Need to get someone to work on this
		return this;
	}
}
