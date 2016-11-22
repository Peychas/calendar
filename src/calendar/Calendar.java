package calendar;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.UIManager;

public class Calendar extends JFrame {

	/**
	 * @param args
	 */
	
	private Inloggning inloggning;
	private Month month;
	
	public Calendar()
	{
		super("Håll reda på dina prylar");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(350,25);
		setPreferredSize(new Dimension(1200,1000));
		
		JavaDB db = new JavaDB("localhost","root","","calendar");
		
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception error){};
		JSplitPane split = new JSplitPane();
		setLayout(new GridLayout(1,1));
		add(split);
		inloggning = new Inloggning();
		split.setLeftComponent(inloggning);
		month = new Month();
		split.setRightComponent(month);
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		new Calendar();

	}

}
