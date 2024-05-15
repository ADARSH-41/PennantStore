package dals;

import java.sql.Connection;
import java.sql.PreparedStatement;

import daos.ServiceRegionDAO;
import db.DBConnection;

public class ServiceRegionDAL implements ServiceRegionDAO{

	@Override
	public boolean checkAvailability(int pin) {
		// TODO Auto-generated method stub
		boolean res=false;
		try {
			Connection con = DBConnection.getDBConnection();
			PreparedStatement ps = con.prepareStatement("select srrg_name from serviceableregions where ?>=srrg_pinfrom and ?<=srrg_pinto");
			ps.setInt(1, pin);
			ps.setInt(2, pin);
			res = ps.execute();
			
			DBConnection.closeConnections(con, ps, null);
		}catch(Exception e) {
			System.out.println("Exception at ServiceRegionDAL..."+e);
		}
		
		return res;
	}

	
}
