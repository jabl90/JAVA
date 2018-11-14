package com.jose.models;

public class Cancion {
	
	private int id;
	
	private String titulo;
	
	private String autor;
	
	private int duracion;
	
	private String imagen;
	
	private String mp3;

	public Cancion(int id, String titulo, String autor, int duracion, String imagen, String mp3) {
		
		this.id=id;
		this.titulo=titulo;
		this.autor=autor;
		this.duracion=duracion;
		this.imagen=imagen;
		this.mp3=mp3;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getMp3() {
		return mp3;
	}

	public void setMp3(String mp3) {
		this.mp3 = mp3;
	}
	
	

}
