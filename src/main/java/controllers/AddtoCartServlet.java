package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dals.ProductDAL;
import daos.ProductDAO;
import models.Product;

/**
 * Servlet implementation class AddtoCartServlet
 */
@WebServlet("/addtocart")
public class AddtoCartServlet extends HttpServlet {
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
		String productId = request.getParameter("productId");
		int prodid = Integer.parseInt(productId);
		HttpSession session = request.getSession();
		
		List<Product> cart = (List<Product>)session.getAttribute("cart");
		
		if(cart==null)
		{
			cart = new ArrayList<>();
			session.setAttribute("cart", cart);
		}
		
		ProductDAO productdao = new ProductDAL();
		Product p = productdao.getProduct(prodid);
		cart.add(p);
		
		response.setContentType("text/plain");
		response.getWriter().write("product Added to Cart Successfully");
	}

}
