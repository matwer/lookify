/**
 * @author Matthew Werner
 * setting up a controller to handle the routes
 **/

package com.shad.lookify.models;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shad.lookify.controllers.Lookify;
import com.shad.lookify.services.LookifyService;

@Controller
public class LookifyController {
	private final LookifyService service;
	
	public LookifyController(LookifyService service) {
		this.service = service;
	}
	
	/**
	 * set up a route to display the landing page
	 **/
	@RequestMapping(value="/")
	public String index() {
		return "index.jsp";
	}
	
	/**
	 * set up a route to display the dashboard
	 **/
	@RequestMapping(value="/dashboard")
	public String main(Model model) {
		model.addAttribute("songs", service.allEntries());
		return "readAll.jsp";
	}
	
	/**
	 * set up a route to render the page to add a new entry
	 **/
	@RequestMapping(value="/songs/add")
	public String showAddForm(@ModelAttribute("song") Lookify song) {
		return "create.jsp";
	}
	
	/**
	 * set up a route for adding new entries to the repo
	 **/
	@RequestMapping(value="/songs/new", method=RequestMethod.POST)
    public String addEntry(@Valid @ModelAttribute("song") Lookify song, 
    		BindingResult result) {
        if (result.hasErrors()) {
            return "create.jsp";
        } else {
        	service.addEntry(song);
            return "redirect:/dashboard";
        }
    }
	
	/**
	 * set up a route for displaying a single entry
	 **/
	@RequestMapping(value="/songs/{id}")
	public String readOne(@PathVariable("id") Long id, Model model) {
		Lookify song = service.findEntry(id);
		model.addAttribute("song", song);
		return "/readOne.jsp";
	}
		
	/**
	 * set up a route for deleting an entry
	 **/
    @RequestMapping(value="/songs/{id}/delete")
    public String delete(@PathVariable("id") Long id, Model model) {
    	Lookify song = service.findEntry(id);
    	model.addAttribute("song", song);
        service.deleteEntry(id);
        return "redirect:/dashboard";
    }
	
	

}
