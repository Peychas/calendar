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
	
//JPasswordField password;
	JTextField password;
JTextField username;
JButton Login; 
	
JavaDB db = new JavaDB("localhost","root","","calendar");

		public Inloggning()
		{
			
			username = new JTextField();
			username.setPreferredSize(new Dimension(100,30));
			add(username);
			
			setBackground(new Color(163, 220, 206));
			//password = new JPasswordField();
			password = new JTextField();
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
			//char[] pwd = password.getPassword();
			String pwd = password.getText();
			Object[][] petterNicklas = null;
				
			
			String SQL = String.format("SELECT * FROM user WHERE username = '"+ user + "' AND password = '" +  pwd + "' ");
			petterNicklas = db.getData(SQL);
			//JOptionPane.showMessageDialog(null, petterNicklas);
			// kollar om det du skriver in matchar med databasen
			
			try{
			   if((String)petterNicklas[0][0]=="");
			   
			  // actionResponse.sendRedirect("notiflikationer");
				JOptionPane.showMessageDialog(null, "Inloggningen lyckades!");
				
				// skriver du något som inte stämmer överens med det som står i databasen får du ett felmeddelande
				
			}catch(Exception error)
			{
				JOptionPane.showMessageDialog(null, "Användarnamn eller lösenord är fel!");
			}
			
			//JOptionPane.showMessageDialog(null, petterNicklas[0][0]);
			
		}
		

}

