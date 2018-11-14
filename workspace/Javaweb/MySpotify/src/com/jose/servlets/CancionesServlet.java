package com.jose.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jose.database.BBDDCanciones;
import com.jose.models.Cancion;


@WebServlet("/listacanciones")
public class CancionesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idcancion = request.getParameter("id"); //se espera recibir un parámetro
		System.out.println("ID recibido: "+idcancion);
		
		//Recolectar las funciones de la base de datos
		int idC=Integer.parseInt(idcancion);
		BBDDCanciones bbddcan = new BBDDCanciones();
		
		Cancion cancionbeatles = bbddcan.getCancion(idC);
		// Pasar al jsp las canciones
		request.setAttribute("lacancion", cancionbeatles);
		
		request.getRequestDispatcher("./listacanciones.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
