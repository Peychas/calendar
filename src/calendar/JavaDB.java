package calendar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class JavaDB {
private Connection con;
private Object[]fields;

		public JavaDB(String host,String user,String password,String databas)
		{
			try
			{
				Class.forName("org.gjt.mm.mysql.Driver").newInstance();
				con = DriverManager.getConnection("jdbc:mysql://"+host+"/"+databas,user,password);
			}
			catch(Exception error)
			{
				JOptionPane.showMessageDialog(null,error);
			}
			fields = new Object[0]; 
		}
		
		public Object[] getColums()
		{
				return fields;
			
		}
		
		public Object[][] getData(String SQL)
		{
			Object[][]data = null;
			try
			{
				Statement statement=
					con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = statement.executeQuery(SQL);
				ResultSetMetaData md = rs.getMetaData();
				int antalKolumner = md.getColumnCount();
				int antalRader = 0;
				
				/*Fyller på kolumnamnen */
				
				fields = new Object[antalKolumner];
				for(int i=0;i<fields.length;i++)
				{
					fields[i]= md.getColumnName(i+1);
				}
				
				/*Räknar antalet returrader för att klunna allokera en matris */
					
				while(rs.next())
					antalRader++;
				rs.beforeFirst();
				data = new Object[antalRader][antalKolumner];
				int rad = 0;
				while(rs.next())
				{
					for(int i=0;i< antalKolumner;i++)
					{
						data[rad][i] = rs.getString(i+1);
					}
					rad++;
				}
				
			}
			catch(Exception error)
			{
				JOptionPane.showMessageDialog(null,error);
			}
			return data;
		}
		
		public void execute(String SQL)
		{
			try
			{
				Statement statement = con.createStatement();
				statement.execute(SQL);
			}
			catch(Exception error)
			{
				JOptionPane.showMessageDialog(null,error);
			}
		}
}