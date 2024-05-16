package controllers;

import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dals.CategoryDAL;
import daos.CategoryDAO;
import models.Category;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/categories")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CategoryDAO categorydao;
		try {
			categorydao = new CategoryDAL();
			List<Category> categories = categorydao.getAllCategories();
			Gson gson = new Gson();
			String json = gson.toJson(categories);
			System.out.println(json);
			response.setContentType("application/json");
			response.getWriter().write(json);
	}catch(Exception e)
		{
			System.out.println("Exception at CategoryServlet");
		}
	}

}
