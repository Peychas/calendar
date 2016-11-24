package calendar;

import java.awt.GridLayout;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Month extends JPanel {

	public Month() {
		setLayout(new GridLayout(6,7));
		JLabel[] labels = new JLabel[7];
		String[] days = {"Måndag", "Tisdag", "Onsdag", "Torsdag", "Fredag", "Lördag", "Söndag"};
		for(int i = 0; i < labels.length; i++){
			labels[i] = new JLabel(days[i] , JLabel.CENTER);
			add(labels[i]);
		}
		JButton[] buttons = new JButton[31];
		for(int i = 0; i < buttons.length; i++){
			buttons[i] = new JButton();
			add(buttons[i]);
		}
		LocalDateTime now = LocalDateTime.now();
		int year = now.getYear();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		int hour = now.getHour();
		int minute = now.getMinute();

		System.out.printf("%d-%02d-%02d %02d:%02d", year, month, day, hour, minute);
		
		
	}

}
