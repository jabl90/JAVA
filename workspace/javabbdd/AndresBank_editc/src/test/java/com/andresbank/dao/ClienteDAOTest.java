package com.andresbank.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import com.andresbank.models.Cliente;

public class ClienteDAOTest extends TestAndres {

	@BeforeClass
	public static void setUpClass() {
		setUpContext();
	}

	@Test
	public void getUserByDNIAndPassVoid() {

		String dni = "";
		String pass = "";

		Cliente clienteEncontrado;

		try {

			clienteEncontrado = ClienteDAO.getInstance().getUserByDNIAndPass(dni, pass);

			assertNull(clienteEncontrado);

		} catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}

	}

	@Test
	public void asociarUserByDNIAndPassExiste() {

		String dni = "56400670R" + 
				"";
		String pass = "8976";

		Cliente clienteEncontrado;
		
        {
		try {

			clienteEncontrado = ClienteDAO.getInstance().getUserByDNIAndPass(dni, pass);
			boolean dniOK=clienteEncontrado.getDni().equals(dni);
			boolean passOK=clienteEncontrado.getPin().equals(pass);

			assertTrue(dniOK && passOK); //Lo verificamos

		} catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
        
	}
        
	}
}


