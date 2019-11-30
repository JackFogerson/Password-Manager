package com.PasswordManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
		checkForAccounts();
	}
	
	@SuppressWarnings("unchecked")
	public void checkForAccounts()
	{
		// In case there are no preexisting users, make a new ArrayList.
		accounts = new ArrayList<Account>();
		
		try
		{
			// First make the file.
			File probeFile = new File("data/" + myUsername + ".jpss");
			// And create the file if it doesn't already exist.
			probeFile.createNewFile();
			
			// Then create the streams.
			FileInputStream fis = new FileInputStream(probeFile);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			// Pull the ArrayList from file.
			accounts = (ArrayList<Account>) ois.readObject();
			
			// Close the streams.
			ois.close();
			fis.close();
		}
		//block of code to catch errors
		//gives error message if the file doesn't exist
		catch(FileNotFoundException e)
		{
			System.out.println("File not found.");
		}
		//gives error message if I/O operation fails or is interrupted
		catch(IOException e)
		{
			e.printStackTrace();
		}
		//prints stack trace if the class called is not found
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public void writeAccounts()
	{
		try
		{
			// First make the file.
			File probeFile = new File("data/" + myUsername + ".jpss");
			// Then create the file on the system if it doesn't exist, but it should by this point.
			//failsafe file creation to prevent errors
			probeFile.createNewFile();
			
			// Create the streams.
			FileOutputStream fos = new FileOutputStream(probeFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			// Write the ArrayList back to the file.
			oos.writeObject(accounts);
			
			// Close the streams.
			oos.close();
			fos.close();
		}
		//block of code to catch errors
		//gives error message if the file doesn't exist
		catch(FileNotFoundException e)
		{
			System.out.println("File not found.");
		}
		//gives error message if I/O operation fails or is interrupted
		catch(IOException e)
		{
			System.out.println("Error initalizing stream.");
		}
	}
	
	/**
	 * @title	addAccount Method
	 * @desc	Adds the given account to the user's list of accounts.
	 * @param	account - The account to be added to the list of accounts.
	 */
	public void addAccount(Account a)
	{
		accounts.add(a);
	}

	public void removeAccount(Account a)
	{
		accounts.remove(a);
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
