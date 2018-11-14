package com.jose.controllers;

import com.jose.database.BBDD;
import com.jose.models.Usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// el @ nos indica que es una configuración

@WebServlet("/usuario") // Es la ruta// Es una anotacion, e sun meotodo en java que sirve para puntar
						// auna clase. Nos
						// indica la ruta de escucha de este Servlet. Es decir, la ruta de acceso. Si en
						// servlets diferentes tenemos la misma ruta, nos daría error. Por cada ruta, un
						// servlet
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// cuando enviamos una peticion get, entramos en este metodo. El metodo response
	// El resquest es un objeto concreto porque asi lo podemos manipular
	// el response es un objeto que sirver para lanzar la respuesta

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
if(session.getAttribute("usuario")!=null) {
			
			
			

			
		
		//Vamos acapturar lso parámetros. Es una variable que recuera lla variable qu estoy enviando
		String idusuario = request.getParameter("id"); //el sErvlet espera recibir un parámetro(identificador)
		System.out.println("ID recibido: "+idusuario);
		
		//Vamos a declarar una base de datos, llamamos al constructor y con ello a todos los metodos que contienen los datos
		
		int idU=Integer.parseInt(idusuario);
		BBDD bbdd = new BBDD();
		
		Usuario pepe = bbdd.getUsuarioByID(idU);  // el get solo acepta int

		// Creamos una instancia de un objeto
		
		/*Usuario pepe = new Usuario(1, "jose", "josebl90@gmail.com", 101); // Los objetos son de un modelo concreto
		Usuario juan = new Usuario(2, "juan", "juanico@gmail.com", 202);
		Usuario eloisa = new Usuario(3, "eloisa", "eloisae@gmail.com", 303);*/

		// Lanzamos la informacion con el request. El setAtribute es una "mochila" con
		// los datos que le pasamos. Tiene dos parámetros, el de clave, y e objeto que
		// quiero pasar

		request.setAttribute("elUsuario", pepe);
		/*request.setAttribute("elUsuario2", juan);
		request.setAttribute("elUsuario3", eloisa);*/

		// el request.getREquestDispatcher genera la respuesta al jsp, y el forward lo lanza
		// el dispatcher nos da un objeto que apunta a la direccion usuario.jsp

		request.getRequestDispatcher("./usuario.jsp").forward(request, response);
}else {
	
	response.sendRedirect("login");
	
}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
