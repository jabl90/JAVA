package com.jose.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jose.database.BBDD;
import com.jose.models.Usuario;


@WebServlet("/borrarusuario")
public class BorrarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idusuario = request.getParameter("id");
		System.out.println("ID recibido: " + idusuario);

		int idU = Integer.parseInt(idusuario);

		BBDD.getinstancia().borrarUser(idU); 


		response.sendRedirect("listausuarios");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

		doGet(request, response);
	}

}
