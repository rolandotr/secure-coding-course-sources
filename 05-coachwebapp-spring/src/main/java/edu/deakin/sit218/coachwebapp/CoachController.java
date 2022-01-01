package edu.deakin.sit218.coachwebapp;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/workout")
public class CoachController {

	@RequestMapping("/processForm")
	public String workout(
			@Valid @ModelAttribute("client") Client client, 
			BindingResult validationErrors, Model model) {
		//Input validation
		if (validationErrors.hasErrors())
			return "client-form";
		//Logic when there is no error
		if (client.getName().equals("Rolando")) {
			model.addAttribute("message", "Rolando never workouts");
		} 
		else if (client.age < 40) {
			model.addAttribute("message", "Hey, " + client.getName()+ 
					" you are still too young, no need to work out!");
		}
		else {
				model.addAttribute("message", client.getName()+ 
						", please, run for 30 min");
		}
		return "workout";
	}
	
}
