package com.netmind.test;

import com.netmind.pojos.books.Book;

public class Printer {

	private Book libro;

	public Book getLibro() {
		return libro;
	}

	public void setLibro(Book libro) {
		this.libro = libro;
	}
	
	
public void printCurrentBookPAgeScreen() {
				
			System.out.println("Imprimiendo página en pantalla:"+ this.libro.getCurrentPage());
			
	}

public void printCurrentBookPagePrinter() {
	
	System.out.println("Imprimiendo página en pantalla:"+ this.libro.getCurrentPage());
	
}

public void printCurrentPagePrinterColorines() {

}



	
}
