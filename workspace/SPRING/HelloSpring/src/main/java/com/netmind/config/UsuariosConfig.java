package com.netmind.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netmind.models.Direccion;
import com.netmind.models.Usuario;

@Configuration //Esta clase funciona como una clase de configuracion en lugar de como un XML
public class UsuariosConfig {
	
	@Bean(name="usuario")  //Este getUsuario va a devolver un bean
	public Usuario getUsuario(){
		
		Usuario unUser=new Usuario();
		unUser.setId(1);
		unUser.setNombre("Jose");

		
		return new Usuario();
		
	}
	@Bean(name="direccion")
	public Direccion getDireccion() {
		Direccion dir=new Direccion();
		dir.setHid(3);
		dir.setCalle("Calle Madrid");
		
		return dir;
		
	}

	
}
