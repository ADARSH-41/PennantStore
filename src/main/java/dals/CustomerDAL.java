package dals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConnection;
import models.Customer;

public class CustomerDAL {
	
	public static Connection con;
	
	public static boolean isCustomer(Customer c)
	{
		con = DBConnection.getDBConnection();
		try {
			
			PreparedStatement ps = con.prepareStatement("select cpassword from customers where cname=?");
			ps.setString(1, c.getCname());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
			if((rs.getString(1)).equals(rs.getString("cpassword"))) {
				return true;
			}
			}
			System.out.println("Entered");
			DBConnection.closeConnections(con, ps, rs);
		}catch(SQLException e)
		{
			System.out.println("Exception raised while Authentication in CustomerDAL..."+e);
		}
		
		return false;
	}
}
