package com.PasswordManager;

import javax.swing.*;
import java.awt.*;

/**
 * @title	AccountInfoPanel.java
 * @author 	Jack Fogerson, Jack Gisel, Nick Fulton
 * @desc	Displays a single account's information
 */

public class AccountInfoPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	//Initialize account variables
	//myURL, myUserName, myPassword are mandatory variables
	//mySiteName and myAdditionalDetails are optional variables
	String myURL;
	String mySiteName;
	String myUserName;
	String myPassword;
	String myAdditionalDetails;
	Account myAccount;
	
	//create JLabels for use in panel
	JLabel inputName;
	JLabel inputUsername;
	JLabel inputPassword;
	JLabel inputURL;
	JLabel inputAdditional;
	
	//AccountInfoPanel Constructor
	public AccountInfoPanel(){
		myURL = "";
		mySiteName = "";
		myUserName = "";
		myPassword = "";
		myAdditionalDetails = "";
		myAccount = null;
		buildPanel();
	}
	
	//AccountInfoPanel Constructor for existing account
	public AccountInfoPanel(Account a) throws Exception {
		myURL = a.getWebsiteURL();
		mySiteName = a.getWebsiteName();
		myUserName = a.getUsername();
		myPassword = a.getPassword();
		myAdditionalDetails = a.getAdditionalDetails();
		myAccount = a;
		buildPanel();
	}
	
	//AccountInfoPanel Constructor
	public AccountInfoPanel(String accountName, String username, String url, String additionalDetails){
		myURL = url;
		mySiteName = accountName;
		myUserName = username;
		myAdditionalDetails = additionalDetails;
		myAccount = null;
		buildPanel();
	}
	
	//Setter Methods
	public void setURL(String u){
		if(u != null){
			inputURL.setText(u);
			myURL = u;
		}
		else {
			inputURL.setText(" ");
			myURL = " ";
		}
	}
	
	public void setSiteName(String a){
		if(a != null){
			inputName.setText(a);
			mySiteName = a;
		}
		else {
			inputName.setText(" ");
			mySiteName = " ";
		}
	}
	
	public void setUserName(String u){
		if(u != null){
			inputUsername.setText(u);
			myUserName = u;
		}
		else {
			inputUsername.setText(" ");
			myUserName = " ";
		}
	}
	
	public void setPassword(String p){
		if(p != null){
			inputPassword.setText(p);
			myPassword = p;
		}
		else {
			inputPassword.setText(" ");
			myPassword = " ";
		}
	}

	public void setAdditionalDetails(String a){
		if(a != null){
			inputAdditional.setText("<html>" + a + "</html>");
			myAdditionalDetails = a;
		}
		else {
			inputAdditional.setText(" ");
			myAdditionalDetails = " ";
		}
	}
	
	//Build Account Panel
	public void buildPanel(){
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel accountURL = new JLabel("Site URL:");
		JLabel accountName = new JLabel("Site Name:");
		JLabel accountUsername = new JLabel("Username:");
		JLabel accountPassword = new JLabel("Password:");
		JLabel accountAdditionalDetails = new JLabel("Additional Details:");
		
		inputName = new JLabel("");
		inputUsername = new JLabel("");
		inputPassword = new JLabel("");
		inputURL = new JLabel("");
		inputAdditional = new JLabel("");
		
		c.insets = new Insets(0, 10, 0, 10);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		add(accountName, c);
		
		c.gridx = 1;
		c.gridy = 0;
		add(inputName, c);
		
		c.gridy = 1;
		c.gridx = 0;
		add(accountUsername, c);
		
		c.gridx = 1;
		c.gridy = 1;
		add(inputUsername, c);
		
		c.gridy = 2;
		c.gridx = 0;
		add(accountPassword, c);
		
		c.gridx = 1;
		c.gridy = 2;
		add(inputPassword, c);
		
		c.gridy = 3;
		c.gridx = 0;
		add(accountURL, c);
		
		c.gridy = 3;
		c.gridx = 1;
		add(inputURL, c);
		
		c.gridy = 4;
		c.gridx = 0;
		add(accountAdditionalDetails, c);
		
		c.gridx = 1;
		c.gridy = 4;
		c.gridheight = 5;
		add(inputAdditional, c);
		
	}
	
	//remove and rebuild panel
	public void rebuild(){
		removeAll();
		buildPanel();
	}
}
