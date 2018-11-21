package com.andresbank.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andresbank.dao.ClienteDAO;
import com.andresbank.ddbb.DDBB;
import com.andresbank.models.Cliente;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dnirec = request.getParameter("dni");
		String passrec = request.getParameter("pass");
		
		Cliente unclik;
		try {
			unclik = ClienteDAO.getInstance().getUserByDNIAndPass(dnirec, passrec);
			if (unclik != null) {
				response.sendRedirect("cuentas");
				request.getSession().setAttribute("dni", dnirec); // no es necesario crear una variable para generar la
																	// sesion si solo lo vamos a utilizzar una vez, así
																	// sería suficiente. Cuando pongo el getsession delante,
																	// el set atrbute no actua exactamente como la mochila,
																	// sino que es mas bien un flag donde anclar al sesion.
																	// Es decir, no le estamos pasando nada el jsp
			} else {
				request.setAttribute("mensaje_error", "Usuario incorrecto");
				doGet(request, response);
			}

		} catch (Exception e) {
			System.out.println(("excepcion!!: "+e.getMessage()));
			request.setAttribute("mensaje_error", "OOOOOOOOP problems");
			
			doGet(request,response);
		}

		
	}

}
