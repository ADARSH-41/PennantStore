package daos;

import java.util.ArrayList;
import java.util.List;

import models.Product;

public interface ProductDAO {

	public ArrayList<Product> getAllProducts();
	public List<Product> getProducts(String category);
	public Product getProduct(int productId);
}
