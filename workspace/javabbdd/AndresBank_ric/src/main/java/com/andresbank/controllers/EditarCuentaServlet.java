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

public class EditarCuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("dni") != null) {

			try {

				String cidint = request.getParameter("cid");

				int cidin = Integer.parseInt(cidint);

				Cuenta editarcuenta = CuentaDAO.getInstance().getCuentaByCid(cidin);

				request.getRequestDispatcher("/editarcuenta.jsp").forward(request, response);
			} catch (

			Exception e) {

				System.out.println(("excepcion!!: " + e.getMessage()));
			}
		} else {

			response.sendRedirect("login");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("dni") != null) { // Si estamos en sesion nos permite introducir los datos
			

			try {
				String cidrec = request.getParameter("cid");
				String nombrecuentarec = request.getParameter("nombrecuenta");
				String numerocuentarec = request.getParameter("numerocuenta");
				String saldorec = request.getParameter("saldo");
				int cidint = Integer.parseInt(cidrec);
				double saldocuenta = Double.parseDouble(saldorec);
				Cuenta newCuenta = new Cuenta(cidint, nombrecuentarec, numerocuentarec, saldocuenta);
				

				boolean nuevacuenta = CuentaDAO.getInstance().editarCuenta(newCuenta);
				if (nuevacuenta == true) {

					request.setAttribute("mensaje_ok", "La cuenta ha sido cambiada");
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
