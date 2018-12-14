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
import com.javatunes.domain.MusicItem;
import com.javatunes.service.Catalog;
import com.sun.org.apache.xerces.internal.impl.dtd.models.CMUniOp;

@Controller
@RequestMapping("/create") // Map controller to /home
public class CreateItemController {

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
	public String get(@ModelAttribute("item") MusicItem item, Model model) {
		model.addAttribute("categories", populateCategories());
		return "create_view";
	}

	// Handler method to process the search form submission
	// Uses optional searchCategory functionality
	@RequestMapping(method = RequestMethod.POST)
	public String processSearch(@ModelAttribute("item") MusicItem item, Model model) {

		model.addAttribute("categories", populateCategories() );
		System.out.println("!!!!!New Item = " + item);

		cat.persist(item);
		return "create_view";
	}
}












