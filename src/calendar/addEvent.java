package calendar;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.UIManager;

public class addEvent extends JFrame implements ActionListener {
	private JLabel titel;
	private java.util.Calendar calen;
	JSpinner stdatum;
	JSpinner sldatum;
	JTextField namn;
	JTextArea kommentar;
	JButton submit;
	private DateFormat getFocusDate = new SimpleDateFormat("yyyy/MM/dd");
	private calendar.Calendar cal;
	JavaDB db = new JavaDB("localhost", "root", "", "calendar");
	

	public addEvent(calendar.Calendar cal, ActionListener actionListener) {
		super("hejsan");
		this.cal = cal;
		calen = Calendar.getInstance();
		setLocation(475, 150);
		setPreferredSize(new Dimension(725, 650));
		setResizable(true);
		

		String formatDate = "";

		formatDate = cal.år + "/" + addZero(cal.manad) + "/" + addZero(cal.dag) + " " + addZero(cal.timma) + ":" + addZero(cal.minut);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception error) {
		}
		;
		try {
			Date focusedDate = getFocusDate.parse(formatDate);
		} catch (ParseException e) {
			System.out.println("Date Conversion failed!");
		}
		setLayout(new GridLayout(10, 1, 20, 20));
		JPanel s = new JPanel();
		titel = new JLabel("Lägg till händelse", JLabel.CENTER);
		titel.setFont(new Font("San-Serif", Font.BOLD, 30));
		s.add(titel);
		add(s);

		JPanel d = new JPanel();
		d.setLayout(new GridLayout(1, 2, 10, 10));
		JLabel start = new JLabel("Start tid", JLabel.RIGHT);
		start.setFont(new Font("Sans-Serif", Font.PLAIN, 25));
		d.add(start);
		stdatum = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(stdatum, "yyyy-MM-dd HH:mm");
		//dateEditor.getTextField().setEnabled( true );
        dateEditor.getTextField().setEditable( false );
		stdatum.setEditor(dateEditor);
		stdatum.setFont(new Font("Sans-Serif", Font.PLAIN, 25));
		d.add(stdatum);
		JLabel space2 = new JLabel();
		d.add(space2);
		add(d);

		JPanel e = new JPanel();
		e.setLayout(new GridLayout(1, 3, 10, 10));
		JLabel slut = new JLabel("Slut tid", JLabel.RIGHT);
		slut.setFont(new Font("Sans-Serif", Font.PLAIN, 25));
		e.add(slut);
		sldatum = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
		JSpinner.DateEditor dateEditor1 = new JSpinner.DateEditor(sldatum, "yyyy-MM-dd HH:mm");
		dateEditor1.getTextField().setEnabled( true );
		dateEditor1.getTextField().setEditable( false );
		sldatum.setEditor(dateEditor1);
		sldatum.setFont(new Font("Sans-Serif", Font.PLAIN, 25));
		e.add(sldatum);
		JLabel space1 = new JLabel();
		e.add(space1);
		add(e);

		JPanel m = new JPanel();
		m.setLayout(new GridLayout(1, 3, 10, 10));
		JLabel name = new JLabel("Namn på händelse", JLabel.RIGHT);
		name.setFont(new Font("Sans-Serif", Font.PLAIN, 25));
		m.add(name);
		namn = new JTextField();
		namn.setFont(new Font("Sans-Serif", Font.PLAIN, 25));
		m.add(namn);
		JLabel space4 = new JLabel();
		m.add(space4);
		add(m);

		JPanel k = new JPanel();
		k.setLayout(new GridLayout(1, 3, 10, 10));
		JLabel kommenta = new JLabel("Kommentar", JLabel.RIGHT);
		kommenta.setFont(new Font("Sans-Serif", Font.PLAIN, 25));
		k.add(kommenta);
		kommentar = new JTextArea();
		kommentar.setFont(new Font("Sans-Serif", Font.PLAIN, 15));
		k.add(kommentar);
		JLabel space5 = new JLabel();
		k.add(space5);
		add(k);
		
		JLabel space6 = new JLabel();
		add(space6);
		
		JPanel u = new JPanel();
		u.setLayout(new GridLayout(1, 3, 10 ,10));
		JLabel space7 = new JLabel();
		u.add(space7);
		submit = new JButton("Skicka");
		submit.setFont(new Font("Sans-Serif", Font.PLAIN, 25));
		submit.addActionListener(this);
		u.add(submit);
		JLabel space8 = new JLabel();
		u.add(space8);
		add(u);
		

		pack();
		setVisible(true);

	}

	public String addZero(int tal) {
		if(tal < 10)
		{
			return "0" + tal;
		}else{
			return "" + tal;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submit){
			String stadatum = (String) stdatum.getValue().toString();
			DateFormat format1 = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", Locale.ENGLISH);
			java.util.Calendar flop1=Calendar.getInstance();
			Date date1 = null;
			try {
				date1 = format1.parse(stadatum);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			flop1.setTime(date1);
			String aswewantit1 = ""+flop1.get(Calendar.YEAR)+"-"+flop1.get(Calendar.MONTH)+"-"+flop1.get(Calendar.DAY_OF_MONTH)+" "+flop1.get(Calendar.HOUR_OF_DAY)+":"+flop1.get(Calendar.MINUTE);
			System.out.println(aswewantit1);
			String sludatum = (String) sldatum.getValue().toString();
			DateFormat format = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", Locale.ENGLISH);
			java.util.Calendar flop=Calendar.getInstance();
			Date date = null;
			try {
				date = format.parse(sludatum);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			flop.setTime(date);
			String aswewantit = ""+flop.get(Calendar.YEAR)+"-"+flop.get(Calendar.MONTH)+"-"+flop.get(Calendar.DAY_OF_MONTH)+" "+flop.get(Calendar.HOUR_OF_DAY)+":"+flop.get(Calendar.MINUTE);
			System.out.println(aswewantit);
			String nam = namn.getText();
			//System.out.println(nam);
			String kommen = kommentar.getText();
			//System.out.println(kommen);
			String SQL = String.format("INSERT INTO event(name, starttime, stoptime, comment, user) VALUES"
					+ " ('%s', '%s', '%s', '%s', '%s');  ", nam, aswewantit1, aswewantit, kommen, cal.inloggid);
			System.out.println(SQL);
			db.execute(SQL);
		}

	}

}
