package com.netmind.pojos.books;

public class Book {
	
	private String titulo;
	private String autor;
	private int currentPage;
	
	
	public Book(String titulo, String autor, int currentPage) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.currentPage = currentPage;
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

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentpage) {
		this.currentPage = currentpage;
	}
	
	
	

	public void turnPage() {
		System.out.println("Imprimiendo página en impresora: "+this.currentPage);
		
	}

	
	
	

}
