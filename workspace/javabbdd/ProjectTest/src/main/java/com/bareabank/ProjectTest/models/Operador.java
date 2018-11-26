package com.bareabank.ProjectTest.models;

import static org.junit.Assert.assertTrue;

public class Operador {
	
	//Método que suma dos enteros
	
	public int suma(int a, int b) {
		
		return a+b;
	}
	
	public int sumaAbs(int a, int b) {
		
		int res =a+b;
		
		if(res<0) res=-res;
		return res;
	
	}

}
