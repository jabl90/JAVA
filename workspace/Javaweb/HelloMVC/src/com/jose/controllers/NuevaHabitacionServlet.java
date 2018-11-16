package com.jose.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jose.database.BBDD;
import com.jose.models.Room;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

@WebServlet("/nuevahabitacion")
public class NuevaHabitacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Room> nuevahabitacion = BBDD.getinstancia().habitaciones;

		request.setAttribute("lanuevahabitacion", nuevahabitacion);
		request.getRequestDispatcher("/nuevahabitacion.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { //Con el throw le lanzamos "la pelota" a tomcat si hay un error.

		String callerecibida = request.getParameter("calle"); // El nombre del parametro se corresponde con el name del input
		String metrosrecibidos = request.getParameter("metros");
		
		System.out.println("calle: "+callerecibida+" metros: "+metrosrecibidos);
		
		int metros2recibidos = 0;
		
		try {
			metros2recibidos=Integer.parseInt(metrosrecibidos);
		} catch(Exception e) { // e es una variable local de tipo Exception que contiene la excepcion
			
			System.out.println("Excepcion!!"+e.getMessage());
			
			
		}
		
		Room newroom =new Room(0, callerecibida, metros2recibidos);
		
		if(newroom.esValido()) {
		
		BBDD db = BBDD.getinstancia(); 
		db.insertaNuevaHabitacion(newroom);
		
		response.sendRedirect("nuevousuario");
		}else {
			request.setAttribute("mensajeerror", "Datos incorrectos");
			request.setAttribute("newroom", newroom);
			this.doGet(request, response);
		}
	}

}
