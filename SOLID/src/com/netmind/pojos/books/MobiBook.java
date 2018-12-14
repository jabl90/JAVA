package com.netmind.pojos.books;

public class MobiBook implements EBook{

	public String read() {
		return "reading a mobi book.";
	}

	@Override
	public int genX() {
		// TODO Auto-generated method stub
		return 0;
	}

}
