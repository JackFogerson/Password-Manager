package com.PasswordManager;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @title	PasswordManager Class
 * @author	Nick Fulton, Jack Fogerson, Jack Gisel
 *
 */
public class PasswordManager 
{
	// Create those variables.
	JFrame mainFrame;
	User myUser;
	
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
		//newAccountButton.addActionListener(event -> );
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
