package calendar;


import java.awt.Dimension;


import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

public class register extends JPanel {

JPasswordField password;
JTextField username;
JTextField email;
JButton loggain;

	public register()
	{ 
		username = new JTextField();
		username.setPreferredSize(new Dimension (100,30));
		add(username);
		email = new JTextField();
		email.setPreferredSize(new Dimension (100,30));
		add(email);
		password = new JPasswordField();
		password.setPreferredSize(new Dimension (100,30));
		add(password);
		password = new JPasswordField();
		password.setPreferredSize(new Dimension (100,30));
		add(password);
		loggain = new JButton("Registrera dig");
		add(loggain);
		
		
		
		
	}
}
	


