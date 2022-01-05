package edu.deakin.sit218.coachwebapp.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.deakin.sit218.coachwebapp.dao.ClientDAO;
import edu.deakin.sit218.coachwebapp.dao.ClientDAOImpl;
import edu.deakin.sit218.coachwebapp.entity.Client;

@Controller
public class LoginController {



	@RequestMapping("/showLogin")
	public String login() {
		return "plain-login";
	}

	@RequestMapping("/authenticateTheUser")
	public String authenticateTheUser(
			@RequestParam("username") String username, 
			@RequestParam("password") String password, 
			Model model, HttpServletRequest request) {
		
		ClientDAO dao = new ClientDAOImpl(); 
		
		if (dao.areCredentialsCorrect(username, password)) {
			//Logic for when the client is exists
			Client client = dao.retrieveClient(username);
			//Now that the client is authenticated
			//We handle the logic to the CoachController. 
			/*
			HttpSession session = request.getSession();
            session.setAttribute("user", client.getUsername());
			return "redirect:/workout";
			*/
			return "redirect:/workout?user="+client.getId();
		}
		else {
			//Logic for when the client doesn't exist
			model.addAttribute("errorMessage", "Wrong combination of password and username");
			return "plain-login";
		}		
	}


	
}
