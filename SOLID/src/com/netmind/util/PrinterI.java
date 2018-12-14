package com.netmind.util;

import com.netmind.pojos.books.Book;

//Una interface es una clase que no tiene cuerpo, dice lo que v a ahacer pero no lo implementa

public interface PrinterI { 
	
	public void print(Book unLibro);
	public void cancelPrint(Book unLibro);

	
	

}
