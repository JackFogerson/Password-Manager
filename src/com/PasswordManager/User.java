package com.PasswordManager;

import java.io.Serializable;

/**
 * @title	User Class
 * @author	Nick Fulton, Jack Fogerson, Jack Gisel
 * @desc	This object is meant to handle all information related to the users of JackPass. This includes all
 * 			usernames and passwords for the accounts.
 */
public class User implements Comparable<User> , Serializable
{
	// Create those needed variables.
	private static final long serialVersionUID = 1L;
	String myUsername;
	String myPassword;
	
	/**
	 * @title	User Constructor
	 * @param	username - The username variable.
	 * @param	password - The password variable.
	 */
	public User(String username, String password)
	{
		// Set those variables.
		myUsername = username;
		myPassword = password;
	}

	/**
	 * @title	compareTo Method
	 * @desc	Returns 0 if the usernames are the same, 1 if not.
	 */
	public int compareTo(User u) 
	{
		if(u.getUsername().equals(this.getUsername()))
			return 0;
		return 1;
	}
	
	/**
	 * @title	equals Method
	 * @desc	Calls the modified compareTo and if that returns 0, then return true. If not then return
	 * 			false.
	 */
	@Override
	public boolean equals(Object u)
	{
		User myU = (User) u;
		if(this.compareTo(myU) == 0)
			return true;
		return false;
	}
	
	/**
	 * @title	getUsername
	 * @return	Username
	 */
	public String getUsername()
	{
		return myUsername;
	}
	
	/**
	 * @title	getPassword
	 * @return	Password
	 */
	public String getPassword()
	{
		return myPassword;
	}
	
	/**
	 * @title	toString
	 * @return	myUsername
	 */
	@Override
	public String toString()
	{
		return myUsername;
	}
}
