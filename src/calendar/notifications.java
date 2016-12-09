package calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class notifications extends JPanel implements ActionListener {

	public JPanel asd;
	public JButton acc;
	public Calendar calendar;
	public JButton tillbaks;
	
	JavaDB db = new JavaDB("localhost", "root", "", "calendar");
	public notifications (Calendar calendar) {
		
		this.calendar = calendar;
		setLayout(new BorderLayout());
		setLayout(new GridLayout(8,1));
		//setBorder(new EmptyBorder(30, 10, 30, 10));
		setBackground(new Color(166, 166, 166));
		
		tillbaks = new JButton("Tillbaka");
		tillbaks.setPreferredSize(new Dimension(110, 30));
		add(tillbaks);
		tillbaks.addActionListener(this);
		
		
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(tillbaks)) {
			calendar.bak();
		}
		
	}



public static void main(String[] args) {
new Calendar();


}
}