package com.jose.models;

public class Employee {

	private int id;
	private String nombre;
	private String apellido;
	
	
	//hibernate necesit una constructor sin parámetros
	
public Employee() {
		
	}
	
	public Employee(int id, String nombre, String apellido) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}


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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String appellido) {
		
		this.apellido = appellido;
	}
	
	
}
