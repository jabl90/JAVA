package com.netmind.pojos.books;

public class PDFReader {
	private PDFBook book;
	 
    public PDFReader(PDFBook book) {
        this.book = book;
    }
 
    public String read() {
        return this.book.read();
    }
}
