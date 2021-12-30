package edu.deakin.sit218.coachwebapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CoachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CoachServlet() {
        super();
    }

		protected void service(HttpServletRequest request, HttpServletResponse 
		response) throws ServletException, IOException {
		
			PrintWriter out = response.getWriter();
			Random r = new Random();
			if (r.nextBoolean())
				out.println("<HTML> <h1> No training today "
						+ "</h1> </HTML>");
			else
				out.println("<HTML> <h1> Spend 30 min running "
						+ "</h1> </HTML>");
			
		}

}
