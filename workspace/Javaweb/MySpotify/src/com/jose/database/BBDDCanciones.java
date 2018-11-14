package com.jose.database;

import java.util.ArrayList;

import com.jose.models.Cancion;


public class BBDDCanciones {

	//almacenar las canciones en una lista
	
	
	public ArrayList<Cancion> canciones = new ArrayList<Cancion>();
	
	private boolean filllistacancion(){
		
		canciones.add(new Cancion(1,"Let it be","The Beatles",5000,"imagen1.png","let.mp3") );
		canciones.add(new Cancion(2,"Blowing in the wind","Bob Dylan",4000,"imagen2.png","b.mp3") );
		
		return true;
	}
	
public Cancion getListaCancion(int id) {//recibe un parametro tipo int, que es el identificador de la cancion
		
		Cancion devolverlistacanciones=null; 
		
	return devolverlistacanciones; //devolvemos la lista de canciones
	}
	
	
	public Cancion getCancion(int id) {//recibe un parametro tipo int, que es el identificador de la cancion
		
		Cancion cancionadevolver=null; //definimos una variable local que va acontener el valor que le vamos asignar
		
		//vamos a buscar en la lista de canciones. Iteramos por cada cancion y comparamos su identificador con el que nos indica
		
		for (Cancion lacancion : canciones) {
			
			if(lacancion.getId()==id) {
			cancionadevolver = lacancion;
			break; //sale del for, para que cuando encuentre la cancion no siga buscando
		}
		}
	return cancionadevolver; //devolvemos la cancion
	}
	
	
}
