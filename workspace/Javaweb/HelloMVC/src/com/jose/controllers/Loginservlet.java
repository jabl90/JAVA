package com.jose.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jose.database.BBDD;

//El  servlet es una clase que lo que hace es responder a peticiones

@WebServlet("/login")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//Cuando entramos en GET pedimos el metodo doGet, nos devuelve informacion

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("./login.jsp").forward(request, response); //el request dispatcher crea el objeto y con el forward lo lanzamos

	}

	// Cuando enviamos los datos, entramos en le método doPost. Enviamos informacion
	// al servidor

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recoge en las variables emailrecibido y password recibido el email y password
		// que estoy enviando

		//pregunta si existe un usario con ese email y password
		String emailrecibido = request.getParameter("email"); // El nombre del parametrose corresponde con el name del
																// input
		String passwordrecibido = request.getParameter("password");

		System.out.println("Estoy en el post!!");
		System.out.println("Email: " + emailrecibido);
		System.out.println("Password: " + passwordrecibido);
		
		//instanciamos la base de datos
		
		BBDD bd =BBDD.getinstancia();

		// decidir si existe usuario con ese email y password, entrar en lista usuarios (zona privada),
		// y si no volver a mostrar formulario. De modo que el servlet va a decidir

		boolean existeUser = bd.existeUsuarioPorEmailyPass(emailrecibido, passwordrecibido); //metodo
		
		HttpSession session = request.getSession();
		
		if (existeUser) {

			// LLevarlo a lista de usuarios, hago un dispacht a otro servlet, al de listas
			// de usuario

			// request.getRequestDispatcher("./listausuarios").forward(request, response);
			// //el propio servidor redirige. No se observan cambios en la direccion de la
			// pagina. Se utuliza para redireccion hacia plantillas (entre servlet y jsp)

			// Otra forma
			
			//Vamos a crear un flag de sesssion
            session.setAttribute("usuario", emailrecibido);
			response.sendRedirect("listausuarios");// direccion relativa no absoluta. //Envia una cabecera de
													// redireccion que permite enterarse al usuario. Permite al usuario
													// ver la ruta en el navegador
			// Es recomendable utilizar el response si el usuario interactua.
			
			
		
		} else {
			// devovlerlo a login
			request.setAttribute("errormensaje", "Usuario y contraseña no existe"); // clave error

			this.doGet(request, response); // si me muestra datos erroneos lo devuelvo al doGet
		}
	}

}
