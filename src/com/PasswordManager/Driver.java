package com.PasswordManager;

/**
 * @title	Driver Class
 * @author	Nick Fulton, Jack Fogerson, Jack Gisel
 * @desc	This will handle everything needed to run JackPass.
 */
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
