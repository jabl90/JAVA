package com.netmind.test;

import static org.junit.Assert.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import com.netmind.pojos.*;
import com.netmind.pojos.shape.NewRectangle;
import com.netmind.pojos.shape.NewSquare;
import com.netmind.pojos.shape.Shape;
import com.netmind.util.AreaCalculator;

public class TestAreaCalculator {
	private static Logger logger= Logger.getLogger("TestAreaCalculator");
	
	@Test
	public void test() {
		NewRectangle rect=new NewRectangle();
		rect.setSides(new int[]{2,3});

		NewSquare sq=new NewSquare();
		sq.setSides(new int[]{2});
		
		AreaCalculator ac= new AreaCalculator( new Shape[]{rect,sq} );
		
		assertEquals(10, ac.suma());
	}

}
