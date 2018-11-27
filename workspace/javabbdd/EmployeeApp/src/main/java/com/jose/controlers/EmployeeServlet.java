package com.jose.controlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jose.models.Employee;
import com.jose.persistencia.EmployeeManager;

public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	        String id =request.getParameter("id");
	        	
	        
		try {
			int idint = Integer.parseInt(id);
			Employee empl =EmployeeManager.getInstance().getEmployee(idint);
			request.setAttribute("unEmpleado", empl);
			
		} catch (Exception e) {
			System.out.println("Excepcion:" + e.getMessage());
			request.setAttribute("error", "Errooooooooooooooor");
		}

		request.getRequestDispatcher("/employee.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		doGet(request, response);
	}

}
