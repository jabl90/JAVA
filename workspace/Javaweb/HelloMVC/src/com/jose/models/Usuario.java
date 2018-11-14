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

	

	

}
