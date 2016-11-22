package calendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Inloggning extends JPanel {
JPasswordField password;
JTextField username;
	
		public Inloggning()
		{
			username = new JTextField();
			username.setPreferredSize(new Dimension(200,30));
			add(username);
			setBackground(new Color(0,180,90));
			password = new JPasswordField();
			setLayout(new FlowLayout(FlowLayout.CENTER));
			password.setPreferredSize(new Dimension(100,30));
			add(password);
			
		}

}
