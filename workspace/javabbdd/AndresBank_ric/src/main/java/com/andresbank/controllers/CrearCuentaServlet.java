package com.andresbank.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andresbank.dao.ClienteDAO;
import com.andresbank.dao.CuentaDAO;
import com.andresbank.models.Cliente;
import com.andresbank.models.Cuenta;

public class CrearCuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("dni") != null) { //Verificamos si estamos en sesion

			request.getRequestDispatcher("/crearcuenta.jsp").forward(request, response); 

		} else {

			response.sendRedirect("login"); //sino estamos en sesion nos redirije al login

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("dni") != null) { //Si estamos en sesion nos permite introducir los datos

			String nombrecuentarec = request.getParameter("nombrecuenta");
			String numerocuentarec = request.getParameter("numerocuenta");
			String saldorec = request.getParameter("saldo");

			try {
				double saldocuenta = Double.parseDouble(saldorec);
				String dnisesion = (String) request.getSession().getAttribute("dni"); // Lo casteamos
				Cuenta newCuenta = new Cuenta(0, nombrecuentarec, numerocuentarec, saldocuenta);
				Cliente miCliente=ClienteDAO.getInstance().getUserByDNI(dnisesion);

				
				int newCid = CuentaDAO.getInstance().crearCuenta(newCuenta, miCliente); // LA variable
																										// newCid es de
																										// tipo int, y
																										// el método en
																										// el DAO
				                                                                                       // también tiene
				                                                                                       // que ser int
				if (newCid > 0) {  //Este fragmento de código es el que decide

					response.sendRedirect("cuentas");
				} else {
					request.setAttribute("mensajeerror", "La cuenta nose ha creado");
					doGet(request, response);
				}
				
			} catch (Exception e) {
				request.setAttribute("mensajeerror", "OOOPP. Intentalo mas tarde");
				doGet(request, response);
			}
		} else {
			response.sendRedirect("login");
		}

	}
}
