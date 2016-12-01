package calendar;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.UIManager;

public class Calendar extends JFrame {

	/**
	 * @param args
	 */
	
	private Inloggning inloggning;
	private register registrera ;
	private Month month;
	private Banner banner;
	public int manad = 0;
	private Week week;
	
	public Calendar()
	{
		super("Din personliga kalender");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(350,25);
		setPreferredSize(new Dimension(1200,1000));
		setResizable(false);
		
		JavaDB db = new JavaDB("localhost","root","","calendar");
		
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception error){};
		JSplitPane split = new JSplitPane();
		setLayout(new GridLayout(1,1));
		add(split);
		JPanel split2 = new JPanel();
		split2.setLayout(new GridLayout(2,1));
		inloggning = new Inloggning();
		split2.add(inloggning);
		registrera = new register();
		split2.add(registrera);
		split.setLeftComponent(split2);
		JPanel split3 = new JPanel();
		split3.setLayout(new GridLayout(2,1));
		banner = new Banner();
		split3.add(banner);
		week = new Week();
		split3.add(week);
		split.setRightComponent(split3);
		
		
		
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		new Calendar();

	}

}
