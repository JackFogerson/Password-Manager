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
 * @title	LoginScreen.java
 * @author 	Jack Fogerson, Jack Gisel, Nick Fulton
 * @desc	Class handles  logging into PasswordManager. Checks Account Storage to ensure JackPass is secure.
 */

public class LoginScreen {
	//Initialize variables.
	JFrame loginFrame;
	ArrayList<User> users;
	User myUser;
	boolean loggedIn;
	
	
	//LoginScreen constructor
	//Defaults variables as null/false, gets user database, and launches login frame
	public LoginScreen(){
		loginFrame = null;
		myUser = null;
		loggedIn = false;
		pullUsers();
		launchLoginFrame();
	}
	
	//Use this method to pull the users from file and to apply them to the arraylist full of users
	@SuppressWarnings("unchecked")
	private void pullUsers(){
		
		//If no pre-existing users, make a new ArrayList.
		users = new ArrayList<User>();
		
		try{
			// First make the file.
			File probeFile = new File("data/Users.jpss");
			// And create the file if it doesn't already exist.
			probeFile.createNewFile();
			
			// Then create the streams.
			FileInputStream fis = new FileInputStream(probeFile);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			// Pull the ArrayList from file.
			users = (ArrayList<User>) ois.readObject();
			
			// Close the streams.
			ois.close();
			fis.close();
		}
		
		//Code to catch errors
		catch(FileNotFoundException e){
			System.out.println("File not found.");
		}
		//gives error message if I/O operation fails or is interrupted
		catch(IOException e){
			System.out.println("Error initalizing stream.");
		}
		//prints stack trace if the class called is not found
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	//Use this method to write all the users back to file. This should only be called in the create account phase to
	//prevent any bugs and corrupted data
	public void writeUsers(){
		try{
			// First make the file.
			File probeFile = new File("data/Users.jpss");
			//Create the file on the system if it doesn't exist
			probeFile.createNewFile();
			
			// Create the streams.
			FileOutputStream fos = new FileOutputStream(probeFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			// Write the ArrayList back to the file.
			oos.writeObject(users);
			
			// Close the streams.
			oos.close();
			fos.close();
		}
		
		//block of code to catch errors
		catch(FileNotFoundException e){
			System.out.println("File not found.");
		}
		//gives error message if I/O operation fails or is interrupted
		catch(IOException e){
			System.out.println("Error initalizing stream.");
		}
		
		//Logs in
		loggedIn = true;
	}
	
	//Launches the frame that handles logging in and creating an account.
	private void launchLoginFrame(){
		// Make the JFrame, and then make it a GridLayout.
		loginFrame = new JFrame("JackPass - Login or Create Account");
		loginFrame.setLayout(new GridLayout(3, 1));
		
		//Create all the parts necessary for the loginFrame
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
		
		//Make an action listener for both create account and log in
		//Gets user input and sends that text to those methods
		createAccountButton.addActionListener(event -> createAccount(usernameBox.getText(), passwordBox.getText()));
		logInButton.addActionListener(event -> logIn(usernameBox.getText(), passwordBox.getText()));
		
		// Handle rest of the frame.
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setSize(200, 100);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		//Sets frame to center of user's screen
		loginFrame.setLocation(d.width/2-loginFrame.getSize().width/2, d.height/2-loginFrame.getSize().height/2);
		loginFrame.pack();
		loginFrame.setVisible(true);
	}
	
	//Creates an account with the given variables if given username does not already exist
	private void createAccount(String u, String p) {	
		//Create a user instance using the username and password provided.
		User newUser = new User(u, p);
		
		//if no username
		if(newUser.getUsername() == "" || newUser.getUsername() == null) {
			JOptionPane.showMessageDialog(null, "Enter a username to continue");
		}
		
		//if no password
		else if(p == null) {
			JOptionPane.showMessageDialog(null, "Enter a password to continue");
		}
		
		//else, continue creating account
		else
		{			
			//Method if the ArrayList already has a user with that username.
			if(users.contains(newUser)){
				// Display that this option is taken.
				JOptionPane.showMessageDialog(null, "Sorry, that username is taken.");
			}
			
			else {
				// Add the new user to the ArrayList and set it as the active user.
				users.add(newUser);
				myUser = newUser;
			
				// Write this new user to file and display account creation message.
				writeUsers();
				JOptionPane.showMessageDialog(null, "Welcome to JackPass, " + myUser.getUsername() + "! We hope you enjoy having a secure password manager.");
				loggedIn();
			}
		}
	}
	
	//Attempts to log into JackPass using the supplied username and password
	public void logIn(String u, String p){
		// Creates a user instance using the username and password provided.
		User newUser = new User(u, p);
		
		
		//if no username entered
		if(newUser.getUsername() == "" || newUser.getUsername() == null) {
			JOptionPane.showMessageDialog(null, "Enter a username to continue");
		}
		
		
		// If the username is in the User database
		else if(users.contains(newUser)) {
			
			// If the passwords match.
			if(users.get(users.indexOf(newUser)).getPassword().equals(p)){
				// Make the new account the active user and display log-in message.
				myUser = newUser;
				loggedIn = true;
				JOptionPane.showMessageDialog(null, "You have successfully logged in, " + newUser.getUsername() + ". Enjoy JackPass!");
				loggedIn();
			}
			
			//No password = no entry.
			else if(p == null){
				//if correct username, null password
				JOptionPane.showMessageDialog(null, "Enter password");
			}
			//Wrong password = no entry.
			else {
				//if correct username, wrong password
				JOptionPane.showMessageDialog(null, "Sorry, that is the incorrect password. Please try again!");
			}
		}
		
		// If database doesn't contain username.
		else {
			JOptionPane.showMessageDialog(null, "We do not have an account with that Username. Please create an account or change the Username");
		}
	}

	//Removes Login Frame, Moves to main page
	private void loggedIn(){
		loginFrame.dispose();
		PasswordManager pm = new PasswordManager(myUser);
		pm.launch();
	}
}
