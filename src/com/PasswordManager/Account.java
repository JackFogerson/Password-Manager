package com.PasswordManager;

import java.io.Serializable;
import java.util.Random;

/**
 * @title	Account.java
 * @author 	Jack Fogerson, Jack Gisel, Nick Fulton  
 * @desc	Class to handle user's account info
 */

public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//Initialize account variables
	//websiteURL, username, password are mandatory variables
	//websiteName and additionalDetails are optional variables
	String websiteURL;
	String websiteName = "";
	String username;
	String password;
	String additionalDetails = "";
	String key = getSaltString();
	
	//Account constructor
	public Account(String url, String n, String u, String p, String additional){
		//set basic account variables
		this.websiteURL = url;
		this.websiteName = n;
		this.username = u;
		this.additionalDetails = additional;

		//encryptor to use for password variable
		Encryptor enc = new Encryptor();
		
		try {
			this.password = enc.encrypt(p, key);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	//Setter Methods for Account variables
	public void setWebsiteURL(String url){ this.websiteURL = url; }
	
	public void setWebsiteName(String n){ this.websiteName = n; }	
	
	public void setUsername(String u){ this.username = u; }
	
	//Password Setter requires encryptor to ensure variable is safe
	public void setPassword(String p){
		Encryptor enc = new Encryptor();
		
		try {
			this.password = enc.encrypt(p, key);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void setDetails(String additional){ this.additionalDetails = additional; }
	
	//Getter methods for Account variables
	public String getWebsiteURL(){ return this.websiteURL; }
	
	public String getWebsiteName(){ return this.websiteName; }
	
	public String getUsername(){ return this.username; }
	
	//Password Get requires decryption to access
	public String getPassword() throws Exception 
	{
		Encryptor enc = new Encryptor();
		return enc.decrypt(this.password, key);
	}
	
	public String getAdditionalDetails(){ return this.additionalDetails; }

	//Used for key variable, encryption
	//randomizes 18 digit key for use in encryption
	protected String getSaltString(){
		//key creation set-up
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		
		//key builder
		while (salt.length() < 18){ // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		
		String saltStr = salt.toString();
		return saltStr;
	}
}
