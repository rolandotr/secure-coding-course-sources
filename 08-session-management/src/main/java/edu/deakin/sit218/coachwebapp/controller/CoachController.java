package edu.deakin.sit218.coachwebapp.controller;


import javax.servlet.http.HttpServletRequest;
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
public class CoachController {

	@RequestMapping("/workout")
	public String workout(
			Model model, HttpServletRequest request) {

		String userId = (String)request.getParameter("user");
		
		ClientDAO dao = new ClientDAOImpl();
		
		Client client = dao.retrieveClientByID(Integer.parseInt(userId));
		//Retrieve Client object from database
		giveWorkoutToClient(client, model);
		
		//Return the View 
		return "workout";
	}
	
	private void giveWorkoutToClient(Client client, Model model) {
		if (client.getUsername().equals("Rolando")) {
			model.addAttribute("message", "Rolando never workouts");
		} 
		else if (client.getAge() < 40) {
			model.addAttribute("message", "Hey, " + client.getUsername()+ 
					" you are still too young, no need to work out!");
		}
		else {
				model.addAttribute("message", client.getUsername()+ 
						", please, run for 30 min."+
						System.lineSeparator()+ 
						" You have worked out "+client.getWorkouts()+
						" times.");
				client.addWorkout();
				ClientDAO dao = new ClientDAOImpl();
				dao.updateClient(client);
		}
	}

}
