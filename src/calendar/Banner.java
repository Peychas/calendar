package calendar;

import java.awt.Font;
import java.awt.GridLayout;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

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
		int day = now.getDayOfMonth();
		int hour = now.getHour();
		int minute = now.getMinute();
		DayOfWeek week = now.getDayOfWeek();
		System.out.println(now.format(DateTimeFormatter.ofPattern("w")));
		JLabel label = new JLabel(day + " " + month + " " + "vecka " + now.format(DateTimeFormatter.ofPattern("w"))  + " " + year , JLabel.CENTER);
		label.setFont(new Font("San-Serif", Font.PLAIN, 40));
 		add(label);
 		viewselect = new ViewSelect();
 		add(viewselect);
 		
	}

}
