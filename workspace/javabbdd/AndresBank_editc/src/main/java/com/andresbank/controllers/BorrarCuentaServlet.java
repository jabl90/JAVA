package com.andresbank.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andresbank.dao.CuentaDAO;
import com.andresbank.models.Cuenta;


public class BorrarCuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getSession().getAttribute("dni") != null) {
					
			try {
				String cidrec = request.getParameter("cid");
				
				int cdint =Integer.parseInt(cidrec);
	
				boolean borrarMiCuenta = CuentaDAO.getInstance().borrarCuenta(cdint);
				if(borrarMiCuenta==true) {
					response.sendRedirect("cuentas");
				}
				
			} catch (Exception e) {
				System.out.println("Excepcion:"+e.getMessage());
			}
			
			request.getRequestDispatcher("/cuentas.jsp").forward(request, response);
		} else {
			
			request.setAttribute("mensaje_error","La cuenta no se ha borrado");
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
