package com.netmind.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.netmind.pojos.shape.Rectangle;
import com.netmind.pojos.shape.Square;
import com.netmind.util.Client;

public class LspTest {
	
	@Test
	public void testRectangleArea() {
		Rectangle r = new Rectangle();
        Client c = new Client();
		
        assertTrue(c.areaVerifier(r));
	}
	
	@Test
	public void testSquareArea() {
		Square s = new Square();
        Client c = new Client();
		
        assertTrue(c.areaVerifier(s));
	}

}
