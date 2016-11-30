package calendar;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.time.LocalDateTime;
import java.time.YearMonth;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Month extends JPanel {

	public Month(int delta) {
		GridBagLayout abc = new GridBagLayout();
		int[] abcwidth = new int[7];
		for (int i = 0; i < abcwidth.length; i++)
			abcwidth[i] = 130;
		abc.columnWidths = abcwidth;
		int[] abcheight = new int[7];
		for (int i = 0; i < abcheight.length; i++)
			abcheight[i] = 70;
		abc.rowHeights = abcheight;

		setLayout(abc);
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;

		JLabel[] labels = new JLabel[7];
		String[] days = { "Måndag", "Tisdag", "Onsdag", "Torsdag", "Fredag", "Lördag", "Söndag" };
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(days[i], JLabel.CENTER);
			add(labels[i], c);
			c.gridx++;
		}
		c.gridy = 1;
		c.gridx = 0;

		LocalDateTime now = LocalDateTime.now();
		int dayIndex = now.getDayOfWeek().getValue() - 1;
		if (now.getDayOfMonth() != 1) {
			LocalDateTime firstDay = LocalDateTime.of(now.getYear(), now.getMonth(), 1, 0, 0);
			System.out.println(firstDay.getDayOfWeek());
			dayIndex = firstDay.getDayOfWeek().getValue() - 1;
		}
		int year = now.getYear();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		int hour = now.getHour();
		int minute = now.getMinute();
		YearMonth yearMonthObject = YearMonth.of(year, month - delta);
		int daysInMonth = yearMonthObject.lengthOfMonth();
		System.out.println(daysInMonth);

		System.out.printf("%d-%02d-%02d %02d:%02d", year, month, day, hour, minute);
		c.gridx = dayIndex;
		JButton[] buttons = new JButton[daysInMonth];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton("" + (1 + i));
			buttons[i].setSize(100, 100);
			add(buttons[i], c);
			c.gridx++;
			if (c.gridx >= 7) {
				c.gridx = 0;
				c.gridy++;
			}
		}

	}

}
