package calendar;

import java.awt.Font;
import java.awt.GridLayout;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Banner extends JPanel {
	
	private ViewSelect viewselect;
	
	public Banner() {
		setLayout(new GridLayout(3,1));
		JLabel space = new JLabel();
		add(space);
		LocalDateTime now = LocalDateTime.now();
		Month month = now.getMonth();
		int year = now.getYear();
		JLabel label = new JLabel("" + month + " " + year , JLabel.CENTER);
		label.setFont(new Font("San-Serif", Font.PLAIN, 40));
 		add(label);
 		viewselect = new ViewSelect();
 		add(viewselect);
 		
	}

}
