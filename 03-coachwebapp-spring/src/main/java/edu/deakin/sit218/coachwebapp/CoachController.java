package edu.deakin.sit218.coachwebapp;

import java.util.Random;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/workout")
public class CoachController {

	@GetMapping
	public String workout(
			@RequestParam("studentName") String name, Model model) {
		if (name.equals("Rolando")) {
			model.addAttribute("message", "Rolando never workouts");
		} else {
			Random r = new Random();
			if (r.nextBoolean())
				model.addAttribute("message", name+ 
						", please, don't train today");
			else
				model.addAttribute("message", name+ 
						", please, run for 30 min");
		}
		return "workout";
	}

	
}
