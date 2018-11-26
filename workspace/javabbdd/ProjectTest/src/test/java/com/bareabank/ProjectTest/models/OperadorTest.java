package com.bareabank.ProjectTest.models;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OperadorTest {

	@Test

	public void testCeros() {

		int a = 0, b = 0;
		Operador op = new Operador();

		assertTrue(op.suma(a, b) == 0);
	}

	@Test
	public void testBSiempreCero() {

		int[] listaA = new int[5];
		listaA[0] = 2;
		listaA[1] = 32;
		listaA[2] = 356;
		listaA[3] = 3457;
		listaA[4] = 345678;
		int b = 0;
		Operador op = new Operador();
		for (int a : listaA) {

			assertTrue(op.suma(a, b) == a);

		}
		
		
		
	}
	
	@Test
	public void testAbsCero() {
		
		int a = 0, b = 0;
		Operador op = new Operador();
		
		
		assertTrue(op.sumaAbs(a, b) == 0);
		
	}
	
	@Test
	public void testSumaAbsPos() {
		
		int a = 5, b = 6;
		Operador op = new Operador();
		
		
		
		assertTrue(op.sumaAbs(a, b) == (a+b));
		
	}
	
	@Test
	public void testSumaAbsNeg() {
		
		int a = -5, b = -6;
		Operador op = new Operador();
		
		assertTrue(op.sumaAbs(a, b) == -(a + b));
		
	}
	
	@Test
	public void testSumaAbsPosNeg() {
		
		int a = -50, b = 6;
		Operador op = new Operador();
		
		assertTrue(op.sumaAbs(a, b) == Math.abs(a + b));
		
	}


}
