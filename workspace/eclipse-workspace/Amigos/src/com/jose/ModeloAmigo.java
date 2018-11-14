package com.jose;

import java.util.ArrayList;

public class ModeloAmigo {

	// Estos son los atributos (propiedades) que debe tener todo objeto 'amigo'; Conviene hace rprivadas las propiedades

	private int id;

	private String nombre;

	private String email;

	private int edad;

	private boolean viveCerca;

	private ArrayList<ModeloAmigo> misamigos; // La variable misamigos es un array de esa misma clase, y por ende se tiene que
									// llamar igual
//Creamos un cosntructor

	// al concepto de crear diferentes metodos cond diferentes parametros se llama
	// overloading;

	public ModeloAmigo() { // los constructores siemppre tienen ele mismo nombre que la clase. Sirven para
							// crear objetos

	}

	public ModeloAmigo(int id, String nombre, String email, int edad, boolean viveCerca) {
		// super(); //Se refiere a la clase padre, no hace falta
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
		this.viveCerca = viveCerca;
	}

	public String showinfo() { // Es string porque la consola sólo muestra string. Tambien podríamos tener
								// diferentes metodos con el mismo nombre y diferentes tributos

		String texto = "";

		texto += "id: " + this.id + "\n";
		texto += "nombre : " + this.nombre + "\n";
		texto += "email : " + this.email + "\n";
		texto += "edad : " + this.edad + "\n";
		// texto += "viveCerca : " + this.viveCerca +"\n";

		texto += "AMIGOS:\n";

		for (ModeloAmigo amigo : this.misamigos) {

			if (amigo != null)

				texto += amigo.nombre + "(" + amigo.email + ")" + (amigo.viveCerca ? "Vive cerca" : "Vive lejos")
						+ "\n";
		}

		return texto;
	}
//Setters y getters nos permiten controlar los cambios; Get da el valor d euna propiedad concreta y el set te lo cambia.
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isViveCerca() { //se pone is en lugar de get en los booleanos
		return viveCerca;
	}

	public void setViveCerca(boolean viveCerca) {
		this.viveCerca = viveCerca;
	}

	public ArrayList<ModeloAmigo> getMisamigos() {
		return misamigos;
	}

	public void setMisamigos(ArrayList<ModeloAmigo> misamigos) {
		this.misamigos = misamigos;
	}

}

