package com.PasswordManager;

import java.io.Serializable;

public class User implements Comparable<User> , Serializable
{
	private static final long serialVersionUID = 1L;
	String myUsername;
	String myPassword;
	
	public User(String username, String password)
	{
		myUsername = username;
		myPassword = password;
	}

	public int compareTo(User u) 
	{
		if(u.getUsername().equals(this.getUsername()))
			return 0;
		return 1;
	}
	
	@Override
	public boolean equals(Object u)
	{
		User myU = (User) u;
		if(this.compareTo(myU) == 0)
			return true;
		return false;
	}
	
	public String getUsername()
	{
		return myUsername;
	}
	
	public String getPassword()
	{
		return myPassword;
	}
	
	@Override
	public String toString()
	{
		return myUsername;
	}
}
