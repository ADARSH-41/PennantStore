package dals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daos.ProductDAO;
import db.DBConnection;
import models.Product;

public class ProductDAL implements ProductDAO {

	public ArrayList<Product> getAllProducts() {
		Connection con = DBConnection.getDBConnection();
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			PreparedStatement ps = con.prepareStatement(
					"select p.*,ps.prod_batchno,ps.prod_price,ps.prod_stock,ps.prod_mrp from i200_products p inner join i200_productstock ps on p.prod_id=ps.prod_id");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				products.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getInt(9), rs.getDouble(10)));
			}
			DBConnection.closeConnections(con, ps, rs);
		} catch (SQLException e) {
			System.out.println("Exception occured at ProductDAL getAllProducts() method..." + e);
		}

		return products;
	}

	public List<Product> getProducts(String category) {
		Connection con = DBConnection.getDBConnection();
		List<Product> products = new ArrayList<Product>();
		try {
			PreparedStatement ps = con.prepareStatement(
					"select p.*,ps.prod_batchno,ps.prod_price,ps.prod_stock,ps.prod_mrp from i200_productcategories pc join i200_products p on pc.prct_id=p.prod_prct_id join i200_productstock ps on p.prod_id=ps.prod_id where pc.prct_title=?");
			ps.setString(1, category);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				products.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getInt(9), rs.getDouble(10)));
			}
			DBConnection.closeConnections(con, ps, rs);
		} catch (SQLException e) {
			System.out.println("Exception occured at ProductDAL getProducts(String Category) method..." + e);
		}

		return products;
	}

	public Product getProduct(int productId) {
		Product p = null;
		try {
			Connection con = DBConnection.getDBConnection();
			PreparedStatement ps = con.prepareStatement(
					"select p.*,ps.prod_batchno,ps.prod_price,ps.prod_stock,ps.prod_mrp from i200_products p join i200_productstock ps on p.prod_id=ps.prod_id where p.prod_id=?");
			ps.setInt(1, productId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getInt(9), rs.getDouble(10));
			}

			DBConnection.closeConnections(con, ps, rs);
		} catch (SQLException e) {
			System.out.println("SQL Exception at getProduct(String ProductId) function..." + e);
		}
		return p;
	}
}
