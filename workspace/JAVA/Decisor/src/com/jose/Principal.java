package com.jose;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a,b,c;
		a=100;
		b=100;
		c=100;
		
	/*	if (a>b) {
			
			System.out.println("a es mayor que b");
			
		} else if (a==b) {
			
			System.out.println("a es igual que b");
		}
			
		else {
			System.out.println("b es mayor que a");

		}
		
*/

//c�digo para ver que variable es mayor de los 3

if(a>b&&a>c){
	System.out.println(" a es el mayor");
}
else if(b>c&&b>a){
	System.out.println("b es el mayor");
	} else if(c>a&&c>b) {
		System.out.println("c es el mayor");
		
	}
else
	{
	System.out.println("hay al menos dos n�meros que son iguales, ");
	}
 
 if (a==b&&c!=a&&c!=b) {
	  System.out.println("a y b son iguales");
 } else if(a==c&&b!=a&&b!=c) {
	 
	 System.out.println("a y c son iguales");
 } else if(b==c&&a!=b&&a!=c) {
	 
	 System.out.println("b y c son iguales");
 }else {
	 
	 System.out.println("todos son iguales");
 }
	
	}
}


