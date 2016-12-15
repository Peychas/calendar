package calendar;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class register extends JPanel implements ActionListener {

JPasswordField password1,password2;
JTextField username;
JTextField email;
JButton reg;

JavaDB db = new JavaDB("localhost","root","","calendar");


	public register()
	{ 
		setBackground(new Color(166, 166, 166));
		setLayout (new GridLayout (10, 1,10,10));
		setBorder(new EmptyBorder(25,40,50,40));
		
		JLabel l2 = new JLabel("Användarnamn:",JLabel.CENTER);
		l2.setFont(new Font("Sans-Serif", Font.PLAIN,20));
		add(l2);
		
		username = new JTextField();
		username.setPreferredSize(new Dimension (100,40));
		username.setFont(new Font("Sans-Serif", Font.PLAIN,20));
		add(username);
		
		JLabel l3 = new JLabel("Email:",JLabel.CENTER);
		l3.setFont(new Font("Sans-Serif", Font.PLAIN,20));
		add(l3);
		
		email = new JTextField();
		email.setPreferredSize(new Dimension (100,40));
		email.setFont(new Font("Sans-Serif", Font.PLAIN,20));
		add(email);
		
		JLabel l4 = new JLabel("Lösenord:",JLabel.CENTER);
		l4.setFont(new Font("Sans-Serif", Font.PLAIN,20));
		add(l4);
		
		password1 = new JPasswordField();
		password1.setPreferredSize(new Dimension (100,40));
		password1.setFont(new Font("Sans-Serif", Font.PLAIN,20));
		add(password1);
		
		JLabel l5 = new JLabel("Återupprepa lösenord:",JLabel.CENTER);
		l5.setFont(new Font("Sans-Serif", Font.PLAIN,20));
		add(l5);
		
		password2 = new JPasswordField();
		password2.setPreferredSize(new Dimension (100,40));
		password2.setFont(new Font("Sans-Serif", Font.PLAIN,20));
		add(password2);
		
		JLabel l6 = new JLabel();
		add(l6);
		
		reg = new JButton("Registrera dig");
		reg.setFont(new Font("Sans-Serif", Font.PLAIN,20));
		reg.addActionListener(this);
		add(reg);
		
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String user = username.getText();
		String epost = email.getText();
		
		
		System.out.println(password1.getPassword());
		//username.setText("hfhhf");
		if(user == "a"){
			username.requestFocus();
			JOptionPane.showMessageDialog(null,"Du är nu dhsaj!");} 
		else if(new String(password1.getPassword()).equals(new String(password2.getPassword())))
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


