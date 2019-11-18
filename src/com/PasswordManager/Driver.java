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
<<<<<<< HEAD
		LoginScreen ls = new LoginScreen();
=======
		//Program defaults with logged out user
		//prompts log-in screen and gets the account from user input
		User loggedInUser = null;
		LoginScreen ls = new LoginScreen();
		loggedInUser = ls.getUser();
		
		//Creates new instance of JackPass and launches the program
		PasswordManager pm = new PasswordManager(loggedInUser);
		pm.launch();
>>>>>>> e4e3287da8721696cb8fe0566aaee1d047cacc53
	}
	
}
