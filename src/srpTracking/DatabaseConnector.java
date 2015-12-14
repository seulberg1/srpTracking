package srpTracking;

import java.sql.*;
import java.util.Arrays;


public class DatabaseConnector {

	public DatabaseConnector() throws ClassNotFoundException, SQLException {

		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:C:/Program Files(x86)/H2", "Kaps", "");
		Statement stat = conn.createStatement();

		/* Old execution code, kept as an example
		 * stat.execute("insert into test values(3, 'Penis')");
		* ResultSet rs;
		*rs = stat.executeQuery("SELECT * FROM unterricht");
		*while (rs.next()) {
		*	System.out.println(rs.getString("ID"));
		}*/
		stat.close();
		conn.close();
	}

		//insert lessons into UNTERRICHT tabel function
	public void insert(String Eintrag) throws ClassNotFoundException, SQLException {
		// Get Connection
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:C:/Program Files(x86)/H2", "Kaps", "");
		Statement stat = conn.createStatement();
		// What is the highest ID, add next entry to id+1
		ResultSet id;
		int ergebnis = 0;
		id = stat.executeQuery("SELECT MAX(ID) FROM unterricht");
		// cursor is one row before the action starts..., so you need id.next
		while (id.next()) {
			ergebnis = id.getInt(1) + 1;
		}
		stat.execute("INSERT INTO UNTERRICHT VALUES(" + ergebnis + "," + Eintrag);
		id.close();
		stat.close();
		conn.close();
	}
	public String[][] retrieveForTable() throws ClassNotFoundException, SQLException{
		
		// Get Connection
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:C:/Program Files(x86)/H2", "Kaps", "");
		
		//scroll insenstive, so you can scroll back and forth
		Statement stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs;
		
		//Query the last 3 additions
		rs = stat.executeQuery("SELECT * FROM unterricht ORDER BY id DESC LIMIT 3");
		int count = 0;
		while(rs.next()){
			++count;
		}
		//Reset cursor to before first row
		rs.beforeFirst();
		String [][] queryErgebniss = new String [count][rs.getMetaData().getColumnCount()];
		int r = 0;
		while(rs.next()){
			for (int c=1;c<rs.getMetaData().getColumnCount()+1;c++){
				queryErgebniss[r][c-1]= rs.getString(c);
			}
			++r;
		}
		rs.close();
		stat.close();
		conn.close();
		
		return queryErgebniss;
	}
}
