package net.viralpatel.spring.models;

public class Usuario {
	
	private String name;
	private int edad;
	private String email;
	
	
	public Usuario(String name, int edad, String email) {
	
		this.name = name;
		this.edad = edad;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
