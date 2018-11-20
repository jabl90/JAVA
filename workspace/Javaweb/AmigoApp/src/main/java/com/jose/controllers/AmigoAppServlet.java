package com.jose.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jose.models.Amigo;

@WebServlet("/amigoapp")
public class AmigoAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/amigoapp.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombrerec = request.getParameter("nombre");
		String moterec = request.getParameter("mote");
		String edadrec = request.getParameter("edad");
		String emailrec = request.getParameter("email");
		String passwordrec = request.getParameter("password");
		
		int edadamigo=0;
		
		try { 	edadamigo = Integer.parseInt(edadrec);
			
		} catch (Exception e) { // e es una variable local de tipo Exception que contiene la excepcion

			System.out.println("Excepcion!!" + e.getMessage());

		}

		Amigo newamigo = new Amigo(nombrerec, moterec, edadamigo, emailrec, passwordrec);

		if (newamigo.esValido(moterec)) {

			request.setAttribute("newamigo", newamigo);
			this.doGet(request, response);
		} else {
			request.setAttribute("mensajeerror", "Datos incorrectos");
			this.doGet(request, response); //porque mostramos el mismo formulario que en el doge
		}
	}

}
