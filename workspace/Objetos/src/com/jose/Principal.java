package com.jose;

import com.jose.models.Direccion;
import com.jose.models.Usuario; //hemos importado la clase Usuario (hay que darle al cntl espacio)

public class Principal {

	public static void main(String[] args) {

		Usuario pepito = new Usuario(); // tenemos una variable pepito que esta apuntando a un objeto Usuario. Es decir,
										// estamos creando una instancia, creando un objeto a partir de la definicion.

		pepito.nombre = "Jose"; // asignamos valores a las propiedades declaradas en la clase usuario.
		pepito.apellido = "Barea";
		pepito.email = "jose.barealpz@gmail.com";
		pepito.edad = 28;

		Direccion aDir = new Direccion(); // Estamos creando una instancia; Creamos una variable externa (adir) y la
											// estamos apuntando aun objeto

		aDir.calle = "C/C�ceres";
		aDir.numero = 18;
		aDir.ciudad = "Getafe";

		pepito.dir = aDir;

		// Otra manera de hacerlo, en la que cogemos directamente la porpiedad del
		// objeto usuario "dir" y la apuntamos al objeto.

		/*
		 pepito.dir=new Direccion(); 
		 pepito.dir.calle="C/C�ceres";
		 pepito.dir.numero=18; 
		 pepito.dir.ciudad="Getafe";
		 
		 */

		/*
		 * System.out.println("Nombre y apellidos: "+pepito.nombre+" "+pepito.apellido);
		 * System.out.println("Email: "+pepito.email);
		 * System.out.println("Edad: "+pepito.edad+" a�os");
		 */

		System.out.println(pepito.getDatosCompletos()); // nos devuelve el valor que nos devuelve el m�todo.

	}

}