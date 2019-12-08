package com.PasswordManager;

import javax.swing.*;
import java.awt.*;


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
	ButtonGroup bg;
	AccountInfoPanel accountInfo;
	Account selected;
	
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
		accountInfo = new AccountInfoPanel();
		accountsScrollPane = new JScrollPane();
		accountsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		//add accounts to PM
		populateAccounts();
		
		// event listener so logout button works
		logoutButton.addActionListener(event -> logOut());
		
		//Launches new JFrame to create new saved account
		newAccountButton.addActionListener(event -> newAccount());

		// Remove selected account
		removeAccountButton.addActionListener(event -> removeAccount(selected));
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 50;
		c.weighty = 1;
		mainFrame.add(newAccountButton, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		c.ipady = 50;
		c.weighty = 1;
		mainFrame.add(removeAccountButton, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		c.ipady = 50;
		c.weighty = 1;
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
		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 1;
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
		accountFrame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//Create all the parts necessary for the loginFrame
		JLabel urlLabel = new JLabel("URL");
		JLabel userLabel = new JLabel("Username");
		JLabel passLabel = new JLabel("Password");
		JLabel nameLabel = new JLabel("Site Name");
		JLabel additionalDetailsLabel = new JLabel("Details");
		
		JTextField urlBox = new JTextField();
		JTextField usernameBox = new JTextField();
		JTextField passwordBox = new JTextField();
		JTextField nameBox = new JTextField();
		JTextArea detailsBox = new JTextArea(4, 10);
		
		JButton createAccountButton = new JButton("Create a New Account");
		JButton cancelButton = new JButton("Go Back");
		
		// Add all the components in order for the positioning in the frame.
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		accountFrame.add(urlLabel, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		accountFrame.add(urlBox, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		accountFrame.add(nameLabel, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		accountFrame.add(nameBox, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		accountFrame.add(userLabel, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		accountFrame.add(usernameBox, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		accountFrame.add(passLabel, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		accountFrame.add(passwordBox, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		accountFrame.add(additionalDetailsLabel, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 4;
		accountFrame.add(detailsBox, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 8;
		c.gridwidth = 1;
		c.gridheight = 1;
		accountFrame.add(cancelButton, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 8;
		c.gridwidth = 1;
		c.gridheight = 1;
		accountFrame.add(createAccountButton, c);

		
		//Create Account button listener adds new account to User
		createAccountButton.addActionListener(event -> addAccount(urlBox.getText(), nameBox.getText(), usernameBox.getText(), passwordBox.getText(), detailsBox.getText()));
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
		bg = new ButtonGroup();
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
			api.addActionListener(event -> {
				selected = a;
				try {
					showAccount(a);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			accounts.add(api, c);
			bg.add(api);
			c.gridy++;
		}

		accountsScrollPane.setViewportView(accounts);
	}
	
	public void showAccount(Account a) throws Exception {
		accountInfo.setAccountName(a.getName());
		accountInfo.setUserName(a.getUsername());
		accountInfo.setPassword(a.getPassword());
		accountInfo.setURL(a.getURL());
		accountInfo.setAdditionalDetails(a.getAdditionalDetails());
	}
	
	//adds accounts to side frame
	public void addAccount(String url, String name, String u, String p, String ad) {
		Account a = new Account(url, name, u, p, ad);
		myUser.addAccount(a);
		JOptionPane.showMessageDialog(null, "Account Created");
		accountFrame.dispose();
		populateAccounts();
		myUser.writeAccounts();
	}

	public void removeAccount(Account toBeRemoved) {
		myUser.removeAccount(toBeRemoved);
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
