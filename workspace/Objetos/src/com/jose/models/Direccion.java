package com.jose.models;

//Direccion es una clase y como no es ejecutable sino que sirve para almacenar conceptos, por eso va dentro de models
public class Direccion {

	public String calle;
	public int numero;
	public String ciudad;

	public String getDireccion() { // Creamos un método que pueda ser llamado en la clase Usuario y que pueda ser
									// accedido a través de la propiedad "dir"

		String address =this.calle + " " + this.numero + ", " + this.ciudad;

		return address;
	}

}
