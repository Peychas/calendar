package calendar;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class sidebar extends JPanel implements ActionListener {
	private JButton notification;
	private JButton showFriends;
	private JButton addFriends;
	private Calendar calendar;
	
	JavaDB db = new JavaDB("localhost","root","","calendar");
	
	public sidebar(Calendar calendar)
	{
		this.calendar = calendar;
		notification = new JButton ("Notifikationer");
		notification.setPreferredSize(new Dimension (80,60));
		add(notification);
		notification.addActionListener(this);
		showFriends = new JButton ("Visa vänner");
		showFriends.setPreferredSize(new Dimension (80,60));
		add(showFriends);
		showFriends.addActionListener(this);
		addFriends = new JButton ("Lägg till vän");
		addFriends.setPreferredSize(new Dimension (80,60));
		add(addFriends);
		addFriends.addActionListener(this);
	}
	


	public static void main(String[] args) {
		new Calendar();

	}

	
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
