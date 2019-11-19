package com.PasswordManager;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @title	User Class
 * @author	Nick Fulton, Jack Fogerson, Jack Gisel
 * @desc	Class to handle all JackPass user info
 */
public class User implements Comparable<User> , Serializable
{
	// Create those needed variables.
	private static final long serialVersionUID = 1L;
	String myUsername;
	String myPassword;
	ArrayList<Account> accounts;
	
	/**
	 * @title	User Constructor
	 * @param	username - The username variable.
	 * @param	password - The password variable.
	 */
	public User(String username, String password)
	{
		// Set User variables.
		myUsername = username;
		myPassword = password;
		accounts = new ArrayList<Account>();
	}
	
	/**
	 * @title	addAccount Method
	 * @desc	Adds the given account to the user's list of accounts.
	 * @param	account - The account to be added to the list of accounts.
	 */
	public void addAccount(Account a)
	{
		a = a.encrypt();
		accounts.add(a);
	}
	
	/**
	 * @title	getAccounts Method
	 * @desc	Returns the arraylist of all accounts associated with the user.
	 */
	public ArrayList<Account> getAccounts()
	{
		return accounts;
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
	 * @desc	Calls the modified compareTo and if that returns 0, return true. If not return false.
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
	 * @return	User's password
	 */
	public String getPassword()
	{
		return myPassword;
	}
	
	/**
	 * @title	toString
	 * @return	User's username
	 */
	@Override
	public String toString()
	{
		return myUsername;
	}
}
