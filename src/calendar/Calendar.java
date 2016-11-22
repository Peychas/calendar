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
	
	public Calendar()
	{
		super("H�ll reda p� dina prylar");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(350,25);
		setPreferredSize(new Dimension(1200,1000));
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
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		new Calendar();

	}

}
