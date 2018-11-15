package com.jose.controllers;

import java.io.IOException;

import com.jose.database.BBDD;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//hay un servlet por cada página que se acccede
@WebServlet("/room")
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		HttpSession session = request.getSession();
		
if(session.getAttribute("usuario")!=null) { //Aqui cogemos (get) el atributo usuario que establecimos en el loginservlet

		String idhabitacion = request.getParameter("hid"); // el servlet esta esperando un parámetro en el request
															// llamado hid
		System.out.println("HID recibido:" + idhabitacion);
		int idH = Integer.parseInt(idhabitacion);

		BBDD bbdd =BBDD.getinstancia(); // Creamos una variable que contiene la base de datos

		request.setAttribute("lahabitacion", bbdd.gethabitacion(idH)); // Nos da una habitacion en funcion del hid. EL
																		// atributo "lahabitacion" lo estomos creando
																		// aqui y es lo que contiene el valor de la base
																		// de datos mediante el método al que accedemos

		request.getRequestDispatcher("./room.jsp").forward(request, response); //la plantilla jsp va a utilizar el atributo "lahabitacion
}else {
	
	response.sendRedirect("login");
	
}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
