package com.PasswordManager;

import javax.swing.JButton;

public class AccountsPaneItem extends JButton
{
	private static final long serialVersionUID = 1L;
	Account myAccount;
	
	public AccountsPaneItem(Account a)
	{
		myAccount = a;
	}
}
