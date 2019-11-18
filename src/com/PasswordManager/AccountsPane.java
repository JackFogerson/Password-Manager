package com.PasswordManager;

import javax.swing.JScrollPane;

public class AccountsPane extends JScrollPane
{
	private static final long serialVersionUID = 1L;
	AccountInfoPanel infoPanel;
	User myUser;
	
	//Constructor for AccountsPane
	//Sets up scrollable panel with accounts and passwords
	public AccountsPane(User u, AccountInfoPanel a)
	{
		myUser = u;
		infoPanel = a;
		populate();
	}

	//Method to populate the AccountsPane with accounts
	public void populate()
	{
		//Get accounts for the user from database
		for(Account a : myUser.getAccounts())
		{
			AccountsPaneItem api = new AccountsPaneItem(a);
			add(api);
			api.addActionListener(e -> changeInfo(a));
		}
	}
	
	public void changeInfo(Account a)
	{
		// TODO Changing from one account panel to the other
		// Switching from one account info to the next
	}
}
