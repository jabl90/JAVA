package com.netmind.pojos.books;

public class EBookReader {
	private PDFBook book;
	 
    public EBookReader(PDFBook book) {
        this.book = book;
    }
 
    public String read() {
        return this.book.read();
    }
}
