package com.PasswordManager;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @title	LoginScreen
 * @author 	Nick Fulton, Jack Fogerson, Jack Gisel
 * @desc	We want this class to handle everything related to logging into the actual PasswordManager. This means
 * 			all account storage for jackpass accounts.
 */
public class LoginScreen 
{
	// Create some of those needed variables.
	JFrame loginFrame;
	ArrayList<User> users;
	User myUser;
	boolean loggedIn;
	
	/**
	 * @title	LoginScreen constructor
	 * @desc	Basic stuff.
	 */
	public LoginScreen()
	{
		loginFrame = null;
		myUser = null;
		loggedIn = false;
		pullUsers();
		launchLoginFrame();
	}
	
	/**
	 * @title	pullUsers method
	 * @desc	Use this method to pull the users from file and to apply them to the arraylist full of
	 * 			users.
	 */
	@SuppressWarnings("unchecked")
	private void pullUsers()
	{
		// In case there are no preexisting users, make a new arraylist.
		users = new ArrayList<User>();
		
		try
		{
			// First make the file.
			File probeFile = new File("Users.jpss");
			// And create the file if it doesn't already exist.
			probeFile.createNewFile();
			
			// Then create the streams.
			FileInputStream fis = new FileInputStream(probeFile);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			// Pull the arraylist from file.
			users = (ArrayList<User>) ois.readObject();
			
			// Close the streams.
			ois.close();
			fis.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found.");
		}
		catch(IOException e)
		{
			System.out.println("Error initalizing stream.");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * @title	writeUsers Method
	 * @desc	Use this method to write all the users back to file. This should only be called in the create
	 * 			account phase to prevent any bugs and corrupted data.
	 */
	public void writeUsers()
	{
		try
		{
			// First make the file.
			File probeFile = new File("Users.jpss");
			// Then create the file on the system if it doesn't exist, but it should by this point.
			probeFile.createNewFile();
			
			// Create the streams.
			FileOutputStream fos = new FileOutputStream(probeFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			// Write the arraylist back to the file.
			oos.writeObject(users);
			
			// Close the streams.
			oos.close();
			fos.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found.");
		}
		catch(IOException e)
		{
			System.out.println("Error initalizing stream.");
		}
		
		// We are now logged in.
		loggedIn = true;
	}
	
	/**
	 * @title	launchLogInFrame
	 * @desc	This method will launch the frame that handles logging in and creating an account with JackPass.
	 */
	private void launchLoginFrame()
	{
		// Make the frame, and then make it a GridLayout.
		loginFrame = new JFrame("JackPass - Login");
		loginFrame.setLayout(new GridLayout(3, 1));
		
		// Make all parts of the frame.
		JLabel userLabel = new JLabel("Username");
		JLabel passLabel = new JLabel("Password");
		JTextField usernameBox = new JTextField();
		JTextField passwordBox = new JTextField();
		JButton createAccountButton = new JButton("Create a New Account");
		JButton logInButton = new JButton("Log In");
		
		// Add all the components in order for the positioning in the frame.
		loginFrame.add(userLabel);
		loginFrame.add(usernameBox);
		loginFrame.add(passLabel);
		loginFrame.add(passwordBox);
		loginFrame.add(createAccountButton);
		loginFrame.add(logInButton);
		
		// Make an action listener for both create account and log in, which will be dealt with in other methods.
		createAccountButton.addActionListener(event -> createAccount(usernameBox.getText(), passwordBox.getText()));
		logInButton.addActionListener(event -> logIn(usernameBox.getText(), passwordBox.getText()));
		
		// Handle the rest of the frame.
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setSize(200, 100);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		loginFrame.setLocation(d.width/2-loginFrame.getSize().width/2, d.height/2-loginFrame.getSize().height/2);
		loginFrame.pack();
		loginFrame.setVisible(true);
	}
	
	/**
	 * @title	createAccount Method
	 * @param 	u - The username variable.
	 * @param	p - The password variable.
	 * @desc	Creates an account with the given variables if one doesn't already exist with supplied username.
	 */
	private void createAccount(String u, String p)
	{
		// Create a new user using the username and password provided.
		User newUser = new User(u, p);
		
		// If the arraylist already has a user with that username.
		if(users.contains(newUser))
		{
			// Display that this option is taken.
			JOptionPane.showMessageDialog(null, "That username is taken.");
		}
		// If not then we are good.
		else
		{
			// Add the new user to the arraylist and set it as the active user.
			users.add(newUser);
			myUser = newUser;
			
			// Write this new user to file and display that the account was created.
			writeUsers();
			JOptionPane.showMessageDialog(null, "Created Account");
		}
	}
	
	/**
	 * @title	logIn Method
	 * @param	u - The username variable.
	 * @param	p - The password variable.
	 * @desc	Attempts to log into JackPass using the supplied username and password.
	 */
	public void logIn(String u, String p)
	{
		// Create a user using the username and password provided.
		User newUser = new User(u, p);
		
		// If there is a user with the same username continue on.
		if(users.contains(newUser))
		{
			// If the passwords match.
			if(users.get(users.indexOf(newUser)).getPassword().equals(p))
			{
				// Make the new account the active user and state we are logged in.
				myUser = newUser;
				loggedIn = true;
				JOptionPane.showMessageDialog(null, "Logged In ");
			}
			// No password = no entry.
			else
			{
				JOptionPane.showMessageDialog(null, "Incorrect Username or Password.");
			}
		}
		// No account with this information exists.
		else
		{
			JOptionPane.showMessageDialog(null, "Incorrect Username or Password.");
		}
	}
	
	/**
	 * @title	getUser Method
	 * @desc	Returns the logged in user once there is one.
	 * @return	User
	 */
	public User getUser()
	{
		// While there is not an account logged in, essentially do nothing.
		while(loggedIn == false)
		{
			// TODO For some reason, the rest of this method doesn't run unless this is here so fix this lol
			// EsSeNtIaLlY dO nOtHiNg
			System.out.println("Not Logged In");
		}
		
		// Get rid of the log in frame when we are logged in.
		loginFrame.dispose();
		
		// Return the logged in user.
		return myUser;
	}
}
