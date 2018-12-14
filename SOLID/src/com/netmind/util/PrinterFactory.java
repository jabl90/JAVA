package com.netmind.util;

public class PrinterFactory {
	
	public static PrinterI createPrinter(String tipo) { //Nos devuelv eun objeto de tipo abstracto PrinterI
		
		if(tipo.equals("screen")) {
			
			return new ScreenPrinter();
			
			
		}else if(tipo.equals("3d")) {
			
			return new Printer3D();
			
		}else {
			return null;
		}
	}

}
