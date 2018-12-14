package com.netmind.util;

import com.netmind.pojos.books.Book;

public class Printer3D implements PrinterI {

	@Override
	public void print(Book unLibro) {
		System.out.println("Imprimiendo libro en impresora 3D:"+unLibro.getCurrentPage());
		
	}

	@Override
	public void cancelPrint(Book unLibro) {
		
		
	}

	
	
	
	

}
