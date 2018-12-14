package com.netmind.util;

import com.netmind.pojos.books.Book;

public class ScreenPrinter implements PrinterI {
	@Override
	public void print(Book unLibro) {
		
		System.out.println("Imprimiendo en pantalla: "+unLibro.getCurrentPage());
		
		
	}

	@Override
	public void cancelPrint(Book unLibro) {
		
		
	}

	
	

	
}
