package com.netmind.pojos.shape;

public abstract class Shape {
	protected int[] sides;
	public abstract int area();
	
	public int[] getSides() {
		return sides;
	}
	public void setSides(int[] sides) {
		this.sides = sides;
	}
	
	
}
