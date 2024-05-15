package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static Connection getDBConnection()
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/pennantstore?user=root&password=19178";
			con = DriverManager.getConnection(url);
		}catch(SQLException e) {
			System.out.println("SQL Exception occured at database connection..."+e);
		}catch(ClassNotFoundException e)
		{
			System.out.println("ClassNotFoundException occured during connecting to database..."+e);
		}
		return con;
	}
	
	public static void closeConnections(Connection con,Statement st,ResultSet rs)
	{
		try {
			if(con!=null)
				con.close();
			if(st!=null)
				st.close();
			if(rs!=null)
				rs.close();
		}catch(Exception e)
		{
			System.out.println("Exception Occured while closing connections..."+e);
		}
	}
}
