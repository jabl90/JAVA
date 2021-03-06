/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.web;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javatunes.domain.MusicCategory;
import com.javatunes.service.Catalog;
import com.sun.org.apache.xerces.internal.impl.dtd.models.CMUniOp;

@Controller
@RequestMapping("/home")      // Map controller to /home
public class HomeController {
	
	// Inject a catalog
	@Inject
	Catalog cat;

	// Optional - Method to add reference data into model
	public Collection<MusicCategory> populateCategories() {
		ArrayList<MusicCategory> categories = new ArrayList<MusicCategory>();
		for (MusicCategory cat : MusicCategory.values()) {
			categories.add(cat);
		}
		return categories;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String get(@ModelAttribute("search") Search search, Model model) {
		search.setKeyword("Diva");
		model.addAttribute("categories",MusicCategory.values());
		return "home";
	}

	// Handler method to process the search form submission
	// Uses optional searchCategory functionality
	@RequestMapping(method = RequestMethod.POST)
	public String processSearch(@ModelAttribute("search") Search search, Model model) {
		System.out.println("SearchController.processSearch()");
		model.addAttribute("categories",MusicCategory.values());
		String keyword = search.getKeyword();
		System.out.println("keyword = " + keyword);
		System.out.println("category = " + search.getCategory());
		search.setMatches(cat.findByKeyword(keyword));
		return "home";
	}
}