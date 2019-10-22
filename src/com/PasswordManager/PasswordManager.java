package com.PasswordManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

/**
 * @title	PasswordManager Class
 * @author	Nick Fulton, Jack Fogerson, Jack Gisel
 *
 */
public class PasswordManager 
{
	// Create those variables.
	JFrame mainFrame;
	User myUser;
	
	/**
	 * @title	PasswordManager Constructor
	 * @param	user
	 * @desc	Pretty standard, sets the user of the manager to the one given.
	 */
	public PasswordManager(User user)
	{
		myUser = user;
	}
	
	/**
	 * @title	launch Method
	 * @desc	Acts as the first method used to run everything.
	 */
	public void launch()
	{
		buildFrame();
	}
	
	/**
	 * @title	buildFrame Method
	 * @desc	Self explanitory, just builds the frame and sets everything up.
	 */
	public void buildFrame()
	{
		// Instantiate the frame and set the layout to a border layout.
		mainFrame = new JFrame("JackPass - " + myUser.getUsername());
		mainFrame.setLayout(new BorderLayout());
		
		// Create all of the needed elements to the frame.
		JMenuBar topBar = new JMenuBar();
		JMenuItem addAccount = new JMenuItem("Add Account");
		JMenuItem removeAccount = new JMenuItem("Remove Account");
		JMenuItem logOut = new JMenuItem("LogOut");
		
		// Add the needed components to the menu.
		topBar.add(addAccount);
		topBar.add(removeAccount);
		topBar.add(logOut);
		
		// Add the top bar to the frame.
		mainFrame.add(topBar, BorderLayout.PAGE_START);
		
		// Create all of the other components.
		JLabel accountInformation = new JLabel();
		JLabel accountNames = new JLabel();
		JScrollPane accountNamesScroll = new JScrollPane(accountNames, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		// Add the rest of the components to the frame.
		mainFrame.add(accountNamesScroll, BorderLayout.LINE_START);
		mainFrame.add(accountInformation, BorderLayout.CENTER);
		
		// Finalize the frame.
		mainFrame.setMinimumSize(new Dimension(1000, 600));
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setLocation(d.width/2-mainFrame.getSize().width/2, d.height/2-mainFrame.getSize().height/2);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	/** 
	 * @title	logOut Method
	 * @return	1 when logged out.
	 * @desc	Basically closes the frame.
	 */
	public int logOut()
	{
		mainFrame.dispose();
		return 1;
	}
}
