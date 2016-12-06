package calendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;



public class addFriend extends JPanel implements ActionListener {
	
	private JTextField field;
	private JButton search;
	private JButton add;
	private Calendar calendar;
	private JButton back;
	JavaDB db = new JavaDB("localhost","root","","calendar");
	
	
	
	public addFriend(Calendar calendar)
	{
		this.calendar = calendar;
		setLayout(new GridLayout(8,1,10,20));
		setBorder(new EmptyBorder(30,10,30,10));
		setBackground(new Color(166, 166, 166));
		
		
		
		//JLabel l1 = new JLabel("skriv in användarnamnet:",JLabel.CENTER);
		//add(l1);
		JPanel s = new JPanel();
		s.setBorder(new TitledBorder("Skriv in användarnamnet"));
		s.setLayout(new GridLayout(1,1));
		s.setBackground(this.getBackground());
		field = new JTextField();
		field.setBorder(new EmptyBorder(5,5,5,5));
		field.setPreferredSize(new Dimension (100,30));
		s.add(field);
		add(s);
		JPanel b = new JPanel();
		b.setLayout(new FlowLayout(FlowLayout.CENTER));
		b.setBackground(this.getBackground());
		search = new JButton("Sök");
		search.setPreferredSize(new Dimension(110,30));
		b.add(search);
		add(b);
		search.addActionListener(this);
		
		
		back = new JButton("Tillbaka");
		back.setPreferredSize(new Dimension(110,30));
		b.add(back);
		back.addActionListener(this);
	}		
		
		

	
	




public void actionPerformed(ActionEvent e) {
	
	if(e.getSource().equals(back))
	{
		calendar.tillbaka();
	}
	

	
	String Field = field.getText();
	
	String SQL = String.format("SELECT username FROM user, friendwith WHERE ((user1 = 2 and user2 = user.id) or (user2=2 and user1 = user.id) and verified =1);");
	db.execute(SQL);
}

public static void main(String[] args) {
	new Calendar();
	

}

}