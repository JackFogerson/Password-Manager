package com.PasswordManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

public class PasswordManager 
{
	JFrame mainFrame;
	User myUser;
	
	public PasswordManager(User user)
	{
		myUser = user;
	}
	
	public void launch()
	{
		buildFrame();
	}
	
	public void buildFrame()
	{
		mainFrame = new JFrame("JackPass - " + myUser.getUsername());
		mainFrame.setLayout(new BorderLayout());
		
		JMenuBar topBar = new JMenuBar();
		JMenuItem addAccount = new JMenuItem("Add Account");
		JMenuItem removeAccount = new JMenuItem("Remove Account");
		JMenuItem logOut = new JMenuItem("LogOut");
		
		topBar.add(addAccount);
		topBar.add(removeAccount);
		topBar.add(logOut);
		
		mainFrame.add(topBar, BorderLayout.PAGE_START);
		
		JLabel accountInformation = new JLabel();
		JLabel accountNames = new JLabel();
		JScrollPane accountNamesScroll = new JScrollPane(accountNames, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		mainFrame.add(accountNamesScroll, BorderLayout.LINE_START);
		mainFrame.add(accountInformation, BorderLayout.CENTER);
		
		mainFrame.setMinimumSize(new Dimension(1000, 600));
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setLocation(d.width/2-mainFrame.getSize().width/2, d.height/2-mainFrame.getSize().height/2);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	public int logOut()
	{
		mainFrame.dispose();
		return 1;
	}
}
