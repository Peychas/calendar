package calendar;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Month extends JPanel {

	public Month() {
		setBackground(Color.white);
		setLayout(new GridLayout(5,7));
		JButton[] buttons = new JButton[35];
		for(int i = 0; i < buttons.length; i++){
		buttons[i] = new JButton();
		add(buttons[i]);
		}
		
	}

}
