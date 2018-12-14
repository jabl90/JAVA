package com.javatunes.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javatunes.domain.MusicCategory;
import com.javatunes.domain.MusicItem;

@Controller
@RequestMapping("/create")
public class CreateItemController {

	@RequestMapping(method = RequestMethod.GET)
	public String get(@ModelAttribute("MusicItem")  MusicItem item, Model model) {
		
		model.addAttribute("categories", MusicCategory.values());
		return "create";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSearch(@ModelAttribute("MusicItem")  MusicItem item, Model model) {
		
		model.addAttribute("categories", MusicCategory.values() );
		
		System.out.println("New Item: "+item);
	
		cat.persist(item);
		return "create";
	}
}



