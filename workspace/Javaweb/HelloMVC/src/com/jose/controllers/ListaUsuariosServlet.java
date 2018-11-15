package com.jose.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jose.database.BBDD;

//Este servlet recibe la peticion cuando se accede a /listausuarios
@WebServlet("/listausuarios")
public class ListaUsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Comprobar si el usuario esta en sesion. 
		
		HttpSession session = request.getSession();
		
		//Si existe el dato usuario en session, lo dejo pasar
		
        //Si no lo redirijo a login. dE manera que aunque intente acceder a lista usuarios, me va a redirigir a login
  		
		if(session.getAttribute("usuario")!=null) { //Aqui cogemos (get) el atributo usuario que establecimos en el loginservlet
			
			// Acedemos a la base de datos
			BBDD bbdd =BBDD.getinstancia();
			// peticion
			request.setAttribute("losUsuarios", bbdd.usuarios);
		
			//se lo pasamos al jsp que es la plantilla que escupe el HTML
					request.getRequestDispatcher("./listausuarios.jsp").forward(request, response);

			
		}else {
			
			response.sendRedirect("login");
			
		}
		
		
		

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
