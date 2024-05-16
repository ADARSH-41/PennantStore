package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dals.ProductDAL;
import daos.ProductDAO;
import models.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductDAO productdao = new ProductDAL();
		ArrayList<Product> products = productdao.getAllProducts();
		Gson gson = new Gson();
		String json = gson.toJson(products);
		System.out.println(json);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category=request.getParameter("category");
		ProductDAO productdao = new ProductDAL();
		List<Product> products=productdao.getProducts(category);
		Gson gson = new Gson();
		String json = gson.toJson(products);
		System.out.println(json);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

}
