package com.PasswordManager;

import javax.swing.*;
import java.awt.*;

/**
 * @title	AccountsPaneItem
 * @author 	Nick Fulton, Jack Fogerson, Jack Gisel
 * @desc	Displays all accounts.
 */

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
