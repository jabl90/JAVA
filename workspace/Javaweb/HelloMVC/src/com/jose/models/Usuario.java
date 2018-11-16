package com.jose.models;

//ESto seria el modelo
public class Usuario {

	private int id;

	private String name;

	private String email;

	private String password;

	private Room room;

	public Usuario(int id, String name, String email, String password, Room room) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.room = room;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	// Valida que los campos sean correctos, bien formados y tengan valor
	public boolean esValido(String passwordrecibidoconfirmado) {

		boolean isValid = true;

		if (this.email == null || this.email.equals("") || this.email.indexOf("@") <= 0)
			isValid = false;

		if (this.name == null || this.name.equals("") || this.name.matches("(.*)?[0-9](.*)?"))
			isValid = false; // Introducimos la expresion regulada que nos machea con el nombre que hemos
		// introducido, debe contener nombres y letras

		if (this.password == null || this.password.equals(""))
			isValid = false;

		if (!this.password.equals(passwordrecibidoconfirmado))
			isValid = false;
		
		if(this.room==null) isValid=false;

		return isValid;
	}

}
