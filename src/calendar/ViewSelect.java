package calendar;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewSelect extends JPanel {
	
	public ViewSelect(){
		setLayout(new GridLayout(3,7));
		JLabel[] labels = new JLabel[14];
		for(int i = 0; i < labels.length; i++){
			labels[i] = new JLabel();
			add(labels[i]);
		}
		JButton next = new JButton("<");
		add(next);
		JButton previous = new JButton(">");
		add(previous);
		JLabel space = new JLabel();
		add(space);
		JButton[] buttons = new JButton[4];
		for(int i = 0; i < buttons.length; i++){
			buttons[i] = new JButton("" + (1+i) );
			add(buttons[i]);
		}
		
	}
}
