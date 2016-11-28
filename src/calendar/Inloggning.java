package calendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Inloggning extends JPanel implements ActionListener {
	
JPasswordField password;
JTextField username;
JButton Login; 
	
JavaDB db = new JavaDB("localhost","root","","calendar");

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
			Login.addActionListener(this);
			add(Login);
			
			
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String user = username.getText();
			char[] pwd = password.getPassword();
			
			String SQL = String.format("SELECT * FROM user WHERE username = 'user' AND password = 'pwd' ");
			db.execute(SQL);
			JOptionPane.showMessageDialog(null, "vem fan e do");
			
		}
		

}

