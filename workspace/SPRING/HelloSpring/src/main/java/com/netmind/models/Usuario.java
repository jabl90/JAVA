package com.netmind.models;

import javax.inject.Inject;
import javax.inject.Named;

@Named("usuario")
public class Usuario {

	private int id;
	private String nombre;
	
	@Inject
	private Direccion direccion;
	 
	public Direccion getDireccion() {
		System.out.println("Your Street : " + direccion);
		
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public int getId() {
		
		System.out.println("Your Id : "+id);
		return id;
		
		
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		System.out.println("Your Name : " + nombre);
		return nombre;
		
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
