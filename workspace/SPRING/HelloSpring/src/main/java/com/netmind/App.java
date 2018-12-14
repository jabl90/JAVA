package com.netmind;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netmind.config.UsuariosConfig;
import com.netmind.models.Direccion;
import com.netmind.models.Usuario;

public class App {
	public static void main( String[] args ){
    	/*ApplicationContext context = new ClassPathXmlApplicationContext("resources/beans.xml")*/; //generamos el contexto de bean
    	ApplicationContext context = new AnnotationConfigApplicationContext(UsuariosConfig.class);
    	HelloWorld obj = (HelloWorld) context.getBean("helloWorld"); // le pedimos que nos de el bean correspondiente
         obj.getMessage(); //Nos lo imprime por consola el método que tenmos que HelloWorld

         
         Usuario user = (Usuario) context.getBean("usuario");
         user.getId();
         user.getNombre();
         user.getDireccion().getCalle();
         user.getDireccion().getHid();
         
       //  Usuario user_name = (Usuario) context.getBean("usuario");
        
         
        // Usuario user_direccion = (Usuario) context.getBean("usuario");
        
         
        /* Direccion user_hid = (Direccion) context.getBean("direccion");
         user_hid.getHid();
         
         Direccion user_street = (Direccion) context.getBean("direccion");
         user_street.getCalle();*/
    }
}
