package calendar;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel.*;

public class register extends JPanel {

JPasswordField password;
JTextField username;
JTextField email;
JButton loggain;


	public register()
	{ 
		setBackground(new Color(163, 220, 206));
		setLayout (new GridLayout (12, 0));
		JLabel l1 = new JLabel();
		add(l1);
		JLabel l2 = new JLabel("Användarnamn:",JLabel.CENTER);
		add(l2);
		
		username = new JTextField();
		username.setPreferredSize(new Dimension (100,30));
		add(username);
		JLabel l3 = new JLabel("Email:",JLabel.CENTER);
		add(l3);
		email = new JTextField();
		email.setPreferredSize(new Dimension (100,30));
		add(email);
		JLabel l4 = new JLabel("Lösenord:",JLabel.CENTER);
		add(l4);
		password = new JPasswordField();
		password.setPreferredSize(new Dimension (100,30));
		add(password);
		JLabel l5 = new JLabel("Återupprepa lösenord:",JLabel.CENTER);
		add(l5);
		password = new JPasswordField();
		password.setPreferredSize(new Dimension (100,30));
		add(password);
		JLabel l6 = new JLabel();
		add(l6);
		loggain = new JButton("Registrera dig");
		add(loggain);
		
		
		
		
	}
	
}
	


