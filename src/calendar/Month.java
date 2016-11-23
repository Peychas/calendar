package calendar;

import java.awt.Color;
import java.awt.GridLayout;

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
		
	}

}
