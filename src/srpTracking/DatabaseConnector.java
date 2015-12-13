package srpTracking;

import java.sql.*;

import org.h2.tools.DeleteDbFiles;

public class DatabaseConnector {

    public DatabaseConnector() throws ClassNotFoundException, SQLException{

        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:C:/Program Files(x86)/H2","Kaps","");
        Statement stat = conn.createStatement();
        System.out.println(stat);

        //stat.execute("insert into test values(3, 'Penis')");
        ResultSet rs;
        rs = stat.executeQuery("select * from unterricht");
        while (rs.next()) {
            System.out.println(rs.getString("id"));
        }
    }
    public void close() throws ClassNotFoundException, SQLException{
    	Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:~/test");
        Statement stat = conn.createStatement();
    	stat.close();
        conn.close();
    }
}

