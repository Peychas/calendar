package calendar;

import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.time.LocalDateTime;
import java.time.YearMonth;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Month extends JPanel {

	public Month(int delta) {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		JLabel[] labels = new JLabel[7];
		String[] days = {"Måndag", "Tisdag", "Onsdag", "Torsdag", "Fredag", "Lördag", "Söndag"};
		for(int i = 0; i < labels.length; i++){
			labels[i] = new JLabel(days[i] , JLabel.CENTER);
			add(labels[i], i);
		}
		
		LocalDateTime now = LocalDateTime.now();
		int year = now.getYear();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		int hour = now.getHour();
		int minute = now.getMinute();
		YearMonth yearMonthObject = YearMonth.of(year, month-delta);
		int daysInMonth = yearMonthObject.lengthOfMonth();
		System.out.println(daysInMonth);

		System.out.printf("%d-%02d-%02d %02d:%02d", year, month, day, hour, minute);
		
		JButton[] buttons = new JButton[daysInMonth];
		for(int i = 0; i < buttons.length; i++){
			buttons[i] = new JButton("" + (1+i) );
			add(buttons[i]);
		}
		
	}

}
