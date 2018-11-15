package com.jose.database;

import java.util.ArrayList;

import com.jose.models.Room;
import com.jose.models.Usuario;

public class BBDD {

	private static BBDD instancia = null; //// hemos hecho una instancia, tiene ser privada y del mismo tipo de la clase
											//// SINGLETON

	public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	public ArrayList<Room> habitaciones = new ArrayList<Room>();

	public static final BBDD getinstancia() { // Es un meotod publico que me devuuleve la instancia. No se puede
												// utilizar el this porque es stático y es comun a todos los obejtos. No
												// necesita un new
												// porque ya qestoy creando aqui la instancia. Creamos directamente le
												// bojeto con el método SINGLETON
		if (instancia == null) {
			instancia = new BBDD();
		}

		return instancia;
	}

	private BBDD() {// desde el contructir llamamos alos metodos. //hacemso el constructor privado
					// nadie puede hacer new BBDD

		this.fillUsuarios();
		this.fillhabitaciones();
		this.relacionarUSerHab();
	}

	// Estos metodos privados llenan de informacion los arrays
	private boolean fillUsuarios() {

		usuarios.add(new Usuario(0, "pepito", "pepitopalotes@gmail.com", "ppp", null));
		usuarios.add(new Usuario(1, "luisita", "luisalotes@gmail.com", "lll", null));
		usuarios.add(new Usuario(2, "Peter Parker", "peterparker@gmail.com", "spiderman", null));

		return true;
	}

	private boolean fillhabitaciones() {

		habitaciones.add(new Room(101, "Gran via 59", 200));
		habitaciones.add(new Room(202, "Paseo de la Castellana 62", 280));
		habitaciones.add(new Room(303, "Calle Princesa 31", 300));

		return true;
	}

	private boolean relacionarUSerHab() {

		usuarios.get(0).setRoom(habitaciones.get(1));
		usuarios.get(1).setRoom(habitaciones.get(2));
		usuarios.get(2).setRoom(habitaciones.get(0));

		return true;
	}

//queremos que nos devuelva un usuario. Es un metodo que en funcion del identifcador nos dvuelve un objeto usuario concreto
//Si no existe devuelve null

	public Usuario getUsuarioByID(int id) {// recibe un parametro tipo int, el identificador

		Usuario usuarioadevolver = null; // definimos una variable local que va acontener el valor que le vamos asignar

		// vamos a buscar en la lista de usuarios. Iteramos por cada usuario y
		// comparamos su identificador con el que nos indica

		for (Usuario unUsuario : usuarios) {

			if (unUsuario.getId() == id) {
				usuarioadevolver = unUsuario;
				break; // sale del for, para que cuando encuentre nuestro usuario no siga buscando
			}
		}
		return usuarioadevolver; // devolvemos el usuario
	}

	public Room gethabitacion(int hid) {// recibe un parametro tipo int, el numero de la habitación

		Room habitacionusuario = null;

		for (Room lahabitacion : habitaciones) {

			if (lahabitacion.getHid() == hid) { // si la habitacion coincide con el getter de la clase Roon getHig y el
												// el identificador
				habitacionusuario = lahabitacion;
				break; // sale del for, para que cuando encuentre nuestro usuario no siga buscando
			}
		}
		return habitacionusuario; // devuelve la habitacion en la que está el usuario
	}

	public boolean existeUsuarioPorEmailyPass(String emailrecibido, String passwordrecibido) {

		boolean existeusuario = false;

		for (Usuario unUsuario : this.usuarios) {

			if (unUsuario.getEmail().equals(emailrecibido) && (unUsuario.getPassword().equals(passwordrecibido))) {
				existeusuario = true;
				break;
			}
		}

		return existeusuario;
	}

	public int insertaUsuario(Usuario newuser) {

		int nuevoId = 0;

		nuevoId = this.usuarios.size() + 1; // simulamos que la bd asigna un id consecutivo
		newuser.setId(nuevoId);
		
		this.usuarios.add(newuser); //añadimos el usuario
		
		return nuevoId;

	}
}
