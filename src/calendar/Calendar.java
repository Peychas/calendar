package calendar;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Calendar extends JFrame {

	/**
	 * @param args
	 */
	
	private Inloggning inloggning;
	private register registrera ;
	private sidebar sidebar;
	private Month month;
	private Banner banner;
	public int manad = 0;


	private JPanel split2;

	private JSplitPane split3;

	private Week week;

	
	public Calendar()
	{
		super("Din personliga kalender");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(350,25);
		setPreferredSize(new Dimension(1200,1000));
		setResizable(true);
		
		JavaDB db = new JavaDB("localhost","root","","calendar");
		
		try
		{
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		
	        System.out.println(info.getClassName());
			}
			//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			//UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} 
		catch(Exception error){};
		JSplitPane split = new JSplitPane();
		setLayout(new GridLayout(1,1));
		split.setDividerLocation(300);
		add(split);
		//JPanel split2 = new JPanel();
		split2 = new JPanel();
		split2.setLayout(new GridLayout(2,1));
		inloggning = new Inloggning(this);
		split2.add(inloggning);
		
		registrera = new register();
		//split2.setBackground(new Color(0,180,0));
		split2.add(registrera);
		
		split.setLeftComponent(split2);
		
		
		
		
		JPanel split3 = new JPanel();
		split3.setLayout(new GridLayout(2,1));
		banner = new Banner();
		split3.add(banner);
		week = new Week();
		split3.add(week);
		split.setRightComponent(split3);
		//add(new sidebar(this));
		sidebar = new sidebar(this);
		
		
		
		
		
		
		
		
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		new Calendar();

	}
	public void changeSplit2()
	{
		split2.remove(inloggning);
		split2.remove(registrera);
		//split2.setLayout(new GridLayout(1,1));
		split2.add(sidebar);
		repaint();
		pack();
		
	}

}
