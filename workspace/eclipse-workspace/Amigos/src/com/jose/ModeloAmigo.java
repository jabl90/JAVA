package com.jose;

import com.jose.Principal;

public class ModeloAmigo {
	
	//Estos son los atributos que debe tener todo objeto 'amigo';
	
	public int id;
	
	public String nombre;
	
	public String email;
	
	public int edad;
	
	public boolean viveCerca;
	
	public String [] amigo;
	
	public String misamigos(String[]miamigo){
		
     String [] amigo = new String[4];
     
     amigo[0]="pepe";
     amigo[1]="juan";
     amigo[2]="petra";
     amigo[3]="luisa";
     amigo[4]="lola";
     
     for(String misamigos : amigo)
    	 
		  System.out.println(misamigos);
     
		return amigo[];
		
	}
	
	}


