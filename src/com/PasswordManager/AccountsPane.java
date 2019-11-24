package com.PasswordManager;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @title	AccountsPane Class
 * @author	Nick Fulton, Jack Fogerson, Jack Gisel
 * @desc	Handles Account panel on left side of PM screen
 */
public class AccountsPane extends JScrollPane
{
	private static final long serialVersionUID = 1L;
	AccountInfoPanel infoPanel;
	User myUser;
	JFrame account;
	
	//Constructor for AccountsPane
	//Sets up scrollable panel with accounts and passwords
	public AccountsPane(User u, AccountInfoPanel a)
	{
		//Sets variables then adds accounts to AccountPane
		myUser = u;
		infoPanel = a;
		populate();
	}

	//Method to populate the AccountsPane with accounts
	public void populate()
	{
		//Creates JPanel and sets parameters
		JPanel accounts = new JPanel();
		accounts.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		
		myUser.addAccount(new Account("google", "google", "google"));
		
		//Get accounts for the user from database
		for(Account a : myUser.getAccounts())
		{
			AccountsPaneItem api = new AccountsPaneItem(a);
			accounts.add(api, c);
			api.addActionListener(e -> changeInfo(a));
						
			c.gridy++;
		}
		
		this.add(accounts);
	}
	
	public void changeInfo(Account a)
	{
		// TODO Changing from one account panel to the other
		// Switching from one account info to the next
	}
}
