package com.netmind.util;

import com.netmind.pojos.books.Book;

public abstract class Downloader {
	
	private Book  aBook;


	public Book getaBook() {
		return aBook;
	}

	public void setaBook(Book aBook) {
		this.aBook = aBook;
	} 
	
//Contrato 
	public abstract void download();


}
