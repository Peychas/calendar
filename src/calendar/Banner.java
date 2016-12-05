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
	private Calendar cal;
	private JLabel label;
	
	public Banner(Calendar cal) {
		this.cal=cal;
		setLayout(new GridLayout(3,1));
		JLabel space = new JLabel();
		add(space);
		LocalDateTime now = LocalDateTime.of(cal.år, cal.manad, cal.dag, 0, 0);
		Month month = now.getMonth();
		int year = now.getYear();
		int day = now.getDayOfMonth();
		int hour = now.getHour();
		int minute = now.getMinute();
		 label = new JLabel(month +  " " + year , JLabel.CENTER);
		label.setFont(new Font("San-Serif", Font.PLAIN, 40));
 		add(label);
 		viewselect = new ViewSelect(cal,this);
 		add(viewselect);
 		
	}
	public void showBanner()
	{
		remove(label);
		remove(viewselect);
		LocalDateTime now = LocalDateTime.of(cal.år, cal.manad, cal.dag, 0, 0);
		Month month = now.getMonth();
		int year = now.getYear();
		int day = now.getDayOfMonth();
		int hour = now.getHour();
		int minute = now.getMinute();
		 label = new JLabel(month +  " " + year , JLabel.CENTER);
		label.setFont(new Font("San-Serif", Font.PLAIN, 40));
 		add(label);
 		viewselect = new ViewSelect(cal,this);
 		add(viewselect);
		repaint();

		
	}

}
