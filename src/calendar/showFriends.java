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
		Userlist.setPreferredSize(new Dimension(400,100));
		add(Userlist);
		
		tillbaka = new JButton("Tillbaka");
		tillbaka.setPreferredSize(new Dimension(110, 30));
		add(tillbaka);
		tillbaka.addActionListener(this);
		
		
	}


	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(tillbaka)) {
			calendar.goback();
		}
		
		if(e.getSource().equals(model))
		{
			Object[]values=Userlist.getSelectedValuesList().toArray();
			
			for(Object o: values)
			{
				String SQL="SELECT * FROM friendwith WHERE verified = 1, (user1 = "+ calendar.inloggid +" AND user2 = "+((User)o).getId()+");";
				db.execute(SQL);
				System.out.println(SQL);
				
				//UPDATE friendwith SET verified = 1 WHERE (user1 = "+ calendar.inloggid +" AND user2 = "+((User)o).getId()+");
				//"SELECT * FROM frindwith WHERE (user1 = "+ calendar.inloggid +" AND user2 = "+((User)o).getId()+" AND verified = 1 ";
			}
				
		} 
	}


	public static void main(String[] args) {
		new Calendar();

	}

}
