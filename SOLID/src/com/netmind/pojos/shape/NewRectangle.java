package com.netmind.pojos.shape;

public class NewRectangle extends Shape {
    
    public int area(){
    	int area=0;
    	if(sides!=null && sides.length>1)area=sides[0]*sides[1];
    	
    	return area;
    }
}
