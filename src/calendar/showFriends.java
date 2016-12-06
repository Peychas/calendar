package calendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class showFriends extends JPanel implements ActionListener {
	
	private JTextField field;
	private JButton search;
	private JButton add;
	private Calendar calendar;
	
	
	
	public showFriends(Calendar calendar)
	{
		this.calendar = calendar;
		setLayout(new GridLayout(5,1,20,20));
		setBackground(new Color(166, 166, 166));
		
		field = new JTextField();
		field.setPreferredSize(new Dimension (100,30));
		add(field);
		search = new JButton("Sök");
		add(search);
		search.addActionListener(this);
		add(search);
		
	}
	
	




public void actionPerformed(ActionEvent e) {
	
	String Field = field.getText();
	
	String SQL = String.format("SELECT * FROM friendwith WHERE user1 ");
	
}

}
