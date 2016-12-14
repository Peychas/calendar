package calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

public class showEvent extends JFrame {
	private Calendar cal;
	private DefaultListModel<User> model;
	private JList userList;
	private JScrollPane scroll;
	private String namn = "Namn: ";
	JavaDB db = new JavaDB("localhost","root","","calendar");

	public showEvent(Calendar cal){
		super("Visa Händelser");
		this.cal = cal;
		setLocation(475, 150);
		setPreferredSize(new Dimension(925, 650));
		setResizable(true);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception error) {
		}
		
		setLayout(new GridLayout(0,1,20,20));
		JPanel center = new JPanel();
		center.setLayout(new BorderLayout());
		center.setBackground(getBackground());
		add(BorderLayout.CENTER, center);
		model = new DefaultListModel<User>();
		userList = new JList(model);
		userList.setFont(new Font("Sans-Serif", Font.PLAIN,25));
		scroll = new JScrollPane(userList);
		scroll.setPreferredSize(new Dimension(300, 150));
		center.add(BorderLayout.CENTER, scroll);
		scroll.setVisible(false);
		
		String SQL = String.format("SELECT name,starttime,stoptime,comment,user FROM event WHERE user ="+ cal.inloggid+";");
		System.out.println(SQL);
		
		Object[][] database = db.getData(SQL);
		for(int i = 0; i < database.length; i++){
			model.addElement(new User(database[i][0].toString(),
					namn+database[i][0].toString()+"  Starttid: "+database[i][1].toString()+"  Kommentar: "+database[i][3].toString()+"  Sluttid: "+ database[i][2]));
		}
		if (model.size() > 0) {
			scroll.setVisible(true);
			repaint();
		} else {
			scroll.setVisible(false);
			JOptionPane.showMessageDialog(null,
					"hej");
		}
		
		
		pack();
		setVisible(true);
	}
}
