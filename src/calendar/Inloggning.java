package calendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
private Calendar calendar;

	
JavaDB db = new JavaDB("localhost","root","","calendar");

		public Inloggning(Calendar calendar)
		{
			this.calendar = calendar;
			
			username = new JTextField();
			setLayout (new GridLayout (12, 0));
			username.setPreferredSize(new Dimension(100,30));
			add(username);
			
			setBackground(new Color(166, 166, 166));
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
			Object[][] database = null;
				
			
			String SQL = String.format("SELECT * FROM user WHERE username = '"+ user + "' AND password = '" +  pwd + "' ");
			database = db.getData(SQL);
			
			// kollar om det du skriver in matchar med databasen
			
			try{
			   if(database.length==1)
			   {
				   
				   calendar.inloggid = Integer.parseInt((String)database[0][0]);
				   calendar.changeSplit2();
			   }
			   
			    
			   
			   
			  
				JOptionPane.showMessageDialog(null, "Inloggningen lyckades!");
				
				// skriver du n�got som inte st�mmer �verens med det som st�r i databasen f�r du ett felmeddelande
				
			}catch(Exception error)
			{
				JOptionPane.showMessageDialog(null, "Anv�ndarnamn eller l�senord �r fel!");
			}
			
			
			
			
		}
		

}

