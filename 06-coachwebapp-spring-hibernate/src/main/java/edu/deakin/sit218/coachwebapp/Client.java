package edu.deakin.sit218.coachwebapp;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Client {

	@NotNull(message = "is required")
	@Size(min = 1, message="is required") 
	protected String name;

	@Min(value=18, message = "You must be 18 years old or older")
	@Max(value=120, message = "Vampires are not allowed")
	protected int age;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
