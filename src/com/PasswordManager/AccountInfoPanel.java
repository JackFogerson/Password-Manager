package com.PasswordManager;

import javax.swing.*;
import java.awt.*;

//TODO: Add functionality to the class
public class AccountInfoPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	String myAccountName, myUserName, myPassword, myURL, myAdditionalDetails;
	Account myAccount;
	
	JLabel inputName;
	JLabel inputUsername;
	JLabel inputPassword;
	JLabel inputURL;
	JLabel inputAdditional;
	
	public AccountInfoPanel()
	{
		myAccountName = "";
		myUserName = "";
		myPassword = "";
		myURL = "";
		myAdditionalDetails = "";
		myAccount = null;
		buildPanel();
	}
	
	public AccountInfoPanel(Account a) throws Exception {
		myAccount = a;
		myAccountName = a.getName();
		myUserName = a.getUsername();
		myPassword = a.getPassword();
		myURL = a.getURL();
		myAdditionalDetails = a.getAdditionalDetails();
		buildPanel();
	}
	
	public AccountInfoPanel(String accountName, String username, String url, String additionalDetails)
	{
		myAccount = null;
		myAccountName = accountName;
		myUserName = username;
		myURL = url;
		myAdditionalDetails = additionalDetails;
		buildPanel();
	}
	
	public void setAccountName(String a)
	{
		if(a != null)
		{
			inputName.setText(a);
			myAccountName = a;
		}
	}
	
	public void setUserName(String u)
	{
		if(u != null)
		{
			inputUsername.setText(u);
			myUserName = u;
		}
	}
	
	public void setPassword(String p)
	{
		if(p != null)
		{
			inputPassword.setText(p);
			myPassword = p;
		}
	}
	
	public void setURL(String u)
	{
		if(u != null)
		{
			inputURL.setText(u);
			myURL = u;
		}
	}

	public void setAdditionalDetails(String a)
	{
		if(a != null)
		{
			inputAdditional.setText(a);
			myAdditionalDetails = a;
		}
	}
	
	public void buildPanel()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel accountName = new JLabel("Account Name");
		JLabel accountUsername = new JLabel("Username");
		JLabel accountPassword = new JLabel("Password");
		JLabel accountURL = new JLabel("Account URL");
		JLabel accountAdditionalDetails = new JLabel("Additional Details");
		
		inputName = new JLabel("");
		inputUsername = new JLabel("");
		inputPassword = new JLabel("");
		inputURL = new JLabel("");
		inputAdditional = new JLabel("");
		
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
		add(inputAdditional, c);
	}
	
	public void rebuild()
	{
		removeAll();
		buildPanel();
	}

}
