package com.jose;

public class HelloPrincipal {

	public static void main(String[] args) { /*
												 * main porque se puede ejecutar desde la consola y el void significa
												 * que no devuelve nada (no return). Los argumentos son de tipo string
												 */
		// TODO Auto-generated method stub

		String texto; // Declaramos una variable tipo String
		texto = "Hola";

		String nombre = "Jose";

		String concatenar = texto + " " + nombre;

		int edad = 28;

		double coste = 23.4;

		float coste2 = 67.87f;
		
		double suma =coste+coste2;

		String saludo = texto + " " + nombre + ", tienes " + edad + " años" + ", gano " + coste + " euros al dia y "
				+ coste2 + " euros a la semana";

		System.out.println(saludo);
		
		System.out.println(suma);
	}

}
