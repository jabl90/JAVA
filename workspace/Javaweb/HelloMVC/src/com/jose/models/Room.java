package com.jose.models;

public class Room {
	
	private int hid;
	
	private String calle;
	
	private int metros;
	
	

	public Room(int hid, String calle, int metros) {
		super();
		this.hid = hid ;
		this.calle = calle;
		this.metros = metros;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getMetros() {
		return metros;
	}

	public void setMetros(int metros) {
		this.metros = metros;
	}
	
	public boolean esValido() {

		boolean isValid = true;

		if (this.calle == null || this.calle.equals("")) isValid = false;
		
		if (this.calle.matches("([a-zA-Z]*)?[0-9](.*)?")) isValid = false; 
		
		if(this.metros<=0) isValid = false;
		
		// Introducimos la expresion regulada que nos machea con el nombre que hemos
		// introducido, debe contener nombres y letras


		return isValid;
	}

}
