package com.jose;

import java.util.*;
import java.text.DecimalFormat; // La tenemos que importar copiando esta linea de c�digo, 
//de lo contrario no nos va a reconocer la clase. Ocurre lo mismo que con la clase Random del ejemplo de clase

public class Pruebas {

	public static void main(String[] args) {

		int a = 8;
		int b = 3;
		int c = 5;

		int suma = a + b + c;
		// Los resultados tambien se podr�an mosstrar guardando la operaci�n en una
		// variable.
		System.out.println(suma);
		System.out.println(a / b); // toca a dos ya que no devuelve decimales.
		System.out.println(a / c); // Da 1, puesto que no nos devuelve decimales
		System.out.println(a * b / c); // 24 entre 5 tocan a cuatro.
		System.out.println((a * b) % c); // El resto de 8x3 entre 5 es 4. Es el resto

		// Como las operaciones a realizar a continuaci�n son mas complejas, vamos a
		// guardar las operacioones en una variable para facilitar la lectura del
		// c�digo.

		int operacion1 = (3 * a - 2 * b) % (2 * a - c); // 18%11 toca a 1, cuyo resto es 7.

		System.out.println(operacion1); // da 7

		int operacion2 = (a - 3 * b) % (c + 2 * a) / (a - c); // da 0

		System.out.println(operacion2);

		int operacion3 = a - b - c * 2;

		System.out.println(operacion3);

		char c1 = 'E';
		char c2 = '5';
		char c3 = '?';

		System.out.println(c1 + 1); // da 70 porque el valor de E en la tablas ASCII es 69;
		System.out.println(c2 - 2); // da 51, mirar tabla ASCII
		System.out.println(c3 + '#'); // da 98, mirar tabla ASCII
		System.out.println('2' + '2'); // da 100

		// Importamos la clase DecimalFormat que nos permite ajustar el numero de
		// decimales a nuestro antojo

		DecimalFormat numberFormat = new DecimalFormat("#.0000"); // Tantos ceros como decimales queramos. En este caso
																	// decimales.

		// double x = 88;
		double y = 3.5;
		double z = -5.2;

		// double v = x / y;
		// double g = x / (y + z);

		// System.out.println(numberFormat.format(v)); // nos imprime el valor de la
		// variable v con los decimales que le
		// hemos indicado. Imprime 25.1429
		// System.out.println(numberFormat.format(g));

		// Operadores l�gicos

		boolean X = true;
		boolean Y = false;
		boolean Z = true;

		boolean o = (X && Y) || (X && Z);

		System.out.println(o); // devuelve true porque al menos una de las dos condiciones es cierta, la
								// segunda.
		boolean h = (X || !Y) && (!X || Z); // True, en la primera expresion ambas son verdaderas y en la segunda lo es
											// la Z.
		boolean p = X || Y && Z; // true, porque X es true.

		System.out.println(h + " " + p);

		// operadores incremento y decremento

		int x = 10;
		System.out.println(x); // 10
		x++; // Incrementa su valor en 1,
		System.out.println(x); // 11
		System.out.println(++x); // 12, Incrementa y luego imprime
		System.out.println(x++); // 12, Imprime 12 y lo incrementa a 13
		System.out.println(x); // Imprimer 13
		System.out.println(x++); // imprime 13 y lo aumenta a 14
		System.out.println(++x); // aumenta a 15 e imprime 15
		System.out.println(++x); // aumenta a 16 e imprime 16
		++x; // 17
		x++; // 17 e incrementa a 18
		System.out.println(++x); // Incrementa a 19 y lo imprime
		System.out.println(x++); // 19 e incrementa a 20
		System.out.println(++x); // incrementa a 21 y lo imprime

		// Tipo Char
		char A = 'c';
		char B;
		System.out.println(A++); // Imprime 'c' y lo aumenta al siguente
		System.out.println(A++); // imprime 'd' y lo aumenta al siguiente ('e')
		System.out.println(++A); // lo aumenta a 'f' y lo imprime.
		B = --A; // B vale 'e', que es uno menos del valor actual de A
		System.out.println(++A); // lo aumenta a 'f' e imprime.
		A++; // vale 'g', y en la proxima linea valdr� 'h';
		--B; // disminuye un valor, 'd';
		System.out.println(B++); // imprime 'd' y lo aumenta a 'e' para la pr�xima linea
		System.out.println(++B); // aumenta a 'f' e imprime 'f';

		int i = 1, j = 1, k = 1;

		i = ++i + --j + k--; // 'i' aumenta a 2 antes de la suma, j a cero y k vale 1: 2+0+1 =3;

		System.out.println(i); // imprime 3

		int N = 5;
		double m = 4.56;
		char C = 'a';
		System.out.println("Variable N = " + N);
		System.out.println("Variable A = " + m);
		System.out.println("Variable C = " + C);
		System.out.println(N + " + " + m + " = " + (N + m));
		System.out.println(m + " - " + N + " = " + numberFormat.format(m - N)); // accedemos al m�todo que nos permite
																				// ajustat el n�mero de decimales
		System.out.println("Valor num�rico del car�cter " + C + " = " + (int) C); // Poniendo delante la palabra
																					// reservada int del nombre de una
																					// variable tipo char, nos devuelve
																					// su valor num�ricoF
		int q = 15;
		System.out.println(q + (q % 2 == 0 ? " es par" : " es impar")); // es equivalente a una expresion condicional
		q = 12;
		// Otra forma. La otra forma arriba mostrada es mucho mas eficiente puesto que
		// solo ocupa una
		// l�nea de c�digo
		if (q % 2 == 0) {
			System.out.println(q + " es par");
		} else {
			System.out.println(q + " es impar");
		}

		/*
		 * Escribe un programa java que declare una variable B de tipo entero y as�gnale
		 * un valor. A continuaci�n muestra un mensaje indicando si el valor de B es
		 * positivo o negativo. Consideraremos el 0 como positivo. Utiliza el operador
		 * condicional ( ? : ) dentro del println para resolverlo.
		 */

		int u = 23;

		System.out.println(u + (u >= 0 ? " es positivo" : " es negativo")); // imprime -1 es negativo
		System.out.println(u + (u % 5 == 0 ? " es multiplo de 5" : " no es multiplo de 5")); // imprime 23 no es
																								// multiplco de 5,
		int ene = 8, jta = 5, ka;
		float equis = 0.005F, ygriega = -0.01F, zeta;
		char aa, be = 'p', ce = 'q'; // porque toca a 4 la
		// division y sobra 3,
		// no cero.
		System.out.println(ygriega > 0 || equis > 0 ? ene + 1 : ene - 1); // da 9

		// declaraci�n de variables
		int n1, n2;
		Scanner sc = new Scanner(System.in); // we're creating an object of a Scanner class.
		// System.in represents standard Input device (Keyboard);
		// leer el primer n�mero
		System.out.println("Introduce un n�mero entero: ");
		n1 = sc.nextInt(); // lee un entero por teclado
		// leer el segundo n�mero
		System.out.println("Introduce otro n�mero entero: ");
		n2 = sc.nextInt(); // lee un entero por teclado
		// mostrar resultado
		System.out.println("Ha introducido los n�meros: " + n1 + " y " + n2);

		int n3;

		System.out.println("Introduce tu edad: ");
		n3 = sc.nextInt(); // Lee un numero entero por teclado
		System.out.println("el doble es: " + n3 * 2 + ", y el triple es: " + n3 * 3);

		Scanner sp = new Scanner(System.in); // Tenemos que crear otro objeto diferente cuando cambiamos el tipo de
												// input (numero, cadena..) que vamos a introducir. En caso contrario,
												// si utliasemos el objeto sc, no nos dejar�a introducir nada en la
												// consola
		String nombre;
		System.out.println("Introduce un nombre: ");
		nombre = sp.nextLine(); // lee una cadena por teclado.
		System.out.println("Buenos D�as " + nombre);
	}

}
