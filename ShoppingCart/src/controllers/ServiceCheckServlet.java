package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dals.ServiceRegionDAL;
import daos.ServiceRegionDAO;

/**
 * Servlet implementation class ServiceCheckServlet
 */
@WebServlet("/checkserviceavailability")
public class ServiceCheckServlet extends HttpServlet {
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
		String pincode = request.getParameter("pincode");
		int pin = Integer.parseInt(pincode);
		ServiceRegionDAO srdao = new ServiceRegionDAL(); 
		boolean res = srdao.checkAvailability(pin);
		
		response.setContentType("text/plain");
		
		if(res) {
			response.getWriter().write("available");
		}else {
			response.getWriter().write("unavailable");
		}
	}

}
