package com.netmind.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.netmind.pojos.shape.Shape;

public class AreaCalculator {
	protected Shape[] shapes;
	private static Logger logger= Logger.getLogger("AreaCalculator");
	
	public AreaCalculator(Shape[] formas){
		this.shapes=formas;
	}
	
	public int suma(){
		
		int result=0;
		if(shapes!=null) for(Shape ashape:shapes) {
			//logger.log(Level.INFO, "lados "+ashape.getClass().getName()+": "+ashape.getSides().length+"; area: "+ashape.area());
			result+=ashape.area();
		}
		
		//logger.log(Level.INFO, "Suma de areas: "+result);
		return result;
	}
}
