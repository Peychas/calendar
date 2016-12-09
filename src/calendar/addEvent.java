package calendar;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class addEvent extends JFrame implements ActionListener {
	private JLabel titel;
	private JLabel stadatum;
	JTextField stdatum;
	JTextField sldatum;
	JTextField namn;
	
	public addEvent(){
		super("hejsan");
		
		setLocation(475,150);
		setPreferredSize(new Dimension(500,500));
		setResizable(true);
		JavaDB db = new JavaDB("localhost","root","","calendar");
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch(Exception error){};
		setLayout(new GridLayout(10,1));
		JPanel s = new JPanel();
		titel = new JLabel("Hejsan", JLabel.CENTER);
		titel.setFont(new Font("San-Serif", Font.PLAIN, 30));
		s.add(titel);
		add(s);
		
		JPanel n = new JPanel();
		n.setLayout(new GridLayout(1,2,10,10));
		JLabel name = new JLabel("namn", JLabel.RIGHT);
		name.setFont(new Font("Sans-Serif", Font.PLAIN,25));
		n.add(name);
		
		JPanel d = new JPanel();
		d.setLayout(new GridLayout(1,2,10,10));
		JLabel start = new JLabel("hejsan", JLabel.RIGHT);
		start.setFont(new Font("Sans-Serif", Font.PLAIN, 25));
		d.add(start);
		stdatum = new JTextField();
		d.add(stdatum);
		add(d);
		
		JLabel space = new JLabel();
		add(space);
		JPanel e = new JPanel();
		e.setLayout(new GridLayout(1,2,10,10));
		JLabel slut = new JLabel("hejdå", JLabel.RIGHT);
		slut.setFont(new Font("Sans-Serif", Font.PLAIN, 25));
		e.add(slut);
		sldatum = new JTextField();
		e.add(sldatum);
		add(e);
		
		pack();
		setVisible(true);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
