package com.jose.models;

public class Amigo {
	
	private String name;

	private String mote;

	private int edad;

	private String email;

	private String password;

	public Amigo(String name, String mote, int edad, String email, String password) {
		
		this.name = name;
		this.mote = mote;
		this.edad = edad;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMote() {
		return mote;
	}

	public void setMote(String mote) {
		this.mote = mote;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	// Valida que los campos sean correctos, bien formados y tengan valor
	public boolean esValido(String elmote) {

		boolean isValid = true;

		if (this.email == null || this.email.equals("") || this.email.indexOf("@") <= 0)
			isValid = false;

		if (this.name == null || this.name.equals("") || this.name.matches("(.*)?[0-9](.*)?"))
			isValid = false; 
		
		if (this.mote == null || this.mote.equals("") || this.mote.matches("(.*)?[0-9](.*)?"))
			isValid = false; 

		if (this.password == null || this.password.equals(""))
			isValid = false;

		if (this.name.equals(elmote))
			isValid = false;
		
		if(this.edad==0 || this.edad>90) isValid=false;

		return isValid;
	}

}
