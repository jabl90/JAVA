package com.netmind.test;

import static org.junit.Assert.assertTrue;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.netmind.pojos.books.Book;
import com.netmind.pojos.books.EBookReader;
import com.netmind.pojos.books.PDFBook;
import com.netmind.pojos.books.PDFReader;
import com.netmind.util.Downloader;
import com.netmind.util.IntranetDownloader;
import com.netmind.util.Printer3D;
import com.netmind.util.PrinterFactory;
import com.netmind.util.PrinterI;
import com.netmind.util.ScreenPrinter;

public class BookTest {
	@Test
	public void testBookPrint() {
		
		Book aBook = new Book("Cien años de soledad", "GGMárquez",1);
		Printer imprimidor=new Printer();
		
		imprimidor.printCurrentPagePrinterColorines();
		aBook.turnPage();
		
	}

	@Test
	public void testBookPrinter() {
		Book aBook = new Book("Cien años de soledad","GGMàrquez",1);
		PrinterI unPrinter= new Printer3D();
		
		unPrinter.print(aBook);
	}
	
	@Test
	public void testBookPrinterFactory() {
		Book aBook = new Book("Cien años de soledad","GGMàrquez",1);
		PrinterI unPrinter= PrinterFactory.createPrinter("3d");
		
		unPrinter.print(aBook);
	}
		
		@Test
		public void testBookDownloader() {
			Book aBook = new Book("Cien años de soledad","GGMàrquez",1);
			Downloader unDwnldr= new IntranetDownloader();
			
			unDwnldr.setaBook(aBook);
			unDwnldr.download();
			
	}
	@Test
	public void testItCanReadAPDFBook() {
		PDFBook b = new PDFBook();
        PDFReader r = new PDFReader(b);
        
        Pattern p = Pattern.compile("pdf book");
        Matcher m = p.matcher(r.read());
        
        assertTrue( m.find() );
	}
	
	@Test
	public void testItCanReadAPDFBookGen() {
		PDFBook b = new PDFBook();
        EBookReader r = new EBookReader(b);
        
        Pattern p = Pattern.compile("pdf book");
        Matcher m = p.matcher(r.read());
        
        assertTrue( m.find() );
	}
	
	

}
