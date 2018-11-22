package com.andresbank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.andresbank.models.Cliente;
import com.andresbank.models.Cuenta;

public class ClienteDAO {

	private static ClienteDAO instance = null;

	public static ClienteDAO getInstance() throws Exception {

		if (instance == null)
			instance = new ClienteDAO();

		return instance;

	}

//Carga del driver
	private ClienteDAO() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance(); // new com.mysql.jdbc.Driver. Es igual pero es mejor
																// manejarse con un String

	}

	public Cliente getUserByDNIAndPass(String dnirec, String passrec) throws SQLException { // conexión siempre mediante
																							// un método
		Cliente resCliente = null;

		String url = "jdbc:mysql://localhost/andresbank"; // url de nuestra base de datos

		// Hacemos la conexion con el servidor(base de datos) y luego hacemos peticiones
		Connection conn = DriverManager.getConnection(url, "root", "root");
		// Enviamos una orden a la base de datos
		String sql = "SELECT uid, nombre, dni, pin, nomina FROM `cliente` WHERE dni=? AND pin=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, dnirec);
		psmt.setString(2, passrec);

		ResultSet rs = psmt.executeQuery(); // nos devuelve el resultado. Es un tipo muy especial de aaray
		System.out.println("ResultSet:" + rs);

		while (rs.next()) {

			resCliente = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			System.out.println("ResultSet: " + rs.getInt(1) + "::" + rs.getString(2) + "::" + rs.getString(3) + "::"
					+ rs.getString(4));
		}
		rs.close();
		psmt.close();
		conn.close(); // verificamos que la conexion se cierra

		return resCliente;
	}

	public Cuenta getCuentaByCid(String cid) throws SQLException {

		Cuenta resCuenta = null;

		String url = "jdbc:mysql://localhost/andresbank";

		Connection conn = DriverManager.getConnection(url, "root", "root");

		String sql2 = "SELECT cid, nombre, numero, saldo FROM `cuenta` WHERE cid=?";

		PreparedStatement psmt = conn.prepareStatement(sql2);
		psmt.setString(1, cid);

		ResultSet rs = psmt.executeQuery(); // nos devuelve el resultado.
		System.out.println("ResultSet:" + rs);

		while (rs.next()) {

			resCuenta = new Cuenta(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
		}

		rs.close();
		psmt.close();
		conn.close();

		return resCuenta;

	}

	public Cliente getUserByDNI(String dnisesion) throws SQLException {
		
		Cliente resCliente = null;

		String url = "jdbc:mysql://localhost/andresbank"; // url de nuestra base de datos

		// Hacemos la conexion con el servidor(base de datos) y luego hacemos peticiones
		Connection conn = DriverManager.getConnection(url, "root", "root");
		// Enviamos una orden a la base de datos
		String sql = "SELECT uid, nombre, dni, pin, nomina FROM `cliente` WHERE dni=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, dnisesion);
		

		ResultSet rs = psmt.executeQuery(); // nos devuelve el resultado. Es un tipo muy especial de aaray
		System.out.println("ResultSet:" + rs);

		if(rs.next()) {

			resCliente = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			System.out.println("ResultSet: " + rs.getInt(1) + "::" + rs.getString(2) + "::" + rs.getString(3) + "::"
					+ rs.getString(4));
			
			
		}
		rs.close();
		psmt.close();
		conn.close(); // verificamos que la conexion se cierra

		return resCliente;
		
	}
	
}
