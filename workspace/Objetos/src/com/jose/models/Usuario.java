package com.jose.models;

//falta el main y el void porque no es ejecutable, no nos va a devolver nada

public class Usuario {

	public String nombre; // al ser public las variables quiere decir que podemos acceder a ellas desde
							// otras clases.
	public String apellido;
	public String email;
	public int edad;
	public Direccion dir; // Esto es una composici�n, estamos componiendo una clase utilizando otras
							// clases. Es decir estamos utlizando la clase Direccion para componer la clase usuario.

	public String getDatosCompletos() { // Estamos creando un m�todo. Es buena practica que los metodos empiecen por un
										// verbo que nos indique lo que hacen

		String datos = this.nombre + " " + this.apellido + " " + this.email + " " + this.edad+", Direcci�n:  "+this.dir.getDireccion();// como estamos dentro de
																								// la clase, para accder
																								// a sus propiedades
																								// utilizamos this.

		return datos;// nos devuelve el valor que tenemos en datos, y s�lo puede ser uno.
	}

}
