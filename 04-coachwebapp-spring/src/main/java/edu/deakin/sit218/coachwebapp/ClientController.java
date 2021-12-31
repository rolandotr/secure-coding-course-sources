package edu.deakin.sit218.coachwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		//Create a client object
		Client client = new Client();
		
		//add client object to model
		model.addAttribute("client", client);
		
		return "client-form";
	}
	
}

