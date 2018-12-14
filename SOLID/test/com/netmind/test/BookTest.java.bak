package com.netmind.test;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.netmind.pojos.books.EBookReader;
import com.netmind.pojos.books.MobiBook;
import com.netmind.pojos.books.NewEBookReader;
import com.netmind.pojos.books.NewPDFBook;
import com.netmind.pojos.books.NewPDFReader;
import com.netmind.pojos.books.PDFBook;
import com.netmind.pojos.books.PDFReader;

public class BookTest {

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
	
	@Test
	public void testItCanReadANewPDFBook() {
		NewPDFBook b = new NewPDFBook();
        NewEBookReader r = new NewEBookReader(b);
        
        Pattern p = Pattern.compile("pdf book");
        Matcher m = p.matcher(r.read());
        
        assertTrue( m.find() );
	}
	
	@Test
	public void testItCanReadANewMobiBook() {
		MobiBook b = new MobiBook();
		NewEBookReader r = new NewEBookReader(b);
        
        Pattern p = Pattern.compile("mobi book");
        Matcher m = p.matcher(r.read());
        
        assertTrue( m.find() );
	}
	
	@Test
	public void testItCanReadAbs() {
		MobiBook b = new MobiBook();
		NewPDFReader r = new NewPDFReader(b);
        
        Pattern p = Pattern.compile("mobi book");
        Matcher m = p.matcher(r.read());
        
        assertTrue( m.find() );
	}

}
