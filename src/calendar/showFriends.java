package calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class showFriends extends JPanel implements ActionListener {
	
	public JButton tillbaka;
	public Calendar calendar;
	private DefaultListModel<User> model;
	private JList Userlist;
	private JScrollPane scroll;

	JavaDB db = new JavaDB("localhost", "root", "", "calendar");
	
	public showFriends(Calendar calendar){
		this.calendar = calendar;
		setLayout(new GridLayout(5,0,20,20));
		setBorder(new EmptyBorder(25,40,400,40));
		setBackground(new Color(166, 166, 166));
		
		JPanel center = new JPanel();
		model = new DefaultListModel<User>();
		Userlist = new JList(model);
		populateFriends();
		
		Userlist.setPreferredSize(new Dimension(400,100));
		add(Userlist);
		
		tillbaka = new JButton("Tillbaka");
		tillbaka.setPreferredSize(new Dimension(110, 30));
		add(tillbaka);
		tillbaka.addActionListener(this);
		
		
	}
	
	
	
	public void populateFriends()
	{
		model.clear();
		String SQL="SELECT user.id, username FROM user inner join friendwith on user2=user.id WHERE verified = 1 and user1 =" + calendar.inloggid+";";
		Object[][]matris = db.getData(SQL);
		
					for(int i=0;i<matris.length;i++)
					{
						User u = new User(matris[i][0].toString(),matris[i][1].toString());
						if(!u.getId().equals(calendar.inloggid))
						{
							model.addElement(u);
						}
					}
		
		SQL="SELECT user.id, username FROM user inner join friendwith on user1=user.id WHERE verified = 1 and user2 =" + calendar.inloggid+";";
		
		matris = db.getData(SQL);
		
		for(int i=0;i<matris.length;i++)
		{
			User u = new User(matris[i][0].toString(),matris[i][1].toString());
			if(!u.getId().equals(calendar.inloggid))
			{
				model.addElement(u);
			}
		}
		Userlist.updateUI();
	}


	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(tillbaka)) {
			calendar.goback();
		}
		

	}


	public static void main(String[] args) {
		new Calendar();

	}

}
