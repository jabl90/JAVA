package com.jose;
/*- Crea un proyecto que se llame Amigos
- Crea un modelo para Amigo con los campos: id:int, nombre:String,
email:String, edad:int, viveCerca:boolean, misamigos:Amigo[]
- Crea una clase ejecutable "Principal"
- En esta clase crea un amigo "pepe" que debe tener a 
su vez otros amigos: "juan, petra, luisa, lola"
- Haz que para pepe, se muestre por consola la información de cada uno de sus amigos,
 uno por linea. La información a mostrar debe ser por ejemplo:
  "Juan (juan@e.es) 23 años, vive lejos"*/

import com.jose.ModeloAmigo; //Importamos la clase modelo amigo para poder acceder a sus atributos

public class Principal {

	public static void main(String[] args) {

		// Creamos un amigo que se llama Pepe a partir de la clase ModeloAmigo
		
		

		ModeloAmigo pepe = new ModeloAmigo();
		
		pepe.id=898589343;
		pepe.nombre="pepe";
		pepe.email="pepito92@gmail.com";
		pepe.edad=28;
		pepe.viveCerca=true;
		pepe.amigo=null;
		
		
		
		
		
		ModeloAmigo juan = new ModeloAmigo();
		
		juan.id=58789143;
		juan.nombre="juan";
		juan.email="juanito90@gmail.com";
		juan.edad=26;
		juan.viveCerca=true;
		
		ModeloAmigo petra = new ModeloAmigo();
		
		petra.id=56789345;
		petra.nombre="petra";
		petra.email="petrahg@gmail.com";
		petra.edad=24;
		petra.viveCerca=true;
		
		ModeloAmigo luisa = new ModeloAmigo();
		
		luisa.id=96748345;
		luisa.nombre="luisa";
		luisa.email="luisita90@gmail.com";
		luisa.edad=34;
		luisa.viveCerca=true;
		
		ModeloAmigo lola = new ModeloAmigo();
		
		lola.id=66789340;
		lola.nombre="lola";
		lola.email="lolita89@gmail.com";
		lola.edad=25;
		lola.viveCerca=false;
		

		// 
		/*pepe.ModeloAmigo.misamigos(juan);
		pepe.ModeloAmigo.misamigos(petra);
		pepe.ModeloAmigo.misamigos(luisa);
		pepe.misamigos(amigo);
		pepe.ModeloAmigo.misamigos(lola);*/

	}

}
