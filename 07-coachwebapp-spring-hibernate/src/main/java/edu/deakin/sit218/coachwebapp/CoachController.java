package edu.deakin.sit218.coachwebapp;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.deakin.sit218.coachwebapp.dao.ClientDAO;
import edu.deakin.sit218.coachwebapp.dao.ClientDAOImpl;
import edu.deakin.sit218.coachwebapp.entity.Client;

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

		//Retrieve Client object from database
		
		//Check whether the client doesn't exist
		ClientDAO dao = new ClientDAOImpl(); 
		if (!dao.existsClient(client)) 
			dao.insertClient(client); //If not, save it
		//This client object is identical to a row in the database
		client = dao.retrieveClient(client);

		//Logic when there is no error
		//Decide on the type of workout.
		if (client.getName().equals("Rolando")) {
			model.addAttribute("message", "Rolando never workouts");
		} 
		else if (client.getAge() < 40) {
			model.addAttribute("message", "Hey, " + client.getName()+ 
					" you are still too young, no need to work out!");
		}
		else {
				model.addAttribute("message", client.getName()+ 
						", please, run for 30 min."+
						System.lineSeparator()+ 
						" You have worked out "+client.getWorkouts()+
						" times.");
				client.addWorkout();				
		}
		
		//Sync Client object with database
		dao.updateClient(client);
		
		//Return the View 
		return "workout";
	}
	
}
