package com.andresbank.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andresbank.dao.ClienteDAO;
import com.andresbank.ddbb.DDBB;
import com.andresbank.models.Cuenta;

public class UnaCuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recogiendo el parámetro
		String cid = request.getParameter("cid");

		// Si existe el cid, pedimos a la bbdd que busque la cuenta por el cid
		try {
			Cuenta miCuenta = ClienteDAO.getInstance().getCuentaByCid(cid);
			System.out.println("cuenta:"+miCuenta);
			if (miCuenta != null) {
				request.setAttribute("miCuenta", miCuenta); //El setAttribute tiene que ir por encima del dispatcher
				request.getRequestDispatcher("unacuenta.jsp").forward(request, response);
				
			} else {
				request.setAttribute("mensaje_error", "Esta no es su cuenta");
			}
		} catch (Exception e) {

			System.out.println(("excepcion!!: " + e.getMessage()));
			request.setAttribute("mensaje_error", "Error con la be de datos");

			e.printStackTrace();
		} 

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
