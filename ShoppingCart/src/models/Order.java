package models;

public class Order {
	private Product product;
	private double discount;
	private double taxableamount;
	private double igst;
	private double total;

	public Order(Product product, double discount, double taxableamount, double igst, double total) {
		super();
		this.product = product;
		this.discount = discount;
		this.taxableamount = taxableamount;
		this.igst = igst;
		this.total = total;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTaxableamount() {
		return taxableamount;
	}

	public void setTaxableamount(double taxableamount) {
		this.taxableamount = taxableamount;
	}

	public double getIgst() {
		return igst;
	}

	public void setIgst(double igst) {
		this.igst = igst;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
