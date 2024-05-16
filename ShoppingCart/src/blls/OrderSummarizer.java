package blls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnection;
import models.Order;
import models.Product;

public class OrderSummarizer {

	public ArrayList<Order> getOrderSummary(ArrayList<Product> cart) {
		Connection con = DBConnection.getDBConnection();
		PreparedStatement ps = null;
		double igst = 0;
		double gstper = 0;
		double discount = 0;
		double taxableamount = 0;
		double total;
		ArrayList<Order> orders = new ArrayList<>();
		for (Product p : cart) {
			try {
				ps = con.prepareStatement("select hsnc_gstc_percentage from i200_hsncodes where hsnc_id=?");
				ps.setInt(1, p.getPhsnc_id());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					gstper = rs.getDouble(1);
				}
				discount = p.getPmrp() - p.getPprice();
				taxableamount = p.getPprice() / (1 + gstper / 100);
				igst = taxableamount * (gstper / 100);
				total = taxableamount + igst;
				orders.add(new Order(p, discount, taxableamount, igst, total));
			} catch (SQLException e) {
				System.out.println("SQLException at OrderSummarizer bll..." + e);
			}
		}
		return orders;
	}
}
