package calendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Inloggning extends JPanel {
JPasswordField password;
JTextField username;
JButton Login; 
	
		public Inloggning()
		{
			
			username = new JTextField();
			username.setPreferredSize(new Dimension(100,30));
			add(username);
			
			setBackground(new Color(163, 220, 206));
			password = new JPasswordField();
			setLayout(new FlowLayout(FlowLayout.CENTER));
			password.setPreferredSize(new Dimension(100,30));
			add(password);
			Login = new JButton("Logga in");
			add(Login);
			
		}
		

}

