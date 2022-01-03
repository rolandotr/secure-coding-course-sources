package edu.deakin.sit218.coachwebapp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class SQLInjectionParametrisedQueryTest {

	public static void main(String[] args) {
		//Ask user to give his/her name
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = scanner.nextLine();
		scanner.close();
		
        String jdbcURL = "jdbc:mysql://localhost/coachappdb?" +
                "user=coachdbadmin&password=coachdbadmin";
		try {
			System.out.println("Connecting to Database");
			Connection conn =
		       DriverManager.getConnection(jdbcURL);
			
			//Perform a query to select all users whose name
			//is equal to the name entered in the command line
			PreparedStatement statement = conn.prepareStatement("select * from client where name = ?");
			statement.setString(1, name);
			System.out.print("Executying query: ");
			System.out.println(statement.toString());
			ResultSet result = statement.executeQuery();

			//Displaying query results
			while (result.next()) {
		        int clientID = result.getInt("id");
		        int workouts = result.getInt("workouts");
		        int age = result.getInt("age");
		        System.out.println(clientID + ", " + name + ", " + age +
		                           ", " + workouts);
			}
			System.out.println("Connection successful!");
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}

	}
	
}
