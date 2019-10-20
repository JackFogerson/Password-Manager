package com.PasswordManager;

public class Driver 
{
	public static void main(String[] args)
	{
		User loggedInUser = null;
		LoginScreen ls = new LoginScreen();
		loggedInUser = ls.getUser();
		
		PasswordManager pm = new PasswordManager(loggedInUser);
		pm.launch();
	}
}
