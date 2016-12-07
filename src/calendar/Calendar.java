package calendar;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.time.LocalDateTime;

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
	private sidebar sb;
	private addFriend af;
	private Month month;
	private Banner banner;
	public LocalDateTime now = LocalDateTime.now();
	public int manad = now.getMonthValue();
	public int år = now.getYear();
	public int dag = now.getDayOfMonth();
	public int timma = now.getHour();
	public int minut = now.getMinute();
	public int inloggid;


	

	private JPanel split2;

	private JPanel split3;

	private Week week;

	
	public Calendar()
	{
		super("Din personliga kalender");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(350,25);
		setPreferredSize(new Dimension(1300,1000));
		setResizable(false);
		
		JavaDB db = new JavaDB("localhost","root","","calendar");
		
		try
		{
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
	        
			
			
			//UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			//UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} 
		catch(Exception error){};
		JSplitPane split = new JSplitPane();
		setLayout(new GridLayout(1,1));
		split.setDividerLocation(300);
		add(split);
		
		split2 = new JPanel();
		split2.setLayout(new GridLayout(2,1));
		inloggning = new Inloggning(this);
		split2.add(inloggning);
		
		registrera = new register();
		split2.setBackground(new Color(0,180,0));
		split2.add(registrera);
		
		split.setLeftComponent(split2);
		
		
		
		
		 split3 = new JPanel();
		split3.setLayout(new GridLayout(2,1));
		banner = new Banner(this);
		split3.add(banner);
		month = new Month(this);
		split3.add(month);
		split.setRightComponent(split3);
		
		
		sb = new sidebar(this);
		af = new addFriend(this);
		
		
		
		
		
		
		
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
		split2.setLayout(new BorderLayout());
		split2.add(BorderLayout.CENTER,sb);
		JPanel south = new JPanel();
		south.setBackground(new Color(166, 166, 166));
		south.setPreferredSize(new Dimension(500,100));
		split2.add(BorderLayout.SOUTH,south);
		south.add(sb.getSignOut());
		repaint();
		pack();
		
	}
	public void Loggaut()
	{
		
	}
	
	public void showManad()
	{
		split3.remove(month);
		month = new Month(this);
		split3.add(month);
		repaint();
		pack();	
	}
	public void addFriend()
	{
		split2.remove(sb);
		af = new addFriend (this);
		split2.add(af);
		repaint();
		pack();
	}
	public void tillbaka()
	{
		split2.remove(af);
		split2.add(new sidebar(this));
		repaint();
		pack();
		
	}
	

}
