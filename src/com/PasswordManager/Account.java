package com.PasswordManager;

import java.io.Serializable;
import java.util.Random;

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
	String key = getSaltString();
	
	//Account constructor
	public Account(String url, String n, String u, String p, String additional) 
	{
		this.name = n;
		this.website = url;
		this.username = u;
		Encryptor enc = new Encryptor();
		try 
		{
			this.password = enc.encrypt(p, key);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
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
	
	public String getPassword() throws Exception 
	{
		Encryptor enc = new Encryptor();
		return enc.decrypt(this.password, key);
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getAdditionalDetails()
	{
		return this.additionalDetails;
	}

	protected String getSaltString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 18) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}
}
