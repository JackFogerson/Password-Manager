package com.PasswordManager;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 * @title	PasswordManager Class
 * @author	Nick Fulton, Jack Fogerson, Jack Gisel
 * @desc	Class to load PM and run it 
 */
public class PasswordManager 
{
	// Create those variables.
	JFrame mainFrame;
	User myUser;
	JFrame accountFrame;
	
	/**
	 * @title	PasswordManager Constructor
	 * @param	user
	 * @desc	Pretty standard, sets the user of the manager to the one given.
	 */
	public PasswordManager(User user)
	{
		myUser = user;
	}
	
	/**
	 * @title	launch Method
	 * @desc	Acts as the first method used to run everything.
	 */
	public void launch()
	{
		buildFrame();
	}
	
	/**
	 * @title	buildFrame Method
	 * @desc	Self explanitory, just builds the frame and sets everything up.
	 */
	public void buildFrame()
	{
		// Instantiate the frame and set the layout to a border layout.
		mainFrame = new JFrame("JackPass - " + myUser.getUsername());
		mainFrame.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		JButton newAccountButton = new JButton("Add New Password");
		JButton removeAccountButton = new JButton("Remove Password");
		JButton logoutButton = new JButton("Log Out");
		AccountInfoPanel accountInfo = new AccountInfoPanel();
		AccountsPane accounts = new AccountsPane(myUser, accountInfo);
		
		// event listener so logout button works
		logoutButton.addActionListener(event -> logOut());
		
		//TODO: add actionlisteners to add/remove passwords from account
		newAccountButton.addActionListener(event -> newAccount());
		//removeAccountButton.addActionListener(event -> );


		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		mainFrame.add(newAccountButton, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		mainFrame.add(removeAccountButton, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		mainFrame.add(logoutButton, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 200;
		c.ipady = 420;
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 1;
		mainFrame.add(accounts, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 420;
		c.weightx = 0;
		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 1;
		mainFrame.add(accountInfo, c);
		
		// Finalize the frame.
		mainFrame.setSize(new Dimension(650, 500));
		mainFrame.setResizable(false);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		//Set JFrame to center of screen
		mainFrame.setLocation(d.width/2-mainFrame.getSize().width/2, d.height/2-mainFrame.getSize().height/2);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}

	/** 
	 * @title	newAccount Method
	 * @return	void
	 * @desc	gets a new frame to gather info.
	 */
	public void newAccount() {
		accountFrame = new JFrame("Add New Account");
		accountFrame.setLayout(new GridLayout(4, 1));
		
		//Create all the parts necessary for the loginFrame
		JLabel urlLabel = new JLabel("URL");
		JLabel userLabel = new JLabel("Username");
		JLabel passLabel = new JLabel("Password");
		JTextField urlBox = new JTextField();
		JTextField usernameBox = new JTextField();
		JTextField passwordBox = new JTextField();
		JButton createAccountButton = new JButton("Create a New Account");
		JButton cancelButton = new JButton("Go Back");
		
		// Add all the components in order for the positioning in the frame.
		accountFrame.add(urlLabel);
		accountFrame.add(urlBox);
		accountFrame.add(userLabel);
		accountFrame.add(usernameBox);
		accountFrame.add(passLabel);
		accountFrame.add(passwordBox);
		accountFrame.add(cancelButton);
		accountFrame.add(createAccountButton);
		
		createAccountButton.addActionListener(event -> addAccount(urlBox.getText(), usernameBox.getText(), passwordBox.getText()));
		cancelButton.addActionListener(event -> accountFrame.dispose());
		
		// Handle the rest of the frame.
		accountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		accountFrame.setSize(200, 100);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		//Sets frame to center of user's screen
		accountFrame.setLocation(d.width/2-accountFrame.getSize().width/2, d.height/2-accountFrame.getSize().height/2);
		accountFrame.pack();
		accountFrame.setVisible(true);
	}
	
	public void addAccount(String url, String u, String p) {
		Account a = new Account(url,u,p);
		myUser.addAccount(a);
		JOptionPane.showMessageDialog(null, "Account Created");
		accountFrame.dispose();
	}

	/** 
	 * @title	logOut Method
	 * @return	1 when logged out.
	 * @desc	Basically closes the frame.
	 */
	public int logOut()
	{
		JOptionPane.showMessageDialog(null, "Thank you for using JackPass! Hope to see you soon.");
		mainFrame.dispose();
		return 1;
	}
}
