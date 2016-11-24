package calendar;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Banner extends JPanel {
	
	private ViewSelect viewselect;
	
	public Banner() {
		setLayout(new GridLayout(3,1));
		JLabel space = new JLabel();
		add(space);
		JLabel label = new JLabel("Här ska det stå vilken månad man kollar på" , JLabel.CENTER);
		label.setFont(new Font("San-Serif", Font.PLAIN, 40));
 		add(label);
 		viewselect = new ViewSelect();
 		add(viewselect);
 		
	}

}
