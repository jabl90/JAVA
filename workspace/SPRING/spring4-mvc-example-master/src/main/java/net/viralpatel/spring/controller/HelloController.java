package net.viralpatel.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.viralpatel.spring.models.Usuario;
//Hace la función de un Servlet
@Controller
public class HelloController {

	@GetMapping("/hello")
	public String hello(Model model) {

		model.addAttribute("name", "John Doe");

		return "welcome"; //el return es la vista donde quiero pintar la informacion
	}
	
	@RequestMapping(name="/usuario", method=RequestMethod.GET)
	public String usuario(Model Usuario) {

		Usuario.addAttribute("usuario", new Usuario("Jose",25,"jose.gmail@gmail.com"));

		return "usuario";
	}
}
