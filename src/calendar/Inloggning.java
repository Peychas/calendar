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

public class Inloggning extends JPanel implements ActionListener {

	JPasswordField password;
	JTextField username;
	JButton Login;
	private Calendar calendar;

	JavaDB db = new JavaDB("localhost", "root", "", "calendar");

	public Inloggning(Calendar calendar) {
		this.calendar = calendar;
		setBackground(new Color(166, 166, 166));
		setLayout(new GridLayout(10, 1, 10, 10));
		setBorder(new EmptyBorder(25, 40, 50, 40));

		JLabel anv = new JLabel("Användarnamn:");
		anv.setFont(new Font("Sans-Serif", Font.PLAIN, 20));
		add(anv);

		username = new JTextField();
		username.setPreferredSize(new Dimension(100, 30));
		username.setFont(new Font("Sans-Serif", Font.PLAIN, 20));
		add(username);

		JLabel lös = new JLabel("Lösenord:");
		lös.setFont(new Font("Sans-Serif", Font.PLAIN, 20));
		add(lös);

		password = new JPasswordField();
		password.setPreferredSize(new Dimension(100, 30));
		password.setFont(new Font("Sans-Serif", Font.PLAIN, 20));
		add(password);

		JLabel space = new JLabel();
		add(space);

		Login = new JButton("Logga in");
		Login.setFont(new Font("Sans-Serif", Font.PLAIN, 20));
		add(Login);
		Login.addActionListener(this);
		add(Login);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String user = username.getText();
		// char[] pwd = password.getPassword();
		String pwd = password.getText();
		Object[][] database = null;

		String SQL = String.format("SELECT * FROM user WHERE username = '" + user + "' AND password = '" + pwd + "' ");
		database = db.getData(SQL);

		// kollar om det du skriver in matchar med databasen

		try {
			if (database.length == 1) {

				calendar.inloggid = Integer.parseInt((String) database[0][0]);
				calendar.changeSplit2();
				JOptionPane.showMessageDialog(null, "Inloggningen lyckades!");
			}else{
				JOptionPane.showMessageDialog(null, "Användarnamn eller lösenord är fel!");
			}


			// skriver du något som inte stämmer överens med det som står i
			// databasen får du ett felmeddelande

		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, "Användarnamn eller lösenord är fel!");
		}

	}

}
