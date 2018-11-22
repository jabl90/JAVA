package com.andresbank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.andresbank.models.Cliente;
import com.andresbank.models.Cuenta;
import com.mysql.jdbc.Statement;

public class CuentaDAO {

	private static CuentaDAO instance = null;

	public static CuentaDAO getInstance() throws Exception {

		if (instance == null)
			instance = new CuentaDAO();

		return instance;

	}

//Carga del driver
	private CuentaDAO() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance(); // new com.mysql.jdbc.Driver. Es igual pero es mejor
																// manejarse con un String

	}

	public ArrayList<Cuenta> getCuentasByDni(String dni) throws SQLException {

		ArrayList<Cuenta> cuentasEncontradas = null;

		String url = "jdbc:mysql://localhost/andresbank";

		Connection conn = DriverManager.getConnection(url, "root", "root");

		String sql = "SELECT c.cid, c.nombre, c.numero, c.saldo FROM cuenta c, cliente_cuenta cc, cliente cl WHERE c.cid=cc.cuenta AND cc.cliente=cl.uid AND cl.dni=?";

		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, dni);

		ResultSet rs = psmt.executeQuery(); // nos devuelve el resultado.
		System.out.println("ResultSet:" + rs); // me sirve para saber que se esta ejecutando

		cuentasEncontradas = new ArrayList<Cuenta>();
		while (rs.next()) {

			System.out.println("ResultSet: " + rs.getInt(1) + "::" + rs.getString(2) + "::" + rs.getString(3) + "::"
					+ rs.getString(4));

			cuentasEncontradas.add(new Cuenta(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
		}
		System.out.println("ArrayList resultantes:" + cuentasEncontradas);
		rs.close();
		psmt.close();
		conn.close();

		return cuentasEncontradas;
	}

	public int crearCuenta(Cuenta cuenta, Cliente cliente) throws SQLException {

		int cidres = 0;

		String url = "jdbc:mysql://localhost/andresbank";

		Connection conn = DriverManager.getConnection(url, "root", "root");

		// Generamos en sql en la base de datos al insertar los valores de una nueva
		// cuenta nos genera el sqly lo copiamos aqui

		String sql = "INSERT INTO cuenta (nombre, numero, saldo) VALUES (?, ?, ?);";

		PreparedStatement psmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // para ejecutar el sql y
																								// también le decimpe
																								// que nos devuelval la
																								// clave general Este
																								// segundo aprámetro nos
																								// permite recibir el
																								// cid.
		psmt.setString(1, cuenta.getNombre());
		psmt.setString(2, cuenta.getNumero());
		psmt.setDouble(3, cuenta.getSaldo());

		psmt.executeUpdate(); // nos devuelve el resultado.Uitlizamos el excuteUpdate porque es un INSERT
		// me sirve para saber que se esta ejecutando
        ResultSet rs = psmt.getGeneratedKeys();
		if(rs.next()) {
			cidres=rs.getInt(1);
		}
        rs.close();
		psmt.close();
		

		//INSERTAR CLIENTE_CUENTA
		
		sql="INSERT INTO `cliente_cuenta` (`cliente`, `cuenta`) VALUES (?, ?)";
		psmt=conn.prepareStatement(sql);
		psmt.setInt(1, cliente.getUid());
		psmt.setInt(2, cidres);
		
		
		psmt.executeUpdate();
		
		
		psmt.close();
		conn.close();
		
		return cidres;
	}
}
