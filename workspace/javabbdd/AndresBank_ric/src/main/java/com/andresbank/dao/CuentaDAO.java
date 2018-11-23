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

		Connection conn = DriverManager.getConnection(url, "root", "root"); // por defecto el flag de autocommit esta
																			// puesto a true
		conn.setAutoCommit(false); // Lo cambiamos a false. de manera que no hace el commit directamente a que la
									// orden de commit la damos al final del código
		// Generamos en sql en la base de datos al insertar los valores de una nueva
		// cuenta nos genera el sqly lo copiamos aqui

		try { // por si hay error en la transaccion
				// INSERTAR CUENTA

			String sql = "INSERT INTO cuenta (nombre, numero, saldo) VALUES (?, ?, ?);";

			PreparedStatement psmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // para ejecutar el
																									// sql y también le
																									// decimpe que nos
																									// devuelval la
																									// clave general.
																									// Este segundo
																									// prámetro nos
																									// permite recibir
																									// el cid.
			psmt.setString(1, cuenta.getNombre());
			psmt.setString(2, cuenta.getNumero());
			psmt.setDouble(3, cuenta.getSaldo());

			psmt.executeUpdate(); // nos devuelve el resultado.Uitlizamos el excuteUpdate porque es un INSERT
			// me sirve para saber que se esta ejecutando
			ResultSet rs = psmt.getGeneratedKeys(); // le pedimos al psmt mediante el metodo generatekeys que nos
													// devuelva
													// el valor del cid (keys , lo que estaba como primario en la base
													// de
													// datos
			if (rs.next()) {
				cidres = rs.getInt(1);
			}
			rs.close();
			psmt.close();
			System.out.println("Creada Cuenta: " + cidres);
			// INSERTAR CLIENTE_CUENTA

			sql = "INSERT INTO `cliente_cuenta` (`cliente`, `cuenta`) VALUES (?, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, cliente.getUid());
			psmt.setInt(2, cidres);

			psmt.executeUpdate();

			psmt.close();

			conn.commit(); // Damos la orden de commit
		} catch (Exception e) {
			System.out.println("Excepcion tx: " + e.getMessage());
			cidres = 0;
			conn.rollback(); // al tener limitada ua cuenta por cliente, al crear una nueva cuenta este
								// rollback va a hacer que no aparezca en la base de datos, por eso aqui en en
								// el dao nos imprime por consola el identificado de la siguiente cuenta, el 18,
								// pero lueho no lo envia
		}
		conn.close();

		return cidres;
	}

	public Cuenta getCuentaByCid(int cid) throws SQLException {

		Cuenta resCuenta = null;

		String url = "jdbc:mysql://localhost/andresbank";

		Connection conn = DriverManager.getConnection(url, "root", "root");

		String sql2 = "SELECT c.cid,c.nombre,c.numero,c.saldo FROM cuenta c WHERE c.cid=? LIMIT 1"; // SELECT c.cid,
																									// c.nombre,
		// c.numero, c.saldo FROM cuenta
		// c, cliente_cuenta cc, cliente
		// cl WHERE c.cid=cc.cuenta AND
		// cc.cliente=cl.uid AND
		// cl.cid=?
		PreparedStatement psmt = conn.prepareStatement(sql2);
		psmt.setInt(1, cid);

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

	public boolean editarCuenta(Cuenta cuenta) throws SQLException {

		boolean todoOk = false;

		String url = "jdbc:mysql://localhost/andresbank";

		Connection conn = DriverManager.getConnection(url, "root", "root");

		String sql = "UPDATE cuenta SETnombre=?,numero=?,saldo=? WHERE cid=?";

		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, cuenta.getNombre());
		psmt.setString(2, cuenta.getNumero());
		psmt.setDouble(3, cuenta.getSaldo());
		psmt.setInt(4, cuenta.getCid());

		psmt.executeUpdate();

		todoOk = true;

		psmt.close();
		conn.close();

		return todoOk;
	}
}
