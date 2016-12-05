package calendar;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.YearMonth;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewSelect extends JPanel implements ActionListener {
	
	private JButton previous;
	private Calendar cal;
	private Banner ban;
	
	public ViewSelect(Calendar cal,Banner ban){
		this.cal=cal;this.ban=ban;
		setLayout(new GridLayout(3,9));
		JLabel[] labels = new JLabel[18];
		for(int i = 0; i < labels.length; i++){
			labels[i] = new JLabel();
			add(labels[i]);
		}
		previous = new JButton("<");
		add(previous);
		JButton next = new JButton(">");
		add(next);
		JButton today = new JButton("Idag");
		add(today);
		JLabel space = new JLabel();
		add(space);
		JLabel space2 = new JLabel();
		add(space2);
		JButton year = new JButton("År");
		add(year);
		JButton month = new JButton("Månad");
		add(month);
		JButton week = new JButton("Vecka");
		add(week);
		JButton day = new JButton("Dag");
		add(day);
		previous.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == previous){
			ban.showBanner();
			cal.manad -= 1;
			cal.showManad();
		}
		
	}
}
