package com.PasswordManager;

import javax.swing.JScrollPane;

public class AccountsPane extends JScrollPane
{
	private static final long serialVersionUID = 1L;
	AccountInfoPanel infoPanel;
	User myUser;
	
	public AccountsPane(User u, AccountInfoPanel a)
	{
		myUser = u;
		infoPanel = a;
		populate();
	}

	public void populate()
	{
		for(Account a : myUser.getAccounts())
		{
			AccountsPaneItem api = new AccountsPaneItem(a);
			add(api);
			api.addActionListener(e -> changeInfo(a));
		}
	}
	
	public void changeInfo(Account a)
	{
		// TODO
	}
}
