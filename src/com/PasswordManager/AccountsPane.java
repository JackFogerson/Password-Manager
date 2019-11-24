package com.PasswordManager;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
			api.addActionListener(event -> showAccount(api));
			api.addActionListener(e -> changeInfo(a));
						
			c.gridy++;
		}
		
		this.add(accounts);
	}
	
	public void showAccount(AccountsPaneItem a) {
		account = new JFrame();
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
	
	public void changeInfo(Account a)
	{
		// TODO Changing from one account panel to the other
		// Switching from one account info to the next
	}
}
