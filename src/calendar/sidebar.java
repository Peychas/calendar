package calendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class sidebar extends JPanel implements ActionListener {
	private JButton notification;
	private JButton showFriends;
	private JButton addFriends;
	private Calendar calendar;
	private JButton showEvent;
	public JButton signout;
	
	JavaDB db = new JavaDB("localhost","root","","calendar");
	
	public sidebar(Calendar calendar)
	{
		this.calendar = calendar;
		setLayout(new GridLayout(5,1,20,20));
		setBackground(new Color(166, 166, 166));
	
		notification = new JButton ("Notifikationer");
		notification.setPreferredSize(new Dimension (20,60));
		setBorder(new EmptyBorder(25,40,400,40));
		
		add(notification);
		notification.addActionListener(this);
		showFriends = new JButton ("Visa vänner");
		showFriends.setPreferredSize(new Dimension (20,20));
		add(showFriends);
		showFriends.addActionListener(this);
		addFriends = new JButton ("Lägg till vän");
		addFriends.setPreferredSize(new Dimension (20,20));
		add(addFriends);
		addFriends.addActionListener(this);
		showEvent = new JButton ("Visa händelser");
		showEvent.setPreferredSize(new Dimension (20,20));
		add(showEvent);
		showEvent.addActionListener(this);
		
		
		signout = new JButton ("Logga ut");
		signout.setPreferredSize(new Dimension (210,70));
		signout.addActionListener(this);
	}
	
	
	
	public JButton getSignOut()
	{
		return signout;
	}
	


	public static void main(String[] args) {
		new Calendar();
		

	}

	
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource().equals(addFriends))
		{
			calendar.addFriend();
			
		} if(e.getSource().equals(signout))
		{
			calendar.Loggaut();
			JOptionPane.showMessageDialog(null, "Du har loggats ut!");
			
		}if(e.getSource().equals(notification))
		{
			calendar.notifikationer();
		}
		if(e.getSource().equals(showFriends))
		{
			calendar.visaVänner();
		}
		if(e.getSource().equals(showEvent)){
			new showEvent(calendar);
		}
			
	}
		
		
	}


