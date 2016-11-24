package calendar;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class register extends JPanel implements ActionListener {

JPasswordField password1,password2;
JTextField username;
JTextField email;
JButton loggain;

JavaDB db = new JavaDB("localhost","root","","calendar");


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
		password1 = new JPasswordField();
		password1.setPreferredSize(new Dimension (100,30));
		add(password1);
		JLabel l5 = new JLabel("Återupprepa lösenord:",JLabel.CENTER);
		add(l5);
		password2 = new JPasswordField();
		password2.setPreferredSize(new Dimension (100,30));
		add(password2);
		JLabel l6 = new JLabel();
		add(l6);
		loggain = new JButton("Registrera dig");
		loggain.addActionListener(this);
		add(loggain);
		
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String user = username.getText();
		String epost = email.getText();
		
		System.out.println(password1.getPassword());
		
		if(new String(password1.getPassword()).equals(new String(password2.getPassword())))
		{
			String password = new String(password1.getPassword());
			String SQL= String.format("insert into user(username,email,password)values('%s','%s','%s');",user,epost,password);
			db.execute(SQL);
			username.setText("");
			email.setText("");
			password1.setText("");
			password2.setText("");
			JOptionPane.showMessageDialog(null,"Du är nu registrerad!");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Lösenorden överensstämmer inte!");
			password1.requestFocus();
		}
		
		
	}
	
} 


