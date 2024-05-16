package dals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daos.CategoryDAO;
import db.DBConnection;
import models.Category;

public class CategoryDAL implements CategoryDAO {

	private Connection con = null;

	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<>();
		try {
			con = DBConnection.getDBConnection();
			PreparedStatement ps = con.prepareStatement("select prct_title from i200_productcategories");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category c = new Category();
				c.setCategories(rs.getString(1));
				categories.add(c);
			}
			DBConnection.closeConnections(con, ps, rs);
		} catch (SQLException e) {
			System.out.println("SQL Exception at CategoryDAL");
		}
		return categories;
	}

}
