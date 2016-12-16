package calendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class notifications extends JPanel implements ActionListener {

	public JPanel asd;
	public JButton acc;
	public Calendar calendar;
	public JButton tillbaks;
	private DefaultListModel<User> model;
	private JList Userlist;
	private JScrollPane scroll;
	
	JavaDB db = new JavaDB("localhost", "root", "", "calendar");
	public notifications (Calendar calendar) {
		
		this.calendar = calendar;
		setLayout(new GridLayout(5,1,20,20));
		setBorder(new EmptyBorder(25,40,400,40));
		setBackground(new Color(166, 166, 166));
		
		JPanel center = new JPanel();
/*		center.setLayout(new BorderLayout());
		center.setBackground(getBackground());
		add(BorderLayout.CENTER, center);*/
		model = new DefaultListModel<User>();
		Userlist = new JList(model);
		Userlist.setPreferredSize(new Dimension(400,100));
		Userlist.setFont(new Font("Sans-Serif", Font.PLAIN,18));

/*		scroll = new JScrollPane(Userlist);
		scroll.setPreferredSize(new Dimension(300, 150));
		center.add(BorderLayout.CENTER, scroll);
		scroll.setVisible(false);*/
		add(Userlist);
		
		
		acc = new JButton("Acceptera");
		acc.setPreferredSize(new Dimension(20,20));
		acc.setFont(new Font("Sans-Serif", Font.PLAIN,20));
		acc.addActionListener(this);
		add(acc);
		
		tillbaks = new JButton("Tillbaka");
		tillbaks.setPreferredSize(new Dimension(210,70));
		tillbaks.setFont(new Font("Sans-Serif", Font.PLAIN,20));
		add(tillbaks);
		tillbaks.addActionListener(this);
		
		addThisShit();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(tillbaks)) {
			calendar.bak();
		}
		
	
		if(e.getSource().equals(acc))
		{
			JOptionPane.showMessageDialog(null, "Ni är nu vänner");
			Object[]values=Userlist.getSelectedValuesList().toArray();
			
			for(Object o: values)
			{
				String SQL="UPDATE friendwith SET verified = 1 WHERE (user1 = "+ calendar.inloggid +" AND user2 = "+((User)o).getId()+") OR" +
						"(user2 = "+ calendar.inloggid +" AND user1 = "+((User)o).getId()+") ;";
				System.out.println(SQL);
				db.execute(SQL);
				
				
				
				
			}
				
		}
		
	}
	

	
	public void addThisShit(){
	
		
		//tre stycken paranteser innan user1 och två stycken slutparanteser efter user.id för att alltid verified 0 ska gälla!
	 String SQL =
	 String.format("SELECT user.id, username FROM user, friendwith WHERE (((user1 = "+
	 calendar.inloggid +" and user2 = user.id) or (user2="+
	 calendar.inloggid + " and user1 = user.id)) and verified =0);");
	 System.out.println(SQL);
		Object[][] database = db.getData(SQL);
		model.clear();

		for (int i = 0; i < database.length; i++) {
			model.addElement(new User(database[i][0].toString(),
					database[i][1].toString()));
		 
		
		}
	 
	}
	
	public void accThisShit(){
		
		String SQL = String.format("UPDATE friendwith SET verified = 1 WHERE (user1 = "+ calendar.inloggid +" AND user2 = user.id");
		db.execute(SQL);
		System.out.println(SQL);
		
		//"UPDATE friendwith SET verified = 1 WHERE user1 = 2 AND user2 = 8"
		
	}
	
	

public static void main(String[] args) {
new Calendar();


}

}