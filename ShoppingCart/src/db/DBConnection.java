package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static Connection getDBConnection() {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://192.168.110.48:5432/training?user=plf_training_admin&password=pff123";
			con = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println("SQL Exception occured at database connection..." + e);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException occured during connecting to database..." + e);
		}
		return con;
	}

	public static void closeConnections(Connection con, Statement st, ResultSet rs) {
		try {
			if (con != null)
				con.close();
			if (st != null)
				st.close();
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			System.out.println("Exception Occured while closing connections..." + e);
		}
	}
}
