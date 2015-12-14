package srpTracking;

import java.sql.*;

import org.h2.tools.DeleteDbFiles;

public class DatabaseConnector {

	public DatabaseConnector() throws ClassNotFoundException, SQLException {

		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:C:/Program Files(x86)/H2", "Kaps", "");
		Statement stat = conn.createStatement();

		// stat.execute("insert into test values(3, 'Penis')");
		ResultSet rs;
		rs = stat.executeQuery("SELECT * FROM unterricht");
		while (rs.next()) {
			System.out.println(rs.getString("ID"));
		}
		rs.close();
		stat.close();
		conn.close();
	}

		//insert function
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
		ResultSet rs;
		rs = stat.executeQuery("SELECT * FROM unterricht");
		while (rs.next())
			for (int i = 1;i<9;i++){
				System.out.println(rs.getString(i));
			}
		id.close();
		rs.close();
		stat.close();
		conn.close();
	}
}
