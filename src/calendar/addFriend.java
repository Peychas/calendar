package calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class addFriend extends JPanel implements ActionListener {

	private JTextField field;
	private JButton search;
	private JButton addFr;
	private Calendar calendar;
	private JButton back;
	private JPanel list;
	private DefaultListModel<User> model;
	private JList userList;
	private JScrollPane scroll;
	JavaDB db = new JavaDB("localhost", "root", "", "calendar");

	public addFriend(Calendar calendar) {
		this.calendar = calendar;
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(30, 10, 30, 10));
		setBackground(new Color(166, 166, 166));

		// JLabel l1 = new JLabel("skriv in användarnamnet:",JLabel.CENTER);
		// add(l1);
		JPanel s = new JPanel();
		s.setBorder(new TitledBorder("Skriv in användarnamnet"));
		s.setLayout(new GridLayout(1, 1));
		s.setBackground(this.getBackground());
		// s.setBackground(new Color(0,180,0));
		field = new JTextField();
		field.setBorder(new EmptyBorder(5, 5, 5, 5));
		field.setPreferredSize(new Dimension(100, 30));
		s.add(field);
		// add(s);
		JPanel b = new JPanel();
		b.setLayout(new FlowLayout(FlowLayout.CENTER));
		b.setBackground(this.getBackground());
		search = new JButton("Sök");
		search.setPreferredSize(new Dimension(110, 30));
		b.add(search);
		// add(b);
		back = new JButton("Tillbaka");
		back.setPreferredSize(new Dimension(110, 30));
		b.add(back);
		back.addActionListener(this);
		search.addActionListener(this);

		JPanel north = new JPanel();
		north.setLayout(new GridLayout(2, 1));
		north.setPreferredSize(new Dimension(500, 180));
		north.add(s);
		north.add(b);
		add(BorderLayout.NORTH, north);

		// Centrerard panel med en Lista av sökta users

		JPanel center = new JPanel();
		center.setLayout(new BorderLayout());
		center.setBackground(getBackground());
		add(BorderLayout.CENTER, center);
		model = new DefaultListModel<User>();
		userList = new JList(model);
		scroll = new JScrollPane(userList);
		scroll.setPreferredSize(new Dimension(300, 150));
		center.add(BorderLayout.CENTER, scroll);
		scroll.setVisible(false);

		addFr = new JButton("Skicka vänförfrågan");
		addFr.addActionListener(this);
		addFr.setPreferredSize(new Dimension(110, 30));
		add(BorderLayout.SOUTH, addFr);

		/*
		 * JPanel c = new JPanel(); c.setLayout(new
		 * FlowLayout(FlowLayout.CENTER)); c.setLayout(new GridLayout(1,1));
		 * c.setBackground(new Color(123,0,0)); add(c);
		 */

	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(addFr))
		{	
			JOptionPane.showMessageDialog(null,"Vänförfrågan är nu skickad");
			Object[]values=userList.getSelectedValuesList().toArray();
			
			for(Object o: values)
			{
				String SQL="insert into friendwith(verified,user1,user2) values(0,"+calendar.inloggid+","+((User)o).getId()+");";
				db.execute(SQL);
			}
				
		} 

		if (e.getSource().equals(back)) {
			calendar.tillbaka();
		}

		if (e.getSource().equals(search)) {

			
			String Field = field.getText();
			// lista mina vänner
			 //String SQL =
			 //String.format("SELECT username FROM user, friendwith WHERE ((user1 = "+
			 //calendar.inloggid +" and user2 = user.id) or (user2="+
			 //calendar.inloggid + " and user1 = user.id) and verified =1);");

			String SQL = ("SELECT id, username FROM user WHERE username like ('%"
					+ field.getText() + "%')");
			System.out.println(SQL);
			Object[][] database = db.getData(SQL);
			model.clear();

			for (int i = 0; i < database.length; i++) {
				model.addElement(new User(database[i][0].toString(),
						database[i][1].toString()));
			}

			if (model.size() > 0) {
				scroll.setVisible(true);
				repaint();
				updateUI();
			} else {
				scroll.setVisible(false);
				JOptionPane.showMessageDialog(null,
						"Användarnamnet existerar inte");
			}
		}

		// JOptionPane.showMessageDialog(null, SQL);
	}

	public static void main(String[] args) {
		new Calendar();

	}

}