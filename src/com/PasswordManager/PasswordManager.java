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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
	JScrollPane accountsScrollPane;
	JPanel accountList;
	
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
	 * @desc	Builds the frame and sets everything up.
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
		accountsScrollPane = new JScrollPane();
		accountsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		//add accounts to PM
		populateAccounts();
		
		// event listener so logout button works
		logoutButton.addActionListener(event -> logOut());
		
		//Launches new JFrame to create new saved account
		newAccountButton.addActionListener(event -> newAccount());
		
		//TODO: add actionlistener to remove passwords from account
		//Either by clicking on button to remove or typing in the url
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
		mainFrame.add(accountsScrollPane, c);
		
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
	 * @desc	gets a new frame to gather info about new account.
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
		
		//Create Account button listener adds new account to User
		createAccountButton.addActionListener(event -> addAccount(urlBox.getText(), usernameBox.getText(), passwordBox.getText()));
		//Goes back to previous page
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
		
	//adds accounts to side panel for viewing
	public void populateAccounts()
	{
		JPanel accounts = new JPanel(); 
		accounts.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		
		for(Account a: myUser.getAccounts())
		{
			AccountsPaneItem api = new AccountsPaneItem(a);
			//Shows Accounts when button clicked
			api.addActionListener(event -> showAccount(api));
			accounts.add(api, c);
			c.gridy++;
		}

		accountsScrollPane.setViewportView(accounts);
	}
	
	//shows account info when button is clicked
	public void showAccount(AccountsPaneItem a) {
		JFrame account = new JFrame();
		account.setLayout(new GridLayout(4, 1));
		
		JLabel urlLabel = new JLabel("URL");
		JLabel userLabel = new JLabel("Username");
		JLabel passLabel = new JLabel("Password");
		String url = a.getAccount().getURL();
		JLabel urlBox = new JLabel(url);
		String user = a.getAccount().getUsername();
		JLabel userBox = new JLabel(user);
		String pass = a.getAccount().getPassword();
		JLabel passBox = new JLabel(pass);
		JButton cancelButton = new JButton("Go Back");
		
		// Add all the components in order for the positioning in the frame.
		account.add(urlLabel);
		account.add(urlBox);
		account.add(userLabel);
		account.add(userBox);
		account.add(passLabel);
		account.add(passBox);
		account.add(cancelButton);
		
		//Goes back to previous page
		cancelButton.addActionListener(event -> account.dispose());
		
		// Handle the rest of the frame.
		account.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		account.setSize(200, 100);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		//Sets frame to center of user's screen
		account.setLocation(d.width/2-account.getSize().width/2, d.height/2-account.getSize().height/2);
		account.pack();
		account.setVisible(true);
	}
	
	//adds accounts to side frame
	public void addAccount(String url, String u, String p) {
		Account a = new Account(url,u,p);
		myUser.addAccount(a);
		JOptionPane.showMessageDialog(null, "Account Created");
		accountFrame.dispose();
		populateAccounts();
		myUser.writeAccounts();
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
