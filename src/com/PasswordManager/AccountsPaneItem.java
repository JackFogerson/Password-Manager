package com.PasswordManager;

import java.awt.Dimension;
import javax.swing.JToggleButton;

public class AccountsPaneItem extends JToggleButton
{
	private static final long serialVersionUID = 1L;
	Account myAccount;
	
	//public constructor for AccountsPaneItem
	public AccountsPaneItem(Account a)
	{
		myAccount = a;
		buildButton();
	}
	
	private void buildButton()
	{
		this.setText(myAccount.getName());
		this.setPreferredSize(new Dimension(200, 60));
	}
	
	public Account getAccount()
	{
		return myAccount;
	}
}
